package com.alexander.sistema_cerro_verde_backend.service.compras;

import java.util.List;
import java.util.Optional;

import com.alexander.sistema_cerro_verde_backend.entity.compras.Proveedor;

public interface IProveedorService {

    List<Proveedor> buscarTodos(); //Listar proveedores

    void guardar(Proveedor proveedor); //Guardar proveedores

    void modificar(Proveedor proveedor); //Modificar proveedores

    Optional<Proveedor> buscarId(String rucProveedor); //Buscar proveedor por Ruc y estado = 1

    void eliminar(String rucProveedor); //Eliminar proveedor, pasa a estado = 0
}