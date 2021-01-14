
package com.example.Hotel.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class indexControlador {
    
    
    @GetMapping("")
    public String index(){
        return"index.html";
    }    
}
