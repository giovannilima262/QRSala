package br.ucsal.edu.qrsala.controller;


import java.util.List;

import br.ucsal.edu.qrsala.local.entity.DTO.SemanaDTO;
import br.ucsal.edu.qrsala.local.entity.DTO.SemanaSalaDTO;
import br.ucsal.edu.qrsala.util.enums.SemanaEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.ucsal.edu.qrsala.local.entity.Sala;
import br.ucsal.edu.qrsala.local.service.SalaService;


@RestController
@RequestMapping("/api/sala")
public class SalaController {

    @Autowired
    private SalaService salaService;

    @RequestMapping(value = "/nome/{nome}/semana/{semana}", method = RequestMethod.GET)
    public ResponseEntity<List<Sala>> obterPorNomeAndSemana(@PathVariable String nome, @PathVariable Integer semana) {
        try {
            List<Sala> salas = salaService.obterPorNomeAndSemana(nome, semana);
            return new ResponseEntity<>(salas, HttpStatus.OK);
        }catch (Exception e){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/semana/distinct", method = RequestMethod.GET)
    public ResponseEntity<List<SemanaDTO>> obterSalaDistinctPorSemana() {
        try {
            List<SemanaDTO> salas = salaService.obterDistinctSemana();
            return new ResponseEntity<>(salas, HttpStatus.OK);
        }catch (Exception e){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/distinct/semana/{semana}", method = RequestMethod.GET)
    public ResponseEntity<List<String>> obterSalaDistinctPorSemana(@PathVariable Integer semana) {
        try {
            List<String> salas = salaService.obterSalaDistinctPorSemana(semana);
            return new ResponseEntity<>(salas, HttpStatus.OK);
        }catch (Exception e){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
