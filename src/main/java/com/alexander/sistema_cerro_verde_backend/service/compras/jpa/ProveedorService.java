package com.alexander.sistema_cerro_verde_backend.service.compras.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexander.sistema_cerro_verde_backend.entity.compras.Proveedor;
import com.alexander.sistema_cerro_verde_backend.repository.compras.ProveedorRepository;
import com.alexander.sistema_cerro_verde_backend.service.compras.IProveedorService;

@Service
public class ProveedorService implements IProveedorService {

    @Autowired
    private ProveedorRepository repoProveedor;

    @Override
    public List<Proveedor> buscarTodos() {
        return repoProveedor.findAll();
    }

    @Override
    public void guardar(Proveedor proveedor) {
        repoProveedor.save(proveedor);
    }

    @Override
    public void modificar(Proveedor proveedor) {
        repoProveedor.save(proveedor);
    }

    @Override
    public Optional<Proveedor> buscarId(String rucProveedor) {
        return repoProveedor.findById(rucProveedor);
    }

    @Override
    public void eliminar(String rucProveedor) {
        repoProveedor.deleteById(rucProveedor);
    }
}
