
package com.example.Hotel.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/")
public class aboutControlador {

    @RequestMapping("/index/about.html")
    public String home(){
        return "about.html";
    }
    @GetMapping("/about")
    public String about(){
        return"about.html";
    }
}
