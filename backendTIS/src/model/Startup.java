package model;

import java.util.Calendar;

import org.json.JSONObject;

public class Startup extends Usuario {
	private Calendar dataFundacao;
	private double capitalGiro;
	private Ranking<Integer> ranking;
	
	public Startup() {
		super();
	}
	
	public Startup(Usuario user) {
		super(user);
	}
	
	public Calendar getDataFundacao() {
		return dataFundacao;
	}

	public void setDataFundacao(Calendar dataFundacao) {
		this.dataFundacao = dataFundacao;
	}

	public double getCapitalGiro() {
		return capitalGiro;
	}

	public void setCapitalGiro(double capitalGiro) {
		this.capitalGiro = capitalGiro;
	}

	public Ranking<Integer> getRanking() {
		return ranking;
	}

	public void setRanking(Ranking<Integer> ranking) {
		this.ranking = ranking;
	}

	@Override
	public JSONObject toJSONObject() {
		JSONObject obj = super.toJSONObject();
		obj.put("ranking", ranking.toJSONObject());
		return obj;
	}

	@Override
	public String toDATFormat() {
		return super.toDATFormat() + 
			   this.dataFundacao + "|" +
			   this.capitalGiro + "|" + 
			   this.ranking.toDATFormat();
	}

	@Override
	public void setDAT(String DAT) {
		super.setDAT(DAT);
		// NOT IMPLEMENTED YET
	}
}
