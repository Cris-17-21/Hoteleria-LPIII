package com.alexander.sistema_cerro_verde_backend.entity.ventas;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import com.alexander.sistema_cerro_verde_backend.entity.recepcion.Salones;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ventas_x_salones")
@SQLDelete(sql = "UPDATE ventas_x_salones SET estado = 0 WHERE id_venta_salon = ?")
@SQLRestriction("estado = 1")
public class VentaXSalon {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idVentaSalon;
    private Integer horas;
    private Integer dias;
    private Integer subTotal;
    private Integer estado = 1;

    //Relación de Muchos a Uno con Venta
    @ManyToOne
    @JoinColumn(name="id_venta")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private Venta venta;

    //Relación de Muchos a Uno con Salones
    @ManyToOne
    @JoinColumn(name="id_salon")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private Salones salon;

    public Integer getIdVentaSalon() {
        return idVentaSalon;
    }

    public void setIdVentaSalon(Integer idVentaSalon) {
        this.idVentaSalon = idVentaSalon;
    }

    public Integer getHoras() {
        return horas;
    }

    public void setHoras(Integer horas) {
        this.horas = horas;
    }

    public Integer getDias() {
        return dias;
    }

    public void setDias(Integer dias) {
        this.dias = dias;
    }

    public Integer getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Integer subTotal) {
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

    public Salones getSalon() {
        return salon;
    }

    public void setSalon(Salones salon) {
        this.salon = salon;
    }

    @Override
    public String toString() {
        return "VentaXSalon [idVentaSalon=" + idVentaSalon + ", horas=" + horas + ", dias=" + dias + ", subTotal="
                + subTotal + ", estado=" + estado + ", venta=" + venta + ", salon=" + salon + "]";
    }
}
