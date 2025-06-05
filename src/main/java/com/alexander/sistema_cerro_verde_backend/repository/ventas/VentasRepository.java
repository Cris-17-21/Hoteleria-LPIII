package com.alexander.sistema_cerro_verde_backend.repository.ventas;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alexander.sistema_cerro_verde_backend.entity.ventas.Venta;

public interface VentasRepository extends JpaRepository<Venta, Integer>{
}
