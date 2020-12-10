package com.santander.birraChallenge.repository;

import com.santander.birraChallenge.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface IEventoRepository extends JpaRepository<Evento, Integer> {
    Evento findById(String id);
    List<Evento> findAll();
}
