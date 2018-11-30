package br.ucsal.edu.qrsala.controller;


import java.util.List;

import com.sun.org.glassfish.gmbal.ParameterNames;
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

    @RequestMapping(value = "/distinct", method = RequestMethod.GET)
    public ResponseEntity<List<String>> obterTodosPorTipo() {
        try {
            List<String> salas = salaService.obterDistinctNome();
            return new ResponseEntity<>(salas, HttpStatus.OK);
        }catch (Exception e){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/{nome}", method = RequestMethod.GET)
    public ResponseEntity<List<Sala>> obterTodosPorTipo(@PathVariable String nome) {
        try {
            List<Sala> salas = salaService.obterSalasPorNome(nome);
            return new ResponseEntity<>(salas, HttpStatus.OK);
        }catch (Exception e){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
