package com.santander.birraChallenge.controller;

import com.santander.birraChallenge.model.Usuario;
import com.santander.birraChallenge.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/secure/auth/")
public class AdminController {
    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    /*@PreAuthorize("hasAnyRole('ADMIN')")


    @PostMapping("/admin/add")
    public String agregarUsuarioAdmin(@RequestBody Usuario usuario) {
        String password = usuario.getPassword();
        /*
        String encryptPassword = passwordEncoder.encode(password);
        usuario.setPassword(encryptPassword);

     */
    /*
        usuario.setPassword(password);
        usuarioRepository.save(usuario);
        return "se agrego correctamente";
    }*/
    @PostMapping("/admin/add")
    public String addUserByAdmin(@RequestBody Usuario usuario) {
        String pwd = usuario.getPassword();
        String encryptPwd = passwordEncoder.encode(pwd);
        usuario.setPassword(encryptPwd);
        usuarioRepository.save(usuario);
        return "user added successfully...";
    }
}
