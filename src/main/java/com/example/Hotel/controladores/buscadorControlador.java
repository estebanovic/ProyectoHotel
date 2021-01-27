/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Hotel.controladores;


import com.example.Hotel.entidades.Cliente;
import com.example.Hotel.servicios.BuscadorServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/reservas_personal")
public class buscadorControlador {
    
    @Autowired
    private BuscadorServicio buscadorServicio;
    
    
    @GetMapping
    public ModelAndView listado(){
        ModelAndView mav = new ModelAndView("buscador");
        mav.addObject("cliente", buscadorServicio.buscarTodos());
        return mav;
    }
    
    @GetMapping("/reservas_personal")
    public ModelAndView buscador(){
        ModelAndView mav = new ModelAndView("buscador");
        mav.addObject("cliente", new Cliente());
        return mav;
    }
    
    @PostMapping("/guardar")
    public RedirectView guardar(@ModelAttribute Cliente cliente) throws Exception {
        RedirectView rv = new RedirectView("/");
        buscadorServicio.guardar(cliente);
        return rv;
    }
    
}

