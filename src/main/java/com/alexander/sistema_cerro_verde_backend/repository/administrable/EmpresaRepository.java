package com.alexander.sistema_cerro_verde_backend.repository.administrable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alexander.sistema_cerro_verde_backend.entity.administrable.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Integer>{
}
