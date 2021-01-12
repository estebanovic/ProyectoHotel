package com.example.Hotel.servicios;

import com.example.Hotel.entidades.Cliente;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServicio {

    private final ClienteRepositorio clienteRepositorio;
    
    @Autowired
    
    
    public void crearCliente(String id, String nombre, String apellido, Integer edad, String mail){
        Cliente cliente = new Cliente();
        cliente.setId(id);
        cliente.setNombre(nombre);
        cliente.setApellido(apellido);
        cliente.setEdad(edad);
        cliente.setMail(mail);
        
        clienteRepositorio.save(cliente);
    }
    
    public void editarCliente(String id, String nombre, String apellido, Integer edad, String mail)throws Exception{
        Optional<Cliente> respuesta = clienteRepositorio.findById(id);
        if (respuesta.isPresent()) {
            Cliente cliente = respuesta.get();
            cliente.setNombre(nombre);
            cliente.setApellido(apellido);
            cliente.setEdad(edad);
            cliente.setMail(mail);
            
            clienteRepositorio.save(cliente);
        } else {
            throw new Exception("ERROR");
        }
    }
    
    public List<Cliente> consultarCLientes(){
        return clienteRepositorio.findAll();
    }
    
    public void eliminarCliente(String id)throws Exception{
        Optional<Cliente> respuesta = clienteRepositorio.findById(id);
        if (respuesta.isPresent()) {
            Cliente cliente = respuesta.get();
            clienteRepositorio.delete(cliente);

        } else {
            throw new Exception("ERROR");
        }
    }
}
