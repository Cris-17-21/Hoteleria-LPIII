package com.alexander.sistema_cerro_verde_backend.service.compras;

import java.util.List;
import java.util.Optional;

import com.alexander.sistema_cerro_verde_backend.entity.compras.Proveedor;

public interface IProveedoresService {

    List<Proveedor> buscarTodos(); //Listar proveedores

    List<Proveedor> buscarActivos(); //Listar proveedores activos

    void guardar(Proveedor proveedor); //Guardar proveedores

    void modificar(Proveedor proveedor); //Modificar proveedores

    Optional<Proveedor> buscarId(String ruc_proveedor); //Buscar proveedor por Ruc y estado = 1

    void eliminar(String ruc_proveedor); //Eliminar proveedor, pasa a estado = 0
}