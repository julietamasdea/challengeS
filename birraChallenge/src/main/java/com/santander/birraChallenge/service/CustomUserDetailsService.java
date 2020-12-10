
package com.santander.birraChallenge.service;

import com.santander.birraChallenge.model.CustomUserDetails;
import com.santander.birraChallenge.model.Usuario;
import com.santander.birraChallenge.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    IUsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByUsername(username);
        CustomUserDetails userDetails = null;
        if (usuario != null ) {
            userDetails = new CustomUserDetails();
            userDetails.setUsuario(usuario);
        } else {
            throw new UsernameNotFoundException("Usuario inexistente");
        }
        return userDetails;
    }
}
