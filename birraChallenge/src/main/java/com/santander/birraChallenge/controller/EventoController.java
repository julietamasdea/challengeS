package com.santander.birraChallenge.controller;

import com.santander.birraChallenge.model.Evento;
import com.santander.birraChallenge.service.IEventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@CrossOrigin(origins= {"*"},
        methods = {RequestMethod.PUT, RequestMethod.POST, RequestMethod.GET, RequestMethod.DELETE, RequestMethod.OPTIONS}
)
@RestController
@RequestMapping("/api/secure")
public class EventoController {
    @Autowired
    private IEventoService eventoService;

    @GetMapping("/eventos")
    public List<Evento> listarEventos() {
        List<Evento> eventos = eventoService.findAll();
        for (Evento e: eventos) {
            e.setCantidadUsuarios(e.getUsuarios().size());
        }
        return eventos;
    }

    @GetMapping("eventos/byname/{nombreEvento}")
    public Evento byname(@RequestBody String nombreEvento) {
        Evento evento = eventoService.findByNombre(nombreEvento);
        return evento;
    }

    @PostMapping("/eventos")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> crearEvento(@RequestBody Evento evento) {
        Evento eventoNew = null;
        Map<String,Object> response = new HashMap<>();
        try {
            eventoNew = eventoService.save(evento);
        } catch (DataAccessException e){
            response.put("message", (e.getMessage()));
            return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<Evento>(eventoNew, HttpStatus.OK);
    }
    @PutMapping("/eventos/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Evento modificarEvento(@RequestBody Evento evento, @PathVariable Integer id) {
        Evento eventoNew = eventoService.findById(id);
        eventoNew.setFecha(evento.getFecha());
        eventoNew.setNombre(evento.getNombre());
        eventoNew.setCantidadUsuarios(evento.getCantidadUsuarios());
        eventoNew.setUsuarios(evento.getUsuarios());
        return eventoService.save(eventoNew);
    }

}
