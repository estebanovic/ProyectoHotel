package com.example.Hotel.entidades;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Pieza {

    @Id
    private String id;
    private String tipoPieza;
    private Integer precioNoche;
    private String descripcionPieza;

    public Pieza(String id, String tipoPieza, Integer precioNoche, String descripcionPieza) {
        this.id = id;
        this.tipoPieza = tipoPieza;
        this.precioNoche = precioNoche;
        this.descripcionPieza = descripcionPieza;
    }

    public Pieza() {
    }
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipoPieza() {
        return tipoPieza;
    }

    public void setTipoPieza(String tipoPieza) {
        this.tipoPieza = tipoPieza;
    }

    public Integer getPrecioNoche() {
        return precioNoche;
    }

    public void setPrecioNoche(Integer precioNoche) {
        this.precioNoche = precioNoche;
    }

    public String descripcionPieza() {
        return descripcionPieza;
    }

    public void descripcionPieza(String descripcionPieza) {
        this.descripcionPieza = descripcionPieza;
    
    @Override
    public String toString() {
        return "Pieza{" + "id=" + id + ", tipoPieza=" + tipoPieza + ", precioNoche=" + precioNoche + '}';
    }

}
