package com.alexander.sistema_cerro_verde_backend.entity.compras;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import com.alexander.sistema_cerro_verde_backend.entity.administrable.Empresa;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "categorias")
@SQLDelete(sql = "UPDATE categorias SET estado = 0 WHERE id_categoria = ?")
@SQLRestriction("estado = 1")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCategoria;
    private String nombre;
    private Integer estado = 1;

    //Relación de Muchos a Uno con Empresa
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_empresa")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private Empresa empresa;

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
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

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    @Override
    public String toString() {
        return "Categoria [idCategoria=" + idCategoria + ", nombre=" + nombre + ", estado=" + estado + ", empresa="
                + empresa + "]";
    }
}
