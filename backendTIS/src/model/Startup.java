package model;

import java.util.Date;

import org.json.JSONObject;

public class Startup extends Usuario {
	private Date dataFundacao;
	private boolean isPremium;
	private double capitalGiro;
	private Ranking<Integer> ranking;
	
	public Startup() {}
	
	public Startup(Usuario user) {
		this.setUserData(user);
	}
	
	public Date getDataFundacao() {
		return dataFundacao;
	}

	public void setDataFundacao(Date dataFundacao) {
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

	public boolean isPremium() {
		return isPremium;
	}

	public void setPremium(boolean isPremium) {
		this.isPremium = isPremium;
	}
	
	// NOT IMPLEMENTED YET
	@Override
	public JSONObject toJSONObject() {
		JSONObject obj = super.toJSONObject();
		obj.put("ranking", ranking.toJSONObject());
		return obj;
	}

	// NOT IMPLEMENTED YET
	@Override
	public String toDATFormat() {
		return super.toDATFormat() + 
			   this.dataFundacao + "|" +
			   this.capitalGiro + "|" + 
			   this.ranking.toDATFormat();
	}

	// NOT IMPLEMENTED YET
	@Override
	public void setDAT(String DAT) {
		super.setDAT(DAT);
		// NOT IMPLEMENTED YET
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
