package com.alexander.sistema_cerro_verde_backend.entity.ventas;

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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "clientes_x_empresas")
@SQLDelete(sql = "UPDATE clientes_x_empresas SET estado = 0 WHERE id_cliente_empresa = ?")
@SQLRestriction("estado = 1")
public class ClienteXEmpresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idClienteEmpresa;
    Integer estado = 1;

    //Relación de Muchos a Uno con Cliente
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Cliente cliente;

    //Relación de Muchos a Uno con Empresa
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_empresa")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Empresa empresa;

    public Integer getIdClienteEmpresa() {
        return idClienteEmpresa;
    }

    public void setIdClienteEmpresa(Integer idClienteEmpresa) {
        this.idClienteEmpresa = idClienteEmpresa;
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

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    @Override
    public String toString() {
        return "ClienteXEmpresa [idClienteEmpresa=" + idClienteEmpresa + ", estado=" + estado + ", cliente=" + cliente
                + ", empresa=" + empresa + "]";
    }
}
