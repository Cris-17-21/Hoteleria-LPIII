package com.alexander.sistema_cerro_verde_backend.service.ventas;

import java.util.List;
import java.util.Optional;

import com.alexander.sistema_cerro_verde_backend.entity.ventas.MetodoPago;

public interface IMetodoPagoService {

    List<MetodoPago> buscarTodos (); //Listar todos los métodos de pago

    List<MetodoPago> buscarActivos (); //Listar los métodos de pago activos

    Optional<MetodoPago> buscarPorId (Integer id); //Buscar método de pago por el ID

    void registrar (MetodoPago metodo); //Registrar método de pago

    void modificar (MetodoPago metodo); //Modificar el método de pago

    void eliminar (Integer id); //Eliminar el método de pago por el ID
}
