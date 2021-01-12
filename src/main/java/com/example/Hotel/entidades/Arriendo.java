package com.example.Hotel.entidades;

import java.util.Date;


public class Arriendo {
    
    private String id;
    private Date fechaIngreso;
    private Date fechaRetiro;
    Cliente cliente;
    Pieza pieza;
    private int cotizacion;

    public Arriendo(String id, Date fechaIngreso, Date fechaRetiro, Cliente cliente, Pieza pieza, int cotizacion) {
        this.id = id;
        this.fechaIngreso = fechaIngreso;
        this.fechaRetiro = fechaRetiro;
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

    public int getCotizacion() {
        return cotizacion;
    }

    public void setCotizacion(int cotizacion) {
        this.cotizacion = cotizacion;
    }
    
    
}
