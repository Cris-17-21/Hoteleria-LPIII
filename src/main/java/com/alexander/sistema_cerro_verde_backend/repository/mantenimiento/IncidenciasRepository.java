package com.alexander.sistema_cerro_verde_backend.repository.mantenimiento;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alexander.sistema_cerro_verde_backend.entity.mantenimiento.Incidencias;


public interface IncidenciasRepository extends JpaRepository <Incidencias, Integer>{

}