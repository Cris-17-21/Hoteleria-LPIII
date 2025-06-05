package com.alexander.sistema_cerro_verde_backend.entity.compras;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

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
@Table(name = "detalles_compra")
@SQLDelete(sql = "UPDATE detalles_compra SET estado = 0 WHERE id_detalle_compra = ?")
@SQLRestriction("estado = 1")
public class DetalleCompra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_detalle_compra;
    private Double cantidad;
    private Double precio;
    private Double subtotal;
    private Integer estado = 1;

    //Relación de Muchos a Uno con Compra
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_compra")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private Compra compra;

    //Relación de Muchos a Uno con Producto
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_producto")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private Producto producto;

    public Integer getId_detalle_compra() {
        return id_detalle_compra;
    }

    public void setId_detalle_compra(Integer id_detalle_compra) {
        this.id_detalle_compra = id_detalle_compra;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "DetalleCompra [id_detalle_compra=" + id_detalle_compra + ", cantidad=" + cantidad + ", precio=" + precio
                + ", subtotal=" + subtotal + ", estado=" + estado + ", compra=" + compra + ", producto=" + producto
                + "]";
    }
}