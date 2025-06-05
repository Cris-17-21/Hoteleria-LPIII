package com.alexander.sistema_cerro_verde_backend.service.compras;

import java.util.List;
import java.util.Optional;

import com.alexander.sistema_cerro_verde_backend.entity.compras.Producto;

public interface IProductoService {

    List<Producto> buscarTodos(); //Buscar todos los Productos

    void guardar(Producto producto); //Guardar producto

    void modificar(Producto producto); //Modificar producto

    Optional<Producto> buscarId(Integer idProducto); //Buscar el producto por Id

    void eliminar(Integer idProducto); //Eliminar producto, estado = 0
}
