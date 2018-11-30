package br.ucsal.edu.qrsala.util.enums;

public enum SemanaEnum {

    SEGUNDA(1, "Segunda-feira"),
    TERCA(2, "Terça-feira"),
    QUARTA(3, "Quarta-feira"),
    QUINTA(4, "Quinta-feira"),
    SEXTA(5, "Sexta-fera"),
    SABADO(6, "Sábado"),
    DOMINGO(7, "Domingo");

    private Integer codigo;
    private String descricao;

    SemanaEnum(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public static String descricaoPorCodigo(Integer diaSemana) {
        for (SemanaEnum semanaEnum : values()) {
            if(semanaEnum.codigo.equals(diaSemana)){
                return semanaEnum.descricao;
            }
        }
        return "";
    }

    public static SemanaEnum enumPorCodigo(Integer diaSemana) {
        for (SemanaEnum semanaEnum : values()) {
            if(semanaEnum.codigo.equals(diaSemana)){
                return semanaEnum;
            }
        }
        return null;
    }



    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
