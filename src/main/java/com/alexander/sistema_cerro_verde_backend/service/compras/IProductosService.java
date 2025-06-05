package com.alexander.sistema_cerro_verde_backend.service.compras;

import java.util.List;
import java.util.Optional;

import com.alexander.sistema_cerro_verde_backend.entity.compras.Producto;

public interface IProductosService {
    List<Producto> buscarTodos(); //Buscar todos los Productos
 
    List<Producto> buscarActivos(); //Buscas los productos activos, estado = 1

    void guardar(Producto producto); //Guardar producto

    void modificar(Producto producto); //Modificar producto

    Optional<Producto> buscarId(Integer id_producto); //Buscar el producto por Id

    void eliminar(Integer id_producto); //Eliminar producto, estado = 0
}