package com.alexander.sistema_cerro_verde_backend.entity.ventas;

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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "metodos_pago")
@SQLDelete(sql = "UPDATE metodos_pago SET estado = 0 WHERE id_metodo_pago = ?")
@SQLRestriction("estado = 1")
public class MetodoPago {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idMetodoPago;
    private String nombre;
    private Integer estado = 1;

    //Relación de Muchos a Uno con Empresa
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_empresa")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private Empresa empresa;

    public Integer getIdMetodoPago() {
        return idMetodoPago;
    }

    public void setIdMetodoPago(Integer idMetodoPago) {
        this.idMetodoPago = idMetodoPago;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
        return "MetodoPago [idMetodoPago=" + idMetodoPago + ", nombre=" + nombre + ", estado=" + estado + ", empresa="
                + empresa + "]";
    }
}
