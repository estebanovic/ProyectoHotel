package com.example.Hotel.controladores;

import com.example.Hotel.entidades.Arriendo;
import java.text.SimpleDateFormat;
import com.example.Hotel.servicios.ArriendoServicio;
import com.example.Hotel.servicios.ClienteServicio;
import com.example.Hotel.servicios.PiezaServicio;
import java.util.Date;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class reservacionControlador {

    @Autowired
    private ArriendoServicio arriendoServicio;

    @Autowired
    private ClienteServicio clienteServicio;

    @Autowired
    private PiezaServicio piezaServicio;

    @PostMapping("/reservacion")
    public String contact(ModelMap model, @RequestParam String fechaIngreso, @RequestParam String fechaRetiro, @RequestParam String pieza) {
        model.put("fechaIngreso", fechaIngreso);
        model.put("fechaRetiro", fechaRetiro);
        model.put("pieza", pieza);
        return "reservacion.html";
    }

    @PostMapping("/reservar")
    public String reservar(ModelMap model, @RequestParam String fechaIngreso, @RequestParam String fechaRetiro, @RequestParam String pieza, @RequestParam String nombre, @RequestParam String apellido, @RequestParam String rut, @RequestParam Integer edad, @RequestParam String mail) {
        String idPieza = null;
        try {
            switch (pieza) {
                case "Normal":
                    idPieza = "1";
                    break;
                case "VIP":
                    idPieza = "2";
                    break;
                case "Presidencial":
                    idPieza = "3";
                    break;
            }
            clienteServicio.crearCliente(rut, nombre, apellido, edad, mail);
            Date ingreso = new SimpleDateFormat("yyyy-MM-dd").parse(fechaIngreso);
            Date ingreso2 = new SimpleDateFormat("yyyy-MM-dd").parse(fechaRetiro);

            UUID uuid = UUID.randomUUID();
            String id = uuid.toString();

            arriendoServicio.crearArriendo(id, ingreso, ingreso2, clienteServicio.BuscarCliente(rut), piezaServicio.BuscarPiezaPorID(idPieza));

            Arriendo arriendo = arriendoServicio.buscarArriendo(id);

            model.put("id", arriendo.getId());
            model.put("ingreso", new SimpleDateFormat("MM-dd-yyyy").format(arriendo.getFechaIngreso()));
            model.put("retiro", new SimpleDateFormat("MM-dd-yyyy").format(arriendo.getFechaRetiro()));
            model.put("clienteRUT", arriendo.getCliente().getId());
            model.put("clienteNombre", arriendo.getCliente().getNombre() + " " + arriendo.getCliente().getApellido());
            model.put("clienteMail", arriendo.getCliente().getMail());
            model.put("pieza", arriendo.getPieza().getTipoPieza());
            model.put("cotizacion", arriendo.getCotizacion());
        } catch (Exception ex) {
            Logger.getLogger(reservacionControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "comprobante.html";
    }
}
