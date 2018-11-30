package br.ucsal.edu.qrsala.local.service;

import java.util.ArrayList;
import java.util.List;

import br.ucsal.edu.qrsala.local.entity.DTO.SemanaDTO;
import br.ucsal.edu.qrsala.local.entity.DTO.SemanaSalaDTO;
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
        return salaRepository.obterDistinctNome();
    }


    public List<Sala> obterSalasPorDiaSemana(Integer semana) {
        List<Sala> salas = salaRepository.obterSalasPorDiaSemana(semana);
        salas = adicionarDescricaoSemana(salas);
        return salas;
    }

    private List<SemanaSalaDTO> agruparSalasPorSemana(List<Sala> salas) {
        List<SemanaSalaDTO> semanaSalaDTOList = new ArrayList<>();
        Integer diaSemanaAnterior = null;
        SemanaSalaDTO semanaSalaDTO = new SemanaSalaDTO();
        for (Sala sala : salas) {
            if(diaSemanaAnterior == null || !sala.getDiaSemana().equals(diaSemanaAnterior)) {
                semanaSalaDTO = new SemanaSalaDTO();
                semanaSalaDTO.setDescricaoSemana(sala.getDescricaoDiaSemana());
                semanaSalaDTO.setDiaSemana(sala.getDiaSemana());
            }else {
                semanaSalaDTOList.add(semanaSalaDTO);
            }
            semanaSalaDTO.getSalas().add(sala);
            diaSemanaAnterior = sala.getDiaSemana();

        }
        return semanaSalaDTOList;
    }

    private List<Sala> adicionarDescricaoSemana(List<Sala> salas) {
        for (int i = 0; i < salas.size(); i++) {
            Sala sala = salas.get(i);
            sala.setDescricaoDiaSemana(SemanaEnum.descricaoPorCodigo(sala.getDiaSemana()));
        }
        return salas;
    }

    public List<SemanaDTO> obterDistinctSemana() {
        List<Integer> diaSemanaIntegerList = salaRepository.obterDistinctSemana();
        List<SemanaDTO> descricaoStringList = new ArrayList<>();
        for (int i = 0; i < diaSemanaIntegerList.size(); i++) {
            Integer dia = diaSemanaIntegerList.get(i);
            SemanaEnum semanaEnum = SemanaEnum.enumPorCodigo(dia);
            descricaoStringList.add(new SemanaDTO(semanaEnum.getCodigo(), semanaEnum.getDescricao()));
        }
        return descricaoStringList;
    }
}
