package com.alexander.sistema_cerro_verde_backend.service.compras;

import java.util.List;
import java.util.Optional;

import com.alexander.sistema_cerro_verde_backend.entity.compras.MovimientoInventario;

public interface IMovimientoInventarioService {

    List<MovimientoInventario> buscarTodos();

    void guardar(MovimientoInventario movimientoinventario);

    void modificar(MovimientoInventario movimientoinventario);

    Optional<MovimientoInventario> buscarId(Integer idMovimientoInventario);

    void eliminar(Integer idMovimientoInventario);
}
