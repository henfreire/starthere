package model;

import java.util.Date;

import org.json.JSONObject;

import util.toDAT;
import util.toJSON;

public class Evento implements toDAT, toJSON {
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
		return id + "|" + nome + "|" + descricao + "|" + dataEvento.toString() + "|" ;
	}

	@Override
	public void setDAT(String DAT) {
		String[] vet = DAT.split("|");
		this.id = Long.parseLong(vet[0]);
		this.nome = vet[1];
		this.descricao = vet[2];
//		this.dataEvento = vet[3];
	}

	@Override
	public JSONObject toJSONObject() {
		JSONObject obj = new JSONObject();
		
		obj.put("id", id);		
		obj.put("nome", nome);		
		obj.put("descricao", descricao);		
		obj.put("dataEvento", dataEvento);
		
		return obj;
	}
}
