package model;

import java.util.Date;

import util.toDAT;

public class Evento implements toDAT {
	private Long     id;
	private String   nome,
					 descricao;
	private Date     dataEvento;
	
	public Evento() {}
	
	public Evento(String nome, String descricao, Date dataEvento) {
		this.nome = nome;
		this.descricao = descricao;
		this.dataEvento = dataEvento;
	}

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

	@Override
	public String toDATFormat() {
		return null;
	}

	@Override
	public void setDAT(String DAT) {
	}
}
