
package com.example.Hotel.repositorios;

import com.example.Hotel.entidades.Arriendo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ArriendoRepositorio extends JpaRepository<Arriendo,String> {
    
    @Query("SELECT c FROM Arriendo c ORDER BY c.fechaIngreso, c.fechaRetiro")
    List<Arriendo> buscarTodosOrdenadoPorApellido();
    
}
