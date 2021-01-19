package com.example.Hotel.controladores;

import com.example.Hotel.servicios.ClienteServicio;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/")
public class reservacionControlador {
    
    @Autowired
    private ClienteServicio clienteServicio;
    
    @GetMapping("/reservacion")
    public String contact(){
        return"reservacion.html";
    }
    
    @PostMapping("/reservar")
    public String reservar(@RequestParam String nombre,@RequestParam String apellido,@RequestParam String rut,@RequestParam Integer edad,@RequestParam String mail){
        try {
            clienteServicio.crearCliente(rut, nombre, apellido, edad, mail);
        } catch (Exception ex) {
            Logger.getLogger(reservacionControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return"reservacion.html";
    }
    
}
