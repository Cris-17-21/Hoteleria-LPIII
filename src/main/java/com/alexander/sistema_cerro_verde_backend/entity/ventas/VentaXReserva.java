package com.alexander.sistema_cerro_verde_backend.entity.ventas;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import com.alexander.sistema_cerro_verde_backend.entity.recepcion.Reservas;
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
@Table(name = "ventas_x_reservas")
@SQLDelete(sql = "UPDATE ventas_x_reservas SET estado = 0 WHERE id_venta_reserva = ?")
@SQLRestriction("estado = 1")
public class VentaXReserva {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idVentaReserva;
    private Integer estado = 1;

    //Relación de Muchos a Uno con Venta
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_venta")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private Venta venta;

    //Relación de Muchos a Uno con Reservas
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_reserva")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private Reservas reserva;

    public Integer getIdVentaReserva() {
        return idVentaReserva;
    }

    public void setIdVentaReserva(Integer idVentaReserva) {
        this.idVentaReserva = idVentaReserva;
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

    public Reservas getReserva() {
        return reserva;
    }

    public void setReserva(Reservas reserva) {
        this.reserva = reserva;
    }

    @Override
    public String toString() {
        return "VentaXReserva [idVentaReserva=" + idVentaReserva + ", estado=" + estado + ", venta=" + venta
                + ", reserva=" + reserva + "]";
    }
}
