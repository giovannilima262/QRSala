package br.ucsal.edu.qrsala.local.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Sala {

    @Id
    private Long id;
    
    @Column(name="NOME")
    private String nome;

    @Column(name="DIASEMANA")
    private Integer diaSemana;

    @Transient
	private String descricaoDiaSemana;
    
    @Column(name="NOME_PROFESSOR")
    private String nomeProfessor;
    
    @Column(name="HORARIO_INICIO")
    private String horarioInicio;

    @Column(name="HORARIO_FIM")
    private String horarioFim;
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getNomeProfessor() {
		return nomeProfessor;
	}

	public void setNomeProfessor(String nomeProfessor) {
		this.nomeProfessor = nomeProfessor;
	}

	public String getHorarioInicio() {
		return horarioInicio;
	}

	public void setHorarioInicio(String horarioInicio) {
		this.horarioInicio = horarioInicio;
	}

	public String getHorarioFim() {
		return horarioFim;
	}

	public void setHorarioFim(String horarioFim) {
		this.horarioFim = horarioFim;
	}

	public Integer getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(Integer diaSemana) {
		this.diaSemana = diaSemana;
	}

	public String getDescricaoDiaSemana() {
		return descricaoDiaSemana;
	}

	public void setDescricaoDiaSemana(String descricaoDiaSemana) {
		this.descricaoDiaSemana = descricaoDiaSemana;
	}
}
