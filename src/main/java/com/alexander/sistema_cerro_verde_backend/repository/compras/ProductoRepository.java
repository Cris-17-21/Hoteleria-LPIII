package com.alexander.sistema_cerro_verde_backend.repository.compras;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alexander.sistema_cerro_verde_backend.entity.compras.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
}