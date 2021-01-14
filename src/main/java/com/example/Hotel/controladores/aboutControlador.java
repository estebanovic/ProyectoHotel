
package com.example.Hotel.controladores;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class aboutControlador {

    @RequestMapping("/index/about.html")
    public String home(){
        return "about.html";
    }
}
