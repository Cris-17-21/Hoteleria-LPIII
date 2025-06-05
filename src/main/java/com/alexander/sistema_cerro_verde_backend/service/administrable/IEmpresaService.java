package com.alexander.sistema_cerro_verde_backend.service.administrable;

import java.util.List;
import java.util.Optional;

import com.alexander.sistema_cerro_verde_backend.entity.administrable.Empresa;

public interface IEmpresaService {

    List<Empresa> buscarTodos();

    Empresa guardar(Empresa empresa);

    Optional<Empresa> buscarId(Integer id);

    void modificar(Empresa empresa);

    void eliminar(Integer id);
}
