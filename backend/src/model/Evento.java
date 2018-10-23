package model;

import java.util.Date;

public class Evento {
	private long    id;
	private Empresa empCriadora;
	private String  nome,
					descricao;
	private Date    dataEvento;
	
	Evento(String nome, Empresa emp) {
		this.nome = nome;
		this.empCriadora = emp;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Empresa getEmpCriadora() {
		return empCriadora;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataEvento() {
		return dataEvento;
	}

	public void setDataEvento(Date dataEvento) {
		this.dataEvento = dataEvento;
	}
}
