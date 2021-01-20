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
            if(id==null || id.isEmpty()){
                throw new Exception ("El cliente debe tener una ID valida");
            }
            
            if(nombre==null || nombre.isEmpty()){
                throw new Exception ("El cliente debe indicar un NOMBRE valido");
            }
        
        if(apellido==null || apellido.isEmpty()){
            throw new Exception ("El cliente debe indicar un APELLIDO valido");
        }
        
        if(edad==null || edad<18){
            throw new Exception("El cliente debe tener una EDAD VALIDA");
        }
        
        if(mail==null || mail.isEmpty()){
            throw new Exception("El cliente debe indicar el CORREO ELECTRONICO");
        }
        
        if(mail.contains("@")==false){
            throw new Exception("El cliente debe indicar un CORREO ELECTRONICO valido");
        }
            
        cliente.setId(id);
        cliente.setNombre(nombre);
        cliente.setApellido(apellido);
        cliente.setEdad(edad);
        cliente.setMail(mail);

        clienteRepositorio.save(cliente);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception(" ERROR AL GUARDAR EL CLIENTE ");

        }
   
    }

    public void editarCliente(String id, String nombre, String apellido, Integer edad, String mail) throws Exception {
        Optional<Cliente> respuesta = clienteRepositorio.findById(id);
        if (respuesta.isPresent()) {
            Cliente cliente = respuesta.get();
            
    try { 
            if(nombre==null || nombre.isEmpty()){
                throw new Exception ("El cliente debe indicar un NOMBRE valido");
            }
        
        if(apellido==null || apellido.isEmpty()){
            throw new Exception ("El cliente debe indicar un APELLIDO valido");
        }
        
        if(edad==null || edad<18){
            throw new Exception("El cliente debe tener una EDAD VALIDA");
        }
        
        if(mail==null || mail.isEmpty()){
            throw new Exception("El cliente debe indicar el CORREO ELECTRONICO");
        }
        
        if(mail.contains("@")==false){
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


