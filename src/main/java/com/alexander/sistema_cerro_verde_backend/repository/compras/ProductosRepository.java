package com.alexander.sistema_cerro_verde_backend.repository.compras;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.alexander.sistema_cerro_verde_backend.entity.compras.Producto;

public interface ProductosRepository extends JpaRepository<Producto, Integer> {
    @Query("SELECT p FROM Productos p WHERE p.estado = 1")
    List<Producto> findActive();

    Optional<Producto> findByNombreIgnoreCase(String nombre);
}