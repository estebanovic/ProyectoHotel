package com.example.Hotel.controladores;


import java.text.SimpleDateFormat;
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
    
    @PostMapping("/reservacion")
    public String contact(ModelMap model,@RequestParam String fechaIngreso, @RequestParam String fechaRetiro,@RequestParam String pieza){
        model.put("fechaIngreso", fechaIngreso);
        model.put("fechaRetiro", fechaRetiro);
        model.put("pieza", pieza);
        return"reservacion.html";
    }
    
    @PostMapping("/reservar")
    public String reservar(ModelMap model, @RequestParam String fechaIngreso, @RequestParam String fechaRetiro,@RequestParam String pieza, @RequestParam String nombre,@RequestParam String apellido,@RequestParam String rut,@RequestParam Integer edad,@RequestParam String mail){
        String idPieza = "";
        System.out.println(pieza);
        try {
            switch (pieza){
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
            System.out.println(idPieza);
            clienteServicio.crearCliente(rut, nombre, apellido, edad, mail);
            Date ingreso =new SimpleDateFormat("yyyy-MM-dd").parse(fechaIngreso);
            Date ingreso2 =new SimpleDateFormat("yyyy-MM-dd").parse(fechaRetiro);
            arriendoServicio.crearArriendo(ingreso, ingreso2, clienteServicio.BuscarCliente(rut), piezaServicio.BuscarPiezaPorID(idPieza));
        } catch (Exception ex) {
            Logger.getLogger(reservacionControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return"reservacion.html";
    }
}
