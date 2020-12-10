package com.santander.birraChallenge.service;


import com.santander.birraChallenge.model.Evento;

import java.util.List;

public interface IEventoService {
    public List<Evento> findAll();
    public Evento findById(Integer id);
    public Evento save(Evento evento);
    public Evento findByNombre(String nombre);
}
