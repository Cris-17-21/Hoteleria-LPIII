package com.alexander.sistema_cerro_verde_backend.entity.ventas;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import com.alexander.sistema_cerro_verde_backend.entity.compras.Producto;
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
@Table(name="ventas_x_productos")
@SQLDelete(sql = "UPDATE ventas_x_productosSET estado = 0 WHERE id_venta_producto = ?")
@SQLRestriction("estado = 1")
public class VentaXProducto {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idVentaProducto;
    private Integer cantidad;
    private Double precioUnit;
    private Double subTotal;
    private Integer estado = 1;
    
    //Relación de Muchos a Uno con Producto
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_producto")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private Producto producto;

    //Relación de muchos a uno con Venta
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_venta")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private Venta venta;

    public Integer getIdVentaProducto() {
        return idVentaProducto;
    }

    public void setIdVentaProducto(Integer idVentaProducto) {
        this.idVentaProducto = idVentaProducto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecioUnit() {
        return precioUnit;
    }

    public void setPrecioUnit(Double precioUnit) {
        this.precioUnit = precioUnit;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    @Override
    public String toString() {
        return "VentaXProducto [idVentaProducto=" + idVentaProducto + ", cantidad=" + cantidad + ", precioUnit="
                + precioUnit + ", subTotal=" + subTotal + ", estado=" + estado + ", producto=" + producto + ", venta="
                + venta + "]";
    }
}
