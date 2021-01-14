
package com.example.Hotel.controladores;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class indexControlador {

    @RequestMapping("/index.html")
    public String home(){
        return "index.html";
    }
}

