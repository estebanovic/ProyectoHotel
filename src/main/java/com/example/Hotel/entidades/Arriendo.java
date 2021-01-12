package com.example.Hotel.entidades;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Arriendo {

    @Id
    private String id;
    private Date fechaIngreso;
    private Date fechaRetiro;
    Cliente cliente;
    Pieza pieza;
    private Integer cotizacion;

    public Arriendo(String id, Date fechaIngreso, Date fechaRetiro, Cliente cliente, Pieza pieza, Integer cotizacion) {
        this.id = id;
        this.fechaIngreso = fechaIngreso;
        this.fechaRetiro = fechaRetiro;
        this.cliente = cliente;
        this.pieza = pieza;
        this.cotizacion = cotizacion;
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
