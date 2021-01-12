package com.example.Hotel.entidades;

public class Pieza {
    private String id;
    private String tipoPieza;
    private Integer precioNoche;

    public Pieza(String id, String tipoPieza, Integer precioNoche) {
        this.id = id;
        this.tipoPieza = tipoPieza;
        this.precioNoche = precioNoche;
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
    
    
}
