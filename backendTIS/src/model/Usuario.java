package model;

import javax.swing.JOptionPane;

import org.json.JSONObject;

import util.toDAT;
import util.toJSON;

public class Usuario implements toJSON, toDAT, IUsuario<Usuario> {
	protected Long id;
	protected String nome,
				   senha,
				   email,
				   linkSite,
				   linkLinkedIn,
				   imagem;
	
	public Usuario() {}
	
	public Usuario(Usuario user) {
		this.setUserData(user);
	}
	
	public String getLinkSite() {
		return linkSite;
	}

	public void setLinkSite(String linkSite) {
		this.linkSite = linkSite;
	}

	public String getLinkLinkedIn() {
		return linkLinkedIn;
	}

	public void setLinkLinkedIn(String linkLinkedIn) {
		this.linkLinkedIn = linkLinkedIn;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
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

	@Override
	public JSONObject toJSONObject() {
		JSONObject obj = new JSONObject();

		obj.put("id", id);
		obj.put("nome", nome);
		obj.put("email", email);
		
		return obj;
	}

	@Override
	public String toDATFormat() {
		return  String.valueOf(id) + "|" + 
				nome + "|" + 
				senha + "|" + 
				email + "|" + 
				linkSite + "|" + 
				linkLinkedIn + "|" +
				imagem + "|";
	}

	@Override
	public void setDAT(String DAT) {
		String[] vet = DAT.split("\\|");
		
		this.id = Long.parseLong(vet[0]);
		this.nome = vet[1];
		this.senha = vet[2]; 
		this.email = vet[3]; 
		this.linkSite = vet[4];
		this.linkLinkedIn = vet[5];
		this.imagem = vet[6];
	}

	@Override
	public void setUserData(Usuario user) {
		this.id = user.getId();
		this.nome = user.getNome();
		this.senha = user.getSenha();
		this.email = user.getEmail();
		this.linkSite = user.getLinkSite();
		this.linkLinkedIn = user.getLinkLinkedIn();
		this.imagem = user.getImagem();
	}
}
