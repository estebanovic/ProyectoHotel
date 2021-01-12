package com.example.Hotel.repositorios;

import com.example.Hotel.entidades.Pieza;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PiezaRepositorio extends JpaRepository<Pieza,String> {
    
    @Query("SELECT b FROM Pieza b ORDER BY b.tipoPieza, b.precioNoche")
    List<Pieza> buscarTodosOrdenadoPorApellido();
}
