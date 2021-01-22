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

    public void crearPieza(String id, String tipoPieza, Integer precioNoche, String descripcionPieza) throws Exception {
        Pieza pieza = new Pieza();

        try {
            if (id == null || id.isEmpty()) {
                throw new Exception("Se debe indicar el id de la pieza");
            }

            if (tipoPieza == null || tipoPieza.isEmpty()) {
                throw new Exception("Se debe indicar el tipo de pieza");
            }

            if (precioNoche == null || precioNoche <= 0) {
                throw new Exception("Se debe indicar el precio por noche");
            }

            if (descripcionPieza == null || descripcionPieza.isEmpty()) {
                throw new Exception("Se debe añadir una descripcion de la pieza");
            }

            pieza.setId(id);
            pieza.setTipoPieza(tipoPieza);
            pieza.setPrecioNoche(precioNoche);
            pieza.setDescripcionPieza(descripcionPieza);

            piezaRepositorio.save(pieza);

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("ERROR AL CREAR Y GUARDAR PIEZA - FALTAN DATOS");
        }

    }

    public Pieza BuscarPieza(String id) throws Exception {
        Optional<Pieza> respuesta = piezaRepositorio.findById(id);
        if (respuesta.isPresent()) {
            return respuesta.get();
        } else {
            return null;
        }
    }

    public void editarPieza(String id, String tipoPieza, Integer precioNoche, String descripcionPieza) throws Exception {
        Optional<Pieza> respuesta = piezaRepositorio.findById(id);
        if (respuesta.isPresent()) {
            Pieza pieza = respuesta.get();
            try {

                if (tipoPieza == null || tipoPieza.isEmpty()) {
                    throw new Exception("Se debe indicar el tipo de pieza");
                }

                if (precioNoche == null || precioNoche <= 0) {
                    throw new Exception("Se debe indicar el precio por noche");
                }

                if (descripcionPieza == null || descripcionPieza.isEmpty()) {
                    throw new Exception("Se debe añadir una descripcion de la pieza");
                }

                pieza.setTipoPieza(tipoPieza);
                pieza.setPrecioNoche(precioNoche);
                pieza.setDescripcionPieza(descripcionPieza);

                piezaRepositorio.save(pieza);
            } catch (Exception e) {
                throw new Exception("ERROR AL EDITAR PIEZA");
            }

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
