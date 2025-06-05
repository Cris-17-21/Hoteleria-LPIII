package com.alexander.sistema_cerro_verde_backend.service.ventas;

import java.util.List;
import java.util.Optional;

import com.alexander.sistema_cerro_verde_backend.entity.ventas.Venta;

public interface IVentaService {

    List<Venta> buscarTodos (); //Listar todas las ventas
    
    Optional<Venta> buscarPorId (Integer id); //Buscar venta por ID

    void guardar (Venta venta); //Guardar venta

    void modificar (Venta venta); //Modificar venta

    void eliminar (Integer id); //Eliminar venta

    String generarComprobante(Integer id); //Generar comprobante

    byte[] generarPdf(Integer id);
}
