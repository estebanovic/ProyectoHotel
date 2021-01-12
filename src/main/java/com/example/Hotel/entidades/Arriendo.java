package com.example.Hotel.entidades;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Arriendo {

    @Id
    private String id;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaIngreso;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaRetiro;
    private Integer numDias;
    @ManyToOne
    private Cliente cliente;
    @ManyToOne
    private Pieza pieza;

    private Integer cotizacion;

    public Arriendo(String id, Date fechaIngreso, Date fechaRetiro, Integer numDias, Cliente cliente, Pieza pieza, Integer cotizacion) {
        this.id = id;
        this.fechaIngreso = fechaIngreso;
        this.fechaRetiro = fechaRetiro;
        this.numDias = numDias;
        this.cliente = cliente;
        this.pieza = pieza;
        this.cotizacion = cotizacion;
    }

    public Arriendo() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaRetiro() {
        return fechaRetiro;
    }

    public void setFechaRetiro(Date fechaRetiro) {
        this.fechaRetiro = fechaRetiro;
    }

    public Integer getNumDias() {
        return numDias;
    }

    public void setNumDias(Integer numDias) {
        this.numDias = numDias;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Pieza getPieza() {
        return pieza;
    }

    public void setPieza(Pieza pieza) {
        this.pieza = pieza;
    }

    public Integer getCotizacion() {
        return cotizacion;
    }

    public void setCotizacion(Integer cotizacion) {
        this.cotizacion = cotizacion;
    }

    @Override
    public String toString() {
        return "Arriendo{" + "id=" + id + ", fechaIngreso=" + fechaIngreso + ", fechaRetiro=" + fechaRetiro + ", cliente=" + cliente + ", pieza=" + pieza + ", cotizacion=" + cotizacion + '}';
    }

}
