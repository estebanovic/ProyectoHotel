/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Hotel.servicios;


import com.example.Hotel.entidades.Cliente;
import com.example.Hotel.repositorios.BuscadorRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BuscadorServicio {
    
    private final BuscadorRepositorio buscadorRepositorio;
    
    @Autowired
    public BuscadorServicio(BuscadorRepositorio buscadorRepositorio) {
        this.buscadorRepositorio = buscadorRepositorio;
    }
    
    @Transactional(rollbackFor = Exception.class)
    public Cliente guardar (Cliente cliente) throws Exception {      
        if (cliente.getId() == null || cliente.getId().isEmpty()) {
            throw new Exception("El alumno debe tener un documento");
        }
        if (cliente.getNombre() == null || cliente.getNombre().isEmpty()) {
            throw new Exception("El alumno debe tener un nombre");
        }
        if (cliente.getApellido() == null || cliente.getApellido().isEmpty()) {
            throw new Exception("El alumno debe tener un apellido");
        }  
        
        return buscadorRepositorio.save(cliente);
    }
    
    public Cliente buscar (String id) throws Exception {
        Optional <Cliente> alumno = buscadorRepositorio.findById(id);
        if (!alumno.isPresent()) {
            throw new Exception("No se encontro un alumno con ese documento.");
        }
        return alumno.get();
    }
    
    public List<Cliente> buscarTodos() {
        return buscadorRepositorio.buscarTodosOrdenadoPorApellido();
    }
    
    @Transactional(rollbackFor = Exception.class)
    public void eliminar (String id) throws Exception {
        Cliente cliente = buscar(id);
        buscadorRepositorio.delete(cliente);
} 

}
