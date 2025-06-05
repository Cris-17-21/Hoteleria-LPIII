package com.alexander.sistema_cerro_verde_backend.service.compras;

import java.util.List;
import java.util.Optional;

import com.alexander.sistema_cerro_verde_backend.entity.compras.DetalleCompra;

public interface IDetalleCompraService {

    List<DetalleCompra> buscarTodos();

    void guardar(DetalleCompra detalleCompra);

    void modificar(DetalleCompra detalleCompra);

    Optional<DetalleCompra> buscarId(Integer idDetalleCompra);

    void eliminar(Integer idDetalleCompra);
}
