package com.alexander.sistema_cerro_verde_backend.service.ventas.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexander.sistema_cerro_verde_backend.entity.ventas.Cliente;
import com.alexander.sistema_cerro_verde_backend.repository.recepcion.ReservasRepository;
import com.alexander.sistema_cerro_verde_backend.repository.ventas.ClienteRepository;
import com.alexander.sistema_cerro_verde_backend.service.ventas.ClientesService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
public class ClientesServiceImpl implements ClientesService{
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private ClienteRepository repoClientes;

    @Autowired
    private ReservasRepository repoReservas;

    @Override
    public List<Cliente> buscarTodos() {
        return repoClientes.findAll();
    }

    @Override
    public List<Cliente> buscarActivos(){
        return repoClientes.findActive();
    }

    @Override
    public Optional<Cliente> buscarPorId(Integer id){
        return repoClientes.findById(id);
    }

    @Override
    @Transactional
    public void guardar(Cliente cliente){
        Optional<Cliente> existente = repoClientes.findByDniRucIgnoreCase(cliente.getDniRuc());
        if(existente.isPresent()){
            Cliente c = existente.get();
            if(c.getEstado() == 0){
                System.out.println(c.getDniRuc());
                c.setEstado(1);
                c.setNombre(cliente.getNombre());
                c.setCorreo(cliente.getCorreo());
                c.setPais(cliente.getPais());
                c.setTelefono(cliente.getTelefono());
                entityManager.merge(c);
            } else {
                repoClientes.save(cliente);
            }
        } else {
            cliente.setEstado(1);
            repoClientes.save(cliente);
        }
    }

    @Override
    public void modificar(Cliente cliente){
        repoClientes.save(cliente);
    }

    @Override
    public void eliminar(Integer id){
        if (repoReservas.existsReservas(id)) {
            throw new IllegalStateException("El cliente tiene reservas o venta registradas");
        }

        repoClientes.deleteById(id);
    }
}
