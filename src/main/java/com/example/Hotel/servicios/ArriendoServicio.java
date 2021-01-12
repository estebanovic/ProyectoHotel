package com.example.Hotel.servicios;

import com.example.Hotel.entidades.Cliente;
import com.example.Hotel.entidades.Pieza;
import com.example.Hotel.repositorios.ArriendoRepositorio;
import java.util.Date;
import org.springframework.stereotype.Service;

@Service
public class ArriendoServicio {
    
    private ArriendoRepositorio arriendoRepositorio;
    
    public void crearArriendo(String id, Date fechaIngreso, Date fechaRetiro, Cliente cliente, Pieza pieza){
        
    }

}
