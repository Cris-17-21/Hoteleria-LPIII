package com.alexander.sistema_cerro_verde_backend.repository.ventas;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.alexander.sistema_cerro_verde_backend.entity.ventas.Cliente;

public interface ClientesRepository extends JpaRepository<Cliente, Integer> {

    @Query("SELECT c FROM Clientes c WHERE c.estado = 1")
    List<Cliente> findActive();

    Optional<Cliente> findByDniRucIgnoreCase(String rucDni);
}
