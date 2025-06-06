package com.alexander.sistema_cerro_verde_backend.entity.mantenimiento;

import java.util.List;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.alexander.sistema_cerro_verde_backend.entity.administrable.Sucursal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "areas_hotel")
@SQLDelete(sql = "UPDATE areas_hotel SET estado = 0 WHERE id_area = ?")
@Where(clause = "estado = 1")
public class AreasHotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_area;
    private String nombre;
    private Integer estado = 1;  // Estado activo por defecto

    @OneToMany(mappedBy = "area")
    private List<Incidencias> incidencias;

    @ManyToOne
    @JoinColumn(name = "id_sucursal")
    private Sucursal sucursal;
    
    public Integer getId_area() {
        return id_area;
    }
    public void setId_area(Integer id_area) {
        this.id_area = id_area;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Integer getEstado() {
        return estado;
    }
    public void setEstado(Integer estado) {
        this.estado = estado;
    }
    @Override
    public String toString() {
        return "AreasHotel [id_area=" + id_area + ", nombre=" + nombre + ", estado=" + estado + "]";
    }
    public List<Incidencias> getIncidencias() {
        return incidencias;
    }
    public void setIncidencias(List<Incidencias> incidencias) {
        this.incidencias = incidencias;
    }
    public Sucursal getSucursal() {
        return sucursal;
    }
    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }
    
}