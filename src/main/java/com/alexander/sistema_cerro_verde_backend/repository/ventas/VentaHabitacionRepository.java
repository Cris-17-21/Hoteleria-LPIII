package com.alexander.sistema_cerro_verde_backend.repository.ventas;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alexander.sistema_cerro_verde_backend.entity.ventas.VentaXHabitacion;

public interface VentaHabitacionRepository extends JpaRepository<VentaXHabitacion, Integer> {

    List<VentaXHabitacion> findByVenta_IdVenta(Integer id);
}
