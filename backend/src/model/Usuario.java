package model;

import org.json.JSONObject;

public abstract class Usuario implements toJSON{
	private long id;
	private String nome,
				   senha,
				   email;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}	
	
	public void criarLamentacao (String nome) {
		// not implemented
	}

	public JSONObject toJSONObject() {
		return null;
	}
	
}
