package com.alexander.sistema_cerro_verde_backend.repository.ventas;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alexander.sistema_cerro_verde_backend.entity.ventas.VentaXSalon;

public interface VentaSalonRepository extends JpaRepository<VentaXSalon, Integer> {

    List<VentaXSalon> findByVenta_IdVenta(Integer id);

}
