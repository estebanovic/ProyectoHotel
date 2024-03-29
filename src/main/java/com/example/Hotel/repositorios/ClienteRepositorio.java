package com.example.Hotel.repositorios;

import com.example.Hotel.entidades.Cliente;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente,String> {
    
    @Query("SELECT a FROM Cliente a ORDER BY a.apellido, a.nombre")
    List<Cliente> buscarTodosOrdenadoPorApellido();
}
