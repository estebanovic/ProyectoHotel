
package com.example.Hotel.servicios;

import com.example.Hotel.entidades.Admin;
import com.example.Hotel.repositorios.AdminRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdminServicio implements UserDetailsService{

    private final AdminRepositorio adminRepositorio;

    @Autowired
    public AdminServicio(AdminRepositorio adminRepositorio) {
        this.adminRepositorio = adminRepositorio;
    }

    @Transactional(rollbackFor = Exception.class)
    public void crearAdmin(String id, String userName, String mail, String password) throws Exception {
        Admin admin = new Admin();

        try {
            if (id == null || id.isEmpty()) {
                throw new Exception("El Administrador debe tener una ID valida");
            }

            if (userName == null || userName.isEmpty()) {
                throw new Exception("El Administrador debe indicar un NOMBRE DE USUARIO valido");
            }

            if (password == null || password.isEmpty()) {
                throw new Exception("El Administrador debe indicar UNA PASSWORD valida");
            }

            if (mail == null || mail.isEmpty()) {
                throw new Exception("El Administrador debe indicar el CORREO ELECTRONICO");
            }

            if (mail.contains("@") == false) {
                throw new Exception("El Administrador debe indicar un CORREO ELECTRONICO valido");
            }

            admin.setId(id);
            admin.setUserName(userName);
            admin.setPassword(password);
            admin.setMail(mail);

            adminRepositorio.save(admin);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception(" ERROR AL GUARDAR AL ADMINISTRADOR ");

        }

    }

    public Admin BuscarCliente(String id) throws Exception {
        Optional<Admin> respuesta = adminRepositorio.findById(id);
        if (respuesta.isPresent()) {
            return respuesta.get();
        } else {
            return null;
        }

    }

    @Transactional(rollbackFor = Exception.class)
    public void editarAdmin(String id, String userName, String mail, String password) throws Exception {
        Optional<Admin> respuesta = adminRepositorio.findById(id);
        if (respuesta.isPresent()) {
            Admin admin = respuesta.get();

            try {
                if (id == null || id.isEmpty()) {
                    throw new Exception("El Administrador debe tener una ID valida");
                }

                if (userName == null || userName.isEmpty()) {
                    throw new Exception("El Administrador debe indicar un NOMBRE DE USUARIO valido");
                }

                if (password == null || password.isEmpty()) {
                    throw new Exception("El Administrador debe indicar UNA PASSWORD valida");
                }

                if (mail == null || mail.isEmpty()) {
                    throw new Exception("El Administrador debe indicar el CORREO ELECTRONICO");
                }

                if (mail.contains("@") == false) {
                    throw new Exception("El Administrador debe indicar un CORREO ELECTRONICO valido");
                }

                admin.setId(id);
                admin.setUserName(userName);
                admin.setPassword(password);
                admin.setMail(mail);

                adminRepositorio.save(admin);
            } catch (Exception e) {
                throw new Exception(" ERROR AL GUARDAR DATOS DEL ADMINISTRADOR ");
            }

        } else {
            throw new Exception("ERROR - ADMINISTRADOR NO ENCONTRADO");
        }
    }

    public List<Admin> consultarCLientes() {
        return adminRepositorio.findAll();
    }

    public void eliminarCliente(String id) throws Exception {
        Optional<Admin> respuesta = adminRepositorio.findById(id);
        if (respuesta.isPresent()) {
            Admin admin = respuesta.get();
            adminRepositorio.delete(admin);

        } else {
            throw new Exception("ERROR - ADMINISTRADOR NO ENCONTRADO");
        }
    }
}

