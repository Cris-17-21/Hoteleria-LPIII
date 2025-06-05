package com.alexander.sistema_cerro_verde_backend.service.compras;

import java.util.List;
import java.util.Optional;

import com.alexander.sistema_cerro_verde_backend.entity.compras.Categoria;

public interface ICategoriaService {

    List<Categoria> buscarTodos(); //Listar categorias

    void guardar(Categoria categoria); //Guardar categoria

    void modificar(Categoria categoria); //Modificar categoria

    Optional<Categoria> buscarId(Integer idCategoria); //Buscar por Id categoria

    void eliminar(Integer idCategoria); //Eliminar categoria, estado = 0
}