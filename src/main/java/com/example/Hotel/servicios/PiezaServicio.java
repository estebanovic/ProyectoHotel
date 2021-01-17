package com.example.Hotel.servicios;

import com.example.Hotel.entidades.Pieza;
import com.example.Hotel.repositorios.PiezaRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PiezaServicio {

    @Autowired
    private PiezaRepositorio piezaRepositorio;

    public void crearPieza(String id, String tipoPieza, Integer precioNoche) {
        Pieza pieza = new Pieza();
        pieza.setId(id);
        pieza.setTipoPieza(tipoPieza);
        pieza.setPrecioNoche(precioNoche);

        piezaRepositorio.save(pieza);
    }

    public void editarPieza(String id, String tipoPieza, Integer precioNoche) throws Exception {
        Optional<Pieza> respuesta = piezaRepositorio.findById(id);
        if (respuesta.isPresent()) {
            Pieza pieza = respuesta.get();
            pieza.setTipoPieza(tipoPieza);
            pieza.setPrecioNoche(precioNoche);

            piezaRepositorio.save(pieza);
        } else {
            throw new Exception("ERROR");
        }
    }

    public List<Pieza> listarPiezas() {
        return piezaRepositorio.findAll();
    }

    public void eliminarPieza(String id) throws Exception {
        Optional<Pieza> respuesta = piezaRepositorio.findById(id);
        if (respuesta.isPresent()) {
            Pieza pieza = respuesta.get();
            piezaRepositorio.delete(pieza);

        } else {
            throw new Exception("ERROR");
        }
    }
}
