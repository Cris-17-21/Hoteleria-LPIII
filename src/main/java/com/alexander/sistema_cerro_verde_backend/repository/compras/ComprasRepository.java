package com.alexander.sistema_cerro_verde_backend.repository.compras;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.alexander.sistema_cerro_verde_backend.entity.compras.Compra;

public interface ComprasRepository extends JpaRepository<Compra, Integer> {

    @Query("SELECT c FROM Compras c ORDER BY c.id_compra DESC")
    Optional<Compra> obtenerUltimaCompra();

}
