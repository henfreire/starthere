package model;

import org.json.JSONObject;

public class Empresa extends Usuario {
	private String razaoSocial;

	public Empresa() {}
	
	public Empresa(String nome, String email) {
		super(nome, email);
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
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
		super.setDAT(DAT);
		
		String[] vet = DAT.split("|");
		
		this.razaoSocial = vet[7];
	}
}
