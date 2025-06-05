package com.alexander.sistema_cerro_verde_backend.service.administrable.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.alexander.sistema_cerro_verde_backend.entity.administrable.Empresa;
import com.alexander.sistema_cerro_verde_backend.repository.administrable.EmpresaRepository;
import com.alexander.sistema_cerro_verde_backend.service.administrable.IEmpresaService;

public class EmpresaService implements IEmpresaService{

    @Autowired
    private EmpresaRepository repoEmpresa;

    @Override
    public List<Empresa> buscarTodos() {
        return repoEmpresa.findAll();
    }

    @Override
    public Empresa guardar(Empresa empresa) {
        return repoEmpresa.save(empresa);
    }

    @Override
    public void modificar(Empresa empresa) {
        repoEmpresa.save(empresa);
    }

    @Override
    public Optional<Empresa> buscarId(Integer id) {
        return repoEmpresa.findById(id);
    }

    @Override
    public void eliminar(Integer id) {
        repoEmpresa.deleteById(id);
    }
}
