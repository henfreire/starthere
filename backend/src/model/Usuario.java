package model;

import org.json.JSONObject;

public class Usuario implements toJSON {
	private static long cont = 0; 
	private long id;
	private String nome,
				   senha,
				   email;

	public Usuario(String nome, String senha, String email) {
		this.id = ++Usuario.cont;
		this.nome = nome;
		this.senha = senha;
		this.email = email;
	}
	
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

	@Override
	public JSONObject toJSONObject() {
		JSONObject obj = new JSONObject();

		obj.put("id", id);
		obj.put("nome", nome);
		obj.put("email", email);
		
		return obj;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", senha=" + senha + ", email=" + email + "]";
	}
	
}
