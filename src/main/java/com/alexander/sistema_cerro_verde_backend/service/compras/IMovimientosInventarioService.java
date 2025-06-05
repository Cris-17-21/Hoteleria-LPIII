package com.alexander.sistema_cerro_verde_backend.service.compras;

import java.util.List;
import java.util.Optional;

import com.alexander.sistema_cerro_verde_backend.entity.compras.MovimientoInventario;

public interface IMovimientosInventarioService {
    List<MovimientoInventario> buscarTodos();
    //Método para listar todos los registros
    void guardar(MovimientoInventario movimientoinventario);

    void modificar(MovimientoInventario movimientoinventario);

    Optional<MovimientoInventario> buscarId(Integer id_movimiento_inventario);

    void eliminar(Integer id_movimiento_inventario);
}