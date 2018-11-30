package br.ucsal.edu.qrsala.local.entity.DTO;


public class SemanaDTO {
    private Integer diaSemana;
    private String descricaoSemana;

    public SemanaDTO(Integer diaSemana, String descricaoSemana){
        this.diaSemana = diaSemana;
        this.descricaoSemana = descricaoSemana;
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

}
