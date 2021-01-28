
package com.example.Hotel.repositorios;

import com.example.Hotel.entidades.Admin;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepositorio extends JpaRepository<Admin, String>{
    
    @Query("SELECT a FROM Admin a ORDER BY a.userName")
    List<Admin> buscarTodosOrdenadoPorNombre();
    
}
