package br.ucsal.edu.qrsala.local.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ucsal.edu.qrsala.local.entity.Sala;
import br.ucsal.edu.qrsala.local.repository.SalaRepository;


@Service
public class SalaService {

    @Autowired
    private SalaRepository salaRepository;

    public List<Sala> obterTodos(){
        return salaRepository.obterTodos();
    }

}
