/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Hotel.repositorios;


import com.example.Hotel.entidades.Cliente;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BuscadorRepositorio extends JpaRepository<Cliente,String> {
    
    @Query("SELECT a FROM Cliente a ORDER BY a.apellido, a.nombre")
    List<Cliente> buscarTodosOrdenadoPorApellido();
}
