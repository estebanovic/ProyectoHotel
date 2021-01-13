
package com.example.Hotel.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/galeria")
public class galeriaControlador {
    
    
    @GetMapping("")
    public String galeria(){
        return"gallery.html";
    }
    
}

