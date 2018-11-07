package model;

import org.json.JSONObject;

public class Investidor extends Usuario {
	
	public Investidor(String nome, String email) {
		super(nome, email);
	}

	@Override
	public JSONObject toJSONObject() {
		return super.toJSONObject();
	}

	@Override
	public String toDATFormat() {
		return super.toDATFormat();
	}

	@Override
	public void setDAT(String DAT) {
		super.setDAT(DAT);
	}
}
