package com.alexander.sistema_cerro_verde_backend.service.compras;

import java.util.List;
import java.util.Optional;

import com.alexander.sistema_cerro_verde_backend.entity.compras.Compra;

public interface ICompraService {

    List<Compra> buscarTodos();

    void guardar(Compra compra);

    void modificar(Compra compra);

    Optional<Compra> buscarId(Integer idCompra);

    void eliminar(Integer idCompra);
}
