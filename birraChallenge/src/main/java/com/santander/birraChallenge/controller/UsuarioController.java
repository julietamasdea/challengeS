package com.santander.birraChallenge.controller;

import com.santander.birraChallenge.model.Usuario;
import com.santander.birraChallenge.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins= {"*"},
        methods = {RequestMethod.PUT, RequestMethod.POST, RequestMethod.GET, RequestMethod.DELETE, RequestMethod.OPTIONS}
)
@RestController
@RequestMapping("/api")
public class UsuarioController {
    @Autowired
    private IUsuarioService usuarioService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @GetMapping("/usuarios")
    public List<Usuario> listarUsuarios() {
        return usuarioService.findAll();
    }

    @GetMapping("/usuarios/{id}")
    public ResponseEntity<?> obtenerUsuario(@PathVariable Integer id) {
        Usuario usuario = null;
        Map<String,Object> response = new HashMap<>();
        try {
            usuario = usuarioService.findById(id);
        } catch (DataAccessException e){
            response.put("message", (e.getMessage()));
            return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if (usuario == null) {
            response.put("message", (id.toString().concat(" no existe")));
            return new ResponseEntity<Map<String,Object>>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
    }

    @PostMapping("/usuarios")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> crearUsuario(@RequestBody Usuario usuario) {
        Usuario usuarioNew = null;
        String pwd = usuario.getPassword();
        Map<String,Object> response = new HashMap<>();
        try {
            String encryptPwd = passwordEncoder.encode(pwd);
            usuario.setPassword(encryptPwd);
            usuarioNew = usuarioService.save(usuario);
        } catch (DataAccessException e){
            response.put("message", (e.getMessage()));
            return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<Usuario>(usuarioNew, HttpStatus.OK);
    }

    @PutMapping("/usuarios/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario modificarUsuario(@RequestBody Usuario usuario, @PathVariable Integer id) {
        Usuario usuarioNew = usuarioService.findById(id);
        usuarioNew.setApellido(usuario.getApellido());
        usuarioNew.setNombre(usuario.getNombre());
        usuarioNew.setEmail(usuario.getEmail());
        usuarioNew.setPassword(usuario.getPassword());
        usuarioNew.setUsername(usuario.getUsername());
        return usuarioService.save(usuarioNew);
    }
}
