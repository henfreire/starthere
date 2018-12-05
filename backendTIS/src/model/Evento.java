package model;

import org.json.JSONObject;

public class Evento implements TISModel {
	private Long     id;
	private Long     idEmpresa;
	
	private String   nome,
					 descricao;
	private String   dataEvento;
	
	public Evento() {}
	
	public Evento(String nome, String descricao, String dataEvento) {
		this.nome = nome;
		this.descricao = descricao;
		this.dataEvento = dataEvento;
	}

	public Long getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(Long idEmpresa) {
		this.idEmpresa = idEmpresa;
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

	public String getDataEvento() {
		return dataEvento;
	}

	public void setDataEvento(String dataEvento) {
		this.dataEvento = dataEvento;
	}

	@Override
	public String toDATFormat() {
		return  id + "|" + 
				idEmpresa + "|" + 
				nome + "|" + 
				descricao + "|" + 
				dataEvento + "|" ;
	}

	@Override
	public void setDAT(String DAT) {
		String[] vet = DAT.split("\\|");

		id = Long.parseLong(vet[0]);
		idEmpresa = Long.parseLong(vet[1]);
		nome = vet[2];
		descricao = vet[3];
		dataEvento = vet[4];
	}

	@Override
	public JSONObject toJSONObject() {
		JSONObject obj = new JSONObject();

		obj.put("id", id);
		obj.put("idEmpresa", idEmpresa);		
		obj.put("nome", nome);		
		obj.put("descricao", descricao);		
		obj.put("dataEvento", dataEvento);
		
		return obj;
	}
}
