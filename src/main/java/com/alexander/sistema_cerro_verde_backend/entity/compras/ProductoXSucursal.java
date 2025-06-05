package com.alexander.sistema_cerro_verde_backend.entity.compras;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import com.alexander.sistema_cerro_verde_backend.entity.administrable.Sucursal;
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
@Table(name = "productos_x_sucursales")
@SQLDelete(sql = "UPDATE productos_x_sucursales SET estado = 0 WHERE id_producto_sucursal = ?")
@SQLRestriction("estado = 1")
public class ProductoXSucursal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idProductoSucursal;
    Integer stock;
    Integer estado = 1;

    //Relación de Muchos a Uno con Producto
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_producto")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private Producto producto;

    //Relación de Muchos a Uno con Sucursal
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_sucursal")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private Sucursal sucursal;

    public Integer getIdProductoSucursal() {
        return idProductoSucursal;
    }

    public void setIdProductoSucursal(Integer idProductoSucursal) {
        this.idProductoSucursal = idProductoSucursal;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
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

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    @Override
    public String toString() {
        return "ProductoXSucursal [idProductoSucursal=" + idProductoSucursal + ", stock=" + stock + ", estado=" + estado
                + ", producto=" + producto + ", sucursal=" + sucursal + "]";
    }
}
