package com.alexander.sistema_cerro_verde_backend.repository.compras;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.alexander.sistema_cerro_verde_backend.entity.compras.Proveedor;

public interface ProveedoresRepository extends JpaRepository<Proveedor, String> {
    @Query("SELECT p FROM Proveedores p WHERE p.estado = 1")
    List<Proveedor> findActive();

    @Query("SELECT p FROM Proveedores p WHERE p.ruc_proveedor = :ruc")
    Optional<Proveedor> findByRucIncludingInactives(@Param("ruc") String ruc);
}
