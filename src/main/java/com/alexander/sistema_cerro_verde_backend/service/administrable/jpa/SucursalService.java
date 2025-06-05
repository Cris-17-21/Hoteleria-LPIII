package com.alexander.sistema_cerro_verde_backend.service.administrable.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexander.sistema_cerro_verde_backend.entity.administrable.Sucursal;
import com.alexander.sistema_cerro_verde_backend.repository.administrable.SucursalRepository;
import com.alexander.sistema_cerro_verde_backend.service.administrable.ISucursalService;

@Service
public class SucursalService implements ISucursalService {
    @Autowired
    private SucursalRepository repoSucursal;

    @Override
    public List<Sucursal> buscarTodos() {
        return repoSucursal.findAll();
    }

    @Override
    public Sucursal guardar(Sucursal sucursal) {
        return repoSucursal.save(sucursal);
    }

    @Override
    public void modificar(Sucursal sucursal) {
        repoSucursal.save(sucursal);
    }

    @Override
    public Optional<Sucursal> buscarId(Integer id) {
        return repoSucursal.findById(id);
    }

    @Override
    public void eliminar(Integer id) {
        repoSucursal.deleteById(id);
    }
}
