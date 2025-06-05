package com.alexander.sistema_cerro_verde_backend.entity.ventas;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ventas_x_metodos_pago")
@SQLDelete(sql = "UPDATE ventas_x_metodos_pago SET estado = 0 WHERE id_venta_metodo_pago = ?")
@SQLRestriction("estado = 1")
public class VentaXMetodoPago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVentaMetodoPago;
    private Double pago;
    private Integer estado = 1;

    //Relación de Muchos a Uno con Venta
    @ManyToOne
    @JoinColumn(name = "id_venta")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private Venta venta;

    //Relación de Muchos a Uno con MetodoPago
    @ManyToOne
    @JoinColumn(name = "id_metodo_pago")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private MetodoPago metodoPago;

    public Integer getIdVentaMetodoPago() {
        return idVentaMetodoPago;
    }

    public void setIdVentaMetodoPago(Integer idVentaMetodoPago) {
        this.idVentaMetodoPago = idVentaMetodoPago;
    }

    public Double getPago() {
        return pago;
    }

    public void setPago(Double pago) {
        this.pago = pago;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    @Override
    public String toString() {
        return "VentaXMetodoPago [idVentaMetodoPago=" + idVentaMetodoPago + ", pago=" + pago + ", estado=" + estado
                + ", venta=" + venta + ", metodoPago=" + metodoPago + "]";
    }
}
