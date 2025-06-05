package com.alexander.sistema_cerro_verde_backend.service.compras;

import java.util.List;
import java.util.Optional;

import com.alexander.sistema_cerro_verde_backend.entity.compras.Categoria;

public interface ICategoriasProductosService {

    List<Categoria> buscarTodos(); //Listar categorias

    List<Categoria> buscarActivos(); //Listar categorias activos

    void guardar(Categoria categoriaProducto); //Guardar categoria

    void modificar(Categoria categoriaProducto); //Modificar categoria

    Optional<Categoria> buscarId(Integer id_categoria); //Buscar por Id categoria

    void eliminar(Integer id_categoria); //Eliminar categoria, estado = 0
}