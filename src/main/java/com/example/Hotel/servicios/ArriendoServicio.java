package com.example.Hotel.servicios;

import com.example.Hotel.entidades.Arriendo;
import com.example.Hotel.entidades.Cliente;
import com.example.Hotel.entidades.Pieza;
import com.example.Hotel.repositorios.ArriendoRepositorio;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import org.springframework.stereotype.Service;

@Service
public class ArriendoServicio {
    
    private ArriendoRepositorio arriendoRepositorio;
    
    public void crearArriendo(String id, Date fechaIngreso, Date fechaRetiro, Cliente cliente, Pieza pieza){
        Arriendo arriendo = new Arriendo();
        
        LocalDate localFechaIngreso =fechaIngreso.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate localFechaRetiro =fechaIngreso.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        
        int numDias = (int) ChronoUnit.DAYS.between(localFechaIngreso, localFechaRetiro);
        int cotizacion = numDias * pieza.getPrecioNoche();
        
        arriendo.setId(id);
        arriendo.setFechaIngreso(fechaIngreso);
        arriendo.setFechaRetiro(fechaRetiro);
        arriendo.setNumDias(numDias);
        arriendo.setCliente(cliente);
        arriendo.setPieza(pieza);
        arriendo.setCotizacion(cotizacion);
        
        arriendoRepositorio.save(arriendo);
    }

}
