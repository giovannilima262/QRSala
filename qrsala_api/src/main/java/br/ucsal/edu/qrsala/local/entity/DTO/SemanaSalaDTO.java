package br.ucsal.edu.qrsala.local.entity.DTO;

import br.ucsal.edu.qrsala.local.entity.Sala;

import java.util.ArrayList;
import java.util.List;

public class SemanaSalaDTO {
    private Integer diaSemana;
    private String descricaoSemana;
    private List<Sala> salas;

    public SemanaSalaDTO(){
        salas = new ArrayList<>();
    }


    public Integer getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(Integer diaSemana) {
        this.diaSemana = diaSemana;
    }

    public String getDescricaoSemana() {
        return descricaoSemana;
    }

    public void setDescricaoSemana(String descricaoSemana) {
        this.descricaoSemana = descricaoSemana;
    }

    public List<Sala> getSalas() {
        return salas;
    }

    public void setSalas(List<Sala> salas) {
        this.salas = salas;
    }
}
