package com.alexander.sistema_cerro_verde_backend.entity.compras;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "proveedores")
@SQLDelete(sql = "UPDATE proveedores SET estado = 0 WHERE ruc_proveedor=?")
@SQLRestriction("estado = 1")
public class Proveedor {
    @Id
    private String rucProveedor;
    private String razonSocial;
    private String direccion;
    private Integer estado = 1;

    public String getRucProveedor() {
        return rucProveedor;
    }

    public void setRucProveedor(String rucProveedor) {
        this.rucProveedor = rucProveedor;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Proveedor [rucProveedor=" + rucProveedor + ", razonSocial=" + razonSocial + ", direccion=" + direccion
                + ", estado=" + estado + "]";
    }
}
