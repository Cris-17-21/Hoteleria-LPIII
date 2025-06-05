package com.alexander.sistema_cerro_verde_backend.entity.compras;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import com.alexander.sistema_cerro_verde_backend.entity.administrable.Empresa;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "unidades_medidas")
@SQLDelete(sql = "UPDATE unidades_medidas SET estado = 0 WHERE id_unidad=?")
@SQLRestriction("estado = 1")
public class UnidadMedida {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idUnidad;
    private String nombre;
    private String abreviatura;
    private Integer equivalencia;
    private Integer estado = 1;

    //Relación de Muchos a Uno con Empresa
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_empresa")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private Empresa empresa;

    public Integer getIdUnidad() {
        return idUnidad;
    }

    public void setIdUnidad(Integer idUnidad) {
        this.idUnidad = idUnidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public Integer getEquivalencia() {
        return equivalencia;
    }

    public void setEquivalencia(Integer equivalencia) {
        this.equivalencia = equivalencia;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    @Override
    public String toString() {
        return "UnidadMedida [idUnidad=" + idUnidad + ", nombre=" + nombre + ", abreviatura=" + abreviatura
                + ", equivalencia=" + equivalencia + ", estado=" + estado + ", empresa=" + empresa + "]";
    }
}
