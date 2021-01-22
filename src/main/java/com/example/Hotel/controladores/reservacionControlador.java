package com.example.Hotel.controladores;

import com.example.Hotel.entidades.Cliente;
import com.example.Hotel.entidades.Pieza;
import com.example.Hotel.servicios.ArriendoServicio;
import com.example.Hotel.servicios.ClienteServicio;
import com.example.Hotel.servicios.PiezaServicio;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
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
    
    @GetMapping("/reservacion")
    public String contact(){
        return"reservacion.html";
    }
    
    @PostMapping("/reservarr")
    public String reservar(ModelMap model, @RequestParam String nombre,@RequestParam String apellido,@RequestParam String rut,@RequestParam Integer edad,@RequestParam String mail){
        try {
            clienteServicio.crearCliente(rut, nombre, apellido, edad, mail);
        } catch (Exception ex) {
            Logger.getLogger(reservacionControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return"reservacion.html";
    }
    @PostMapping("/reservar")
    public String reservar(ModelMap model, @RequestParam String id,@RequestParam Date fechaIngreso,@RequestParam Date fechaRetiro,@RequestParam Cliente cliente,@RequestParam Pieza pieza){
        try {
            arriendoServicio.crearArriendo("1", fechaIngreso, fechaRetiro,clienteServicio.BuscarCliente("20.930.652-2"), piezaServicio.BuscarPieza("1"));
        } catch (Exception ex) {
            Logger.getLogger(reservacionControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return"reservacion.html";
    }
}
