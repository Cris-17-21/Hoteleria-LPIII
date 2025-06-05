package com.alexander.sistema_cerro_verde_backend.entity.ventas;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="comprobantes_pago")
@SQLDelete(sql = "UPDATE comprobantes_pago SET estado = 0 WHERE id_venta = ?")
@SQLRestriction("estado =  1")
public class ComprobantePago {
    @Id
    private Integer idVenta;
    private String numSerieBoleta;
    private String numSerieFactura;
    private String pdfUrl;
    private String numComprobante;
    private String fechaEmision;
    private Integer estado = 1;

    //Relación de Uno a Uno con Venta
    @OneToOne
    @MapsId
    @JoinColumn(name="id_venta")
    private Venta venta;

    public Integer getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Integer idVenta) {
        this.idVenta = idVenta;
    }

    public String getNumSerieBoleta() {
        return numSerieBoleta;
    }

    public void setNumSerieBoleta(String numSerieBoleta) {
        this.numSerieBoleta = numSerieBoleta;
    }

    public String getNumSerieFactura() {
        return numSerieFactura;
    }

    public void setNumSerieFactura(String numSerieFactura) {
        this.numSerieFactura = numSerieFactura;
    }

    public String getPdfUrl() {
        return pdfUrl;
    }

    public void setPdfUrl(String pdfUrl) {
        this.pdfUrl = pdfUrl;
    }

    public String getNumComprobante() {
        return numComprobante;
    }

    public void setNumComprobante(String numComprobante) {
        this.numComprobante = numComprobante;
    }

    public String getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(String fechaEmision) {
        this.fechaEmision = fechaEmision;
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

    @Override
    public String toString() {
        return "ComprobantePago [idVenta=" + idVenta + ", numSerieBoleta=" + numSerieBoleta + ", numSerieFactura="
                + numSerieFactura + ", pdfUrl=" + pdfUrl + ", numComprobante=" + numComprobante + ", fechaEmision="
                + fechaEmision + ", estado=" + estado + ", venta=" + venta + "]";
    }
}
