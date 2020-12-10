package com.santander.birraChallenge.service;

import com.santander.birraChallenge.model.Usuario;

import java.util.List;

public interface IUsuarioService {
    public List<Usuario> findAll();
    public Usuario findById(Integer id);
    public Usuario save(Usuario usuario);
}
