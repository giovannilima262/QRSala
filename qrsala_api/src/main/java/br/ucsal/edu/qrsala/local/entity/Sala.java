package br.ucsal.edu.qrsala.local.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Sala {

    @Id
    private Long id;
    
    @Column(name="NOME")
    private String nome;
    
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
    
    


}
