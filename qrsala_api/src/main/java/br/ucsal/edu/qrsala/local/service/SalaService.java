package br.ucsal.edu.qrsala.local.service;

import java.util.List;

import br.ucsal.edu.qrsala.util.enums.SemanaEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ucsal.edu.qrsala.local.entity.Sala;
import br.ucsal.edu.qrsala.local.repository.SalaRepository;


@Service
public class SalaService {

    @Autowired
    private SalaRepository salaRepository;

    public List<Sala> obterTodos(){
        List<Sala> salas = salaRepository.obterTodos();
        salas = adicionarDescricaoSemana(salas);
        return salas;
    }

    public List<String> obterDistinctNome(){
        List<String> salas = salaRepository.obterDistinctNome();
        return salas;
    }

    private List<Sala> adicionarDescricaoSemana(List<Sala> salas) {
        for (int i = 0; i < salas.size(); i++) {
            Sala sala = salas.get(i);
            sala.setDescricaoDiaSemana(SemanaEnum.descricaoPorCodigo(sala.getDiaSemana()));
        }
        return salas;
    }

    public List<Sala> obterSalasPorNome(String nome) {
        List<Sala> salas = salaRepository.obterSalasPorNome(nome);
        salas = adicionarDescricaoSemana(salas);
        return salas;
    }
}
