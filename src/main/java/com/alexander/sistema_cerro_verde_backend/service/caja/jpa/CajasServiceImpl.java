package com.alexander.sistema_cerro_verde_backend.service.caja.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexander.sistema_cerro_verde_backend.entity.caja.Cajas;
import com.alexander.sistema_cerro_verde_backend.entity.seguridad.Usuario;
import com.alexander.sistema_cerro_verde_backend.repository.caja.CajasRepository;
import com.alexander.sistema_cerro_verde_backend.service.caja.CajasService;

@Service
public class CajasServiceImpl implements CajasService {

    @Autowired
    private CajasRepository repository;

    @Override
    public List<Cajas> buscarTodos() {
        return repository.findAll();
    }

    @Override
    public List<Cajas> buscarCajasCerradas() {
        return repository.findAllByEstadoCaja("cerrada");
    }

    @Override
    public Optional<Cajas> buscarId(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Optional<Cajas> buscarCajaAperturada() {
        return repository.findByEstadoCaja("abierta");
    }

    @Override
    public Cajas guardar(Cajas caja) {
        return repository.save(caja);
    }

    @Override
    public void eliminarId(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Cajas> buscarCajaAperturadaPorUsuario(Usuario usuario) {
        return repository.findByUsuarioAndEstadoCaja(usuario, "abierta");
    }

    @Override
    public Optional<Cajas> buscarCajaPorUsuario(Usuario usuario) {
        return repository.findByUsuario(usuario);
    }

    
    
}
