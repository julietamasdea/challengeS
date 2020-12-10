package com.santander.birraChallenge.service;

import com.santander.birraChallenge.model.Evento;
import com.santander.birraChallenge.model.Usuario;
import com.santander.birraChallenge.repository.IEventoRepository;
import com.santander.birraChallenge.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Service
public class EventoService implements IEventoService {
    @Autowired
    private IEventoRepository eventoRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Evento> findAll() {
        return (List<Evento>) eventoRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Evento findById(Integer id) {
        return eventoRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Evento save(Evento evento) {
        return eventoRepository.save(evento);
    }

    @Override
    @Transactional
    public Evento findByNombre(String nombre) {
        ArrayList<Evento> eventos = (ArrayList<Evento>) eventoRepository.findAll();
        for (Evento evento:eventos) {
            String nombreprueba = evento.getNombre();
            if (evento.getNombre().equals(nombre)) {
                return evento;
            }
        }
        return null;
    }
}
