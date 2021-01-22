
package com.example.Hotel.controladores;

import com.example.Hotel.servicios.ArriendoServicio;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/") //localhost:8080/
public class indexControlador {

    
    @GetMapping("/")
    public String home(){
        return "index.html";
    }
    
}

