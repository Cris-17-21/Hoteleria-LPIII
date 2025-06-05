package com.alexander.sistema_cerro_verde_backend.service.administrable;

import java.util.List;
import java.util.Optional;

import com.alexander.sistema_cerro_verde_backend.entity.administrable.Sucursal;

public interface ISucursalService {

    List<Sucursal> buscarTodos();
    
    Sucursal guardar(Sucursal sucursal);

    Optional<Sucursal> buscarId(Integer id);

    void modificar(Sucursal sucursal);

    void eliminar(Integer id);
}
