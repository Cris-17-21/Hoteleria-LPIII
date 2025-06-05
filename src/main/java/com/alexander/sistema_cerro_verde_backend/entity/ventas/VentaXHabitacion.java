package com.alexander.sistema_cerro_verde_backend.entity.ventas;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import com.alexander.sistema_cerro_verde_backend.entity.recepcion.Habitaciones;
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
@Table(name = "ventas_x_habitaciones")
@SQLDelete(sql = "UPDATE ventas_x_habitaciones SET estado = 0 WHERE id_venta_habitacion = ?")
@SQLRestriction("estado = 1") 
public class VentaXHabitacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVentaHabitacion;
    private Integer dias;
    private Double subTotal;
    private Integer estado = 1;

    //Relacion de Muchos a Uno con Venta
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_venta")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private Venta venta;

    //Relación de Muchos a Uno con Habitaciones
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_habitacion")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private Habitaciones habitacion;

    public Integer getIdVentaHabitacion() {
        return idVentaHabitacion;
    }

    public void setIdVentaHabitacion(Integer idVentaHabitacion) {
        this.idVentaHabitacion = idVentaHabitacion;
    }

    public Integer getDias() {
        return dias;
    }

    public void setDias(Integer dias) {
        this.dias = dias;
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

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public Habitaciones getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitaciones habitacion) {
        this.habitacion = habitacion;
    }

    @Override
    public String toString() {
        return "VentaXHabitacion [idVentaHabitacion=" + idVentaHabitacion + ", dias=" + dias + ", subTotal=" + subTotal
                + ", estado=" + estado + ", venta=" + venta + ", habitacion=" + habitacion + "]";
    }
}
