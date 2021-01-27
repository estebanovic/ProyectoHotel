package com.example.Hotel.controladores;

import com.example.Hotel.servicios.ArriendoServicio;
import com.example.Hotel.servicios.ClienteServicio;
import com.example.Hotel.servicios.PiezaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/tabla")
public class TablaControlador {
    
    @Autowired
    private ArriendoServicio arriendoServicio;
    
    @Autowired
    private ClienteServicio clienteServicio;
    
    @Autowired
    private PiezaServicio piezaServicio;
    
    @GetMapping
    public ModelAndView listado(){
        ModelAndView mav = new ModelAndView("tablas");
        mav.addObject("arriendos",arriendoServicio.consultarArriendos());
        return mav;
    }
    
    @GetMapping("/")
    public String home(){
        return "tablas.html";
    }
    
    
}
