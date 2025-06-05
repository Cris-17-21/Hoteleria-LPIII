package com.alexander.sistema_cerro_verde_backend.service.administrable.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alexander.sistema_cerro_verde_backend.entity.administrable.Sucursal;
import com.alexander.sistema_cerro_verde_backend.repository.administrable.SucursalesRepository;
import com.alexander.sistema_cerro_verde_backend.service.administrable.SucursalesService;

@Service
public class SucursalesServicesImpl implements SucursalesService {
    @Autowired
    private SucursalesRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Sucursal> buscarTodos() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public Sucursal guardar(Sucursal sucursal) {
        return repository.save(sucursal);
    }

    @Override
    public void modificar(Sucursal sucursal) {
        repository.save(sucursal);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Sucursal> buscarId(Integer id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public void eliminar(Integer id) {
        repository.deleteById(id);
    }

}
