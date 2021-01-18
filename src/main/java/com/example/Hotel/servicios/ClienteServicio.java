package com.example.Hotel.servicios;

import com.example.Hotel.entidades.Cliente;
import com.example.Hotel.repositorios.ClienteRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServicio {

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    public void crearCliente(String id, String nombre, String apellido, Integer edad, String mail) throws Exception{
        Cliente cliente = new Cliente();
        
        try {
            if(cliente.getId()==null || cliente.getId().isEmpty()){
            throw new Exception ("El cliente debe tener una ID valida");
        }
        if(cliente.getNombre()==null || cliente.getNombre().isEmpty()){
            throw new Exception ("El cliente debe indicar un NOMBRE valido");
        }
        
        if(cliente.getApellido()==null || cliente.getApellido().isEmpty()){
            throw new Exception ("El cliente debe indicar un APELLIDO valido");
        }
        
        if(cliente.getEdad()==null || cliente.getEdad()<18){
            throw new Exception("El cliente debe tener una EDAD VALIDA");
        }
        
        if(cliente.getMail()==null || cliente.getMail().isEmpty()){
            throw new Exception("El cliente debe indicar el CORREO ELECTRONICO");
        }
        
        if(cliente.getMail().contains("@")==false){
            throw new Exception("El cliente debe indicar un CORREO ELECTRONICO valido");
        }
            
        cliente.setId(id);
        cliente.setNombre(nombre);
        cliente.setApellido(apellido);
        cliente.setEdad(edad);
        cliente.setMail(mail);

        clienteRepositorio.save(cliente);
        } catch (Exception e) {
            throw new Exception(" ERROR AL GUARDAR EL CLIENTE ");

        }
   
    }

    public void editarCliente(String id, String nombre, String apellido, Integer edad, String mail) throws Exception {
        Optional<Cliente> respuesta = clienteRepositorio.findById(id);
        if (respuesta.isPresent()) {
            Cliente cliente = respuesta.get();
            
    try {
        if(cliente.getNombre()==null || cliente.getNombre().isEmpty()){
            throw new Exception ("El cliente debe indicar un NOMBRE valido");
        }
        
        if(cliente.getApellido()==null || cliente.getApellido().isEmpty()){
            throw new Exception ("El cliente debe indicar un APELLIDO valido");
        }
        
        if(cliente.getEdad()==null || cliente.getEdad()<18){
            throw new Exception("El cliente debe tener una EDAD VALIDA");
        }
        
        if(cliente.getMail()==null || cliente.getMail().isEmpty()){
            throw new Exception("El cliente debe indicar el CORREO ELECTRONICO");
        }
        
        if(cliente.getMail().contains("@")==false){
            throw new Exception("El cliente debe indicar un CORREO ELECTRONICO valido");
        }
            
        cliente.setNombre(nombre);
        cliente.setApellido(apellido);
        cliente.setEdad(edad);
        cliente.setMail(mail);

        clienteRepositorio.save(cliente);
        } catch (Exception e) {
            throw new Exception(" ERROR AL GUARDAR DATOS DEL CLIENTE ");
        }

        } else {
            throw new Exception("ERROR - CLIENTE NO ENCONTRADO");
        }
    }

    public List<Cliente> consultarCLientes() {
        return clienteRepositorio.findAll();
    }

    public void eliminarCliente(String id) throws Exception {
        Optional<Cliente> respuesta = clienteRepositorio.findById(id);
        if (respuesta.isPresent()) {
            Cliente cliente = respuesta.get();
            clienteRepositorio.delete(cliente);

        } else {
            throw new Exception("ERROR - CLIENTE NO ENCONTRADO");
        }
    }
}

