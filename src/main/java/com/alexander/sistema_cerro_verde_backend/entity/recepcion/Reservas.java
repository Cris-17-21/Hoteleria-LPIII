package com.alexander.sistema_cerro_verde_backend.entity.recepcion;

import java.time.LocalDateTime;
import java.util.List;

import com.alexander.sistema_cerro_verde_backend.entity.ventas.Cliente;
import com.alexander.sistema_cerro_verde_backend.entity.ventas.VentaXReserva;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Reservas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_reserva;
    private LocalDateTime fecha_inicio;
    private LocalDateTime fecha_fin;
    private String estado_reserva;
    private String comentarios;
    private Integer estado;
    private String tipo;

    @ManyToOne
    @JoinColumn(name="id_cliente")
    private Cliente cliente;

    @OneToMany(mappedBy = "reserva", cascade = CascadeType.ALL)
    private List<HabitacionesXReserva> habitacionesXReserva;

    @OneToMany(mappedBy = "reserva", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<SalonesXReserva> salonesXReserva;

    @OneToMany(mappedBy="reserva", cascade=CascadeType.ALL)
    @JsonIgnore
    private List<VentaXReserva> ventaXReserva;


    public Integer getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(Integer id_reserva) {
        this.id_reserva = id_reserva;
    }
    
    public LocalDateTime getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(LocalDateTime fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public LocalDateTime getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(LocalDateTime fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public String getEstado_reserva() {
        return estado_reserva;
    }

    public void setEstado_reserva(String estado_reserva) {
        this.estado_reserva = estado_reserva;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<HabitacionesXReserva> getHabitacionesXReserva() {
        return habitacionesXReserva;
    }

    public void setHabitacionesXReserva(List<HabitacionesXReserva> habitacionesXReserva) {
        this.habitacionesXReserva = habitacionesXReserva;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<SalonesXReserva> getSalonesXReserva() {
        return salonesXReserva;
    }

    public void setSalonesXReserva(List<SalonesXReserva> salonesXReserva) {
        this.salonesXReserva = salonesXReserva;
    }

    public List<VentaXReserva> getVentaXReserva() {
        return ventaXReserva;
    }

    public void setVentaXReserva(List<VentaXReserva> ventaXReserva) {
        this.ventaXReserva = ventaXReserva;
    }
    
    
    
    

}
