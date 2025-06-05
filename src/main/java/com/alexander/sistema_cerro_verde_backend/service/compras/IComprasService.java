package com.alexander.sistema_cerro_verde_backend.service.compras;

import java.util.List;
import java.util.Optional;

import com.alexander.sistema_cerro_verde_backend.entity.compras.Compra;

public interface IComprasService {
    List<Compra> buscarTodos();
    //Método para listar todos los registros 
    void guardar(Compra compra);

    void modificar(Compra compra);

    Optional<Compra> buscarId(Integer id_compra);

    void eliminar(Integer id_compra);

    String obtenerProximoCorrelativo();
}