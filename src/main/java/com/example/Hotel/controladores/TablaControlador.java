/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Hotel.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Esteban
 */
@Controller
@RequestMapping("/tabla")
public class TablaControlador {
    
    @GetMapping("")
    public String home(){
        return "tablas.html";
    }
    
}
