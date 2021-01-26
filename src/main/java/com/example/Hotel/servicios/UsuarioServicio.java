package com.example.Hotel.servicios;

import com.example.Hotel.entidades.Usuario;
import com.example.Hotel.repositorios.UsuarioRepositorio;
import java.util.Collections;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServicio implements UserDetailsService{

    private final UsuarioRepositorio usuarioRepositorio;
    private final BCryptPasswordEncoder encoder;

    @Autowired
    public UsuarioServicio(UsuarioRepositorio usuarioRepositorio, BCryptPasswordEncoder encoder) {
        this.usuarioRepositorio = usuarioRepositorio;
        this.encoder = encoder;
    }
    
    @Transactional(rollbackOn = Exception.class)
    public void guardar(Usuario usuario){
        usuario.setPassword(encoder.encode(usuario.getPassword()));
        usuarioRepositorio.save(usuario);
    }
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepositorio.findByUsername(username);
        
        if(usuario == null){
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
        
        List<GrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority("USER"));
        
        return new User(usuario.getUsername(), usuario.getPassword(),authorities);
    }
}
