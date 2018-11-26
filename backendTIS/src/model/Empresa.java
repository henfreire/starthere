package model;

import java.util.List;

import org.json.JSONObject;

public class Empresa extends Usuario {
	private String razaoSocial;
	private List<Evento> eventos;

	public Empresa() {}
	
	public Empresa (Usuario user) {
		this.setUserData(user);
	}
	
	public Empresa(String nome, String email) {
		super(nome, email);
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public List<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}

	@Override
	public JSONObject toJSONObject() {
		JSONObject obj = super.toJSONObject();
		obj.put("razaoSocial", this.razaoSocial);
		return obj;
	}

	@Override
	public String toDATFormat() {
		return super.toDATFormat() + this.razaoSocial + "|";
	}

	@Override
	public void setDAT(String DAT) {
		String[] vet = DAT.split("|");
		this.setId(Long.parseLong(vet[0]));
		this.razaoSocial = vet[1];
	}
	
	public void setUserData(Usuario user) {
		this.setEmail(user.getEmail());
		this.setNome(user.getNome());
		this.setSenha(user.getSenha());
		this.setLinkSite(user.getLinkSite());
		this.setLinkLinkedIn(user.getLinkLinkedIn());
		this.setImagem(user.getImagem());
	}
}
