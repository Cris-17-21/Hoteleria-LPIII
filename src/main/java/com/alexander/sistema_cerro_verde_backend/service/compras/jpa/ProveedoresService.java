package com.alexander.sistema_cerro_verde_backend.service.compras.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexander.sistema_cerro_verde_backend.entity.compras.Proveedor;
import com.alexander.sistema_cerro_verde_backend.repository.compras.ProveedorRepository;
import com.alexander.sistema_cerro_verde_backend.service.compras.IProveedoresService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
public class ProveedoresService implements IProveedoresService {
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private ProveedorRepository repoProveedores;

    @Override
    public List<Proveedor> buscarTodos() { //Buscar todos los proveedores
        return repoProveedores.findAll();
    }

    @Override
    public List<Proveedor> buscarActivos() { //Buscar los proveedores activos
        return repoProveedores.findActive();
    }

    @Override
    @Transactional
    public void guardar(Proveedor proveedor) {
        Optional<Proveedor> existente = repoProveedores.findByRucIncludingInactives(proveedor.getRuc_proveedor());
        if (existente.isPresent()) {
            Proveedor prov = existente.get();
            if (prov.getEstado() == 0) {
                prov.setEstado(1);
                prov.setRazon_social(proveedor.getRazon_social());
                prov.setDireccion(proveedor.getDireccion());
                entityManager.merge(prov);
            } else {
                repoProveedores.save(proveedor);
            }
        } else {
            proveedor.setEstado(1);
            repoProveedores.save(proveedor);
        }
    }

    @Override
    public void modificar(Proveedor proveedor) {
        repoProveedores.save(proveedor);
    }

    @Override
    public Optional<Proveedor> buscarId(String ruc_proveedor) {
        return repoProveedores.findById(ruc_proveedor);
    }

    @Override
    public void eliminar(String ruc_proveedor) {
        repoProveedores.deleteById(ruc_proveedor);
    }
}
