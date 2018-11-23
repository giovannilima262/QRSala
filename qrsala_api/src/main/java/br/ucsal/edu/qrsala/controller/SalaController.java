package br.ucsal.edu.qrsala.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.ucsal.edu.qrsala.local.entity.Sala;
import br.ucsal.edu.qrsala.local.service.SalaService;


@RestController
@RequestMapping("/api/sala")
public class SalaController {

    @Autowired
    private SalaService salaService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<Sala>> obterTodosPorTipo() {
        try {
            List<Sala> gastos = salaService.obterTodos();
            return new ResponseEntity<>(gastos, HttpStatus.OK);
        }catch (Exception e){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
