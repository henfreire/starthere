package model;

import org.json.JSONObject;

import util.toDAT;
import util.toJSON;

public abstract class Ranking<E> implements toJSON, toDAT {
	private E valor;

	public E getValor() {
		return valor;
	}

	public void setValor(E valor) {
		this.valor = valor;
	}
	
	@Override
	public JSONObject toJSONObject() {
		JSONObject obj = new JSONObject ();
		
		obj.put("valor", this.valor);	
		
		return obj;
	}
}

// 1 - Imatura
// 2 - Boa 
// 3 - Ótima
// 4 - Excelente
// 5 - Super




