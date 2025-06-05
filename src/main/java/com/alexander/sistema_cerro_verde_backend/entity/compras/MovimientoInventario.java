package com.alexander.sistema_cerro_verde_backend.entity.compras;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import com.alexander.sistema_cerro_verde_backend.entity.ventas.Venta;
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
@Table(name = "movimientos_inventario")
@SQLDelete(sql = "UPDATE movimientos_inventario SET estado = 0 WHERE id_movimiento_inventario = ?")
@SQLRestriction("estado = 1")
public class MovimientoInventario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMovimientoInventario;
    private String fecha;
    private Integer cantidad;
    private String tipoMovimiento;
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

    //Relación de Muchos a Uno con Venta
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_venta")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private Venta venta;

    public Integer getIdMovimientoInventario() {
        return idMovimientoInventario;
    }

    public void setIdMovimientoInventario(Integer idMovimientoInventario) {
        this.idMovimientoInventario = idMovimientoInventario;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
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

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    @Override
    public String toString() {
        return "MovimientoInventario [idMovimientoInventario=" + idMovimientoInventario + ", fecha=" + fecha
                + ", cantidad=" + cantidad + ", tipoMovimiento=" + tipoMovimiento + ", estado=" + estado + ", compra="
                + compra + ", producto=" + producto + ", venta=" + venta + "]";
    }
}