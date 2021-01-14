
package com.example.Hotel.controladores;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class aboutControlador {
<<<<<<< HEAD

    @RequestMapping("/index/about.html")
    public String home(){
        return "about.html";
    }
}

    
    @GetMapping("/about")
    public String about(){
        return"about.html";
    }
}
>>>>>>> 77f1037bfb1d1b61d07476f07554b489bdfda5d7
