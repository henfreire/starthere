package model;

import org.json.JSONObject;

public class Lamentacao implements TISModel {
	private Long id;
	private String  nome,
				    descricao;
	private boolean status;
	private double  bonificacao;
	
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
	
	public boolean isStatus() {
		return status;
	}
	
	public double getBonificacao() {
		return bonificacao;
	}
	
	public void setBonificacao(double bonificacao) {
		this.bonificacao = bonificacao;
	}
	
	public void finalizarLamentacao() {
		this.status = true;
	}

	@Override
	public JSONObject toJSONObject() {
		JSONObject obj = new JSONObject ();
		
		obj.put("id", this.id);		
		obj.put("nome", this.nome);		
		obj.put("descricao", this.descricao);		
		obj.put("status", this.status);		
		obj.put("bonificacao", this.bonificacao);		
		
		return obj;
	}
	
	@Override
	public String toDATFormat() {
		return this.id + "|" +
			   this.nome + "|" +
			   this.descricao + "|" +
			   this.status + "|" +
			   this.bonificacao + "|";
	}

	@Override
	public void setDAT(String DAT) {
		String[] vet = DAT.split("|");
		
		this.id = Long.parseLong(vet[0]);
		this.nome = vet[1];
		this.descricao = vet[2];
		this.status = Boolean.parseBoolean(vet[3]);
		this.bonificacao = Double.parseDouble(vet[4]);
	}

	@Override
	public void setId(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}
}
