package com.example.Hotel.servicios;

import com.example.Hotel.entidades.Arriendo;
import com.example.Hotel.entidades.Cliente;
import com.example.Hotel.entidades.Pieza;
import com.example.Hotel.repositorios.ArriendoRepositorio;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArriendoServicio {

    @Autowired
    private ArriendoRepositorio arriendoRepositorio;

    public void crearArriendo(String id, Date fechaIngreso, Date fechaRetiro, Cliente cliente, Pieza pieza) {
        Arriendo arriendo = new Arriendo();

        LocalDate localFechaIngreso = fechaIngreso.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate localFechaRetiro = fechaRetiro.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        int numDias = (int) ChronoUnit.DAYS.between(localFechaIngreso, localFechaRetiro);
        int cotizacion = numDias * pieza.getPrecioNoche();
        
        System.out.println(localFechaIngreso);
        System.out.println(localFechaRetiro);
        
        arriendo.setId(id);
        arriendo.setFechaIngreso(fechaIngreso);
        arriendo.setFechaRetiro(fechaRetiro);
        arriendo.setNumDias(numDias);
        arriendo.setCliente(cliente);
        arriendo.setPieza(pieza);
        arriendo.setCotizacion(cotizacion);

        arriendoRepositorio.save(arriendo);
    }

    public void editarArriendo(String id, Date fechaIngreso, Date fechaRetiro, Cliente cliente, Pieza pieza) throws Exception {
        Optional<Arriendo> respuesta = arriendoRepositorio.findById(id);
        if (respuesta.isPresent()) {

            LocalDate localFechaIngreso = fechaIngreso.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate localFechaRetiro = fechaIngreso.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            int numDias = (int) ChronoUnit.DAYS.between(localFechaIngreso, localFechaRetiro);
            int cotizacion = numDias * pieza.getPrecioNoche();

            Arriendo arriendo = respuesta.get();
            arriendo.setFechaIngreso(fechaIngreso);
            arriendo.setFechaRetiro(fechaRetiro);
            arriendo.setNumDias(numDias);
            arriendo.setCliente(cliente);
            arriendo.setPieza(pieza);
            arriendo.setCotizacion(cotizacion);

            arriendoRepositorio.save(arriendo);
        } else {
            throw new Exception("ERROR");
        }
    }

    public List<Arriendo> consultarArriendos() {
        return arriendoRepositorio.findAll();
    }

    public void eliminarArriendo(String id) throws Exception {
        Optional<Arriendo> respuesta = arriendoRepositorio.findById(id);
        if (respuesta.isPresent()) {
            Arriendo arriendo = respuesta.get();
            arriendoRepositorio.delete(arriendo);

        } else {
            throw new Exception("ERROR");
        }
    }
 
}
