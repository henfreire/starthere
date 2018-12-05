package model;

import org.json.JSONObject;

public class Startup extends AbstractUsuario  {
	private String dataFundacao;
	private double capitalGiro;
	private Integer ranking;

	public Startup() {
		super();
	}
	
	public Startup(IUsuario user) {
		super(user);
	}
	
	public String getDataFundacao() {
		return dataFundacao;
	}

	public void setDataFundacao(String dataFundacao) {
		this.dataFundacao = dataFundacao;
	}

	public double getCapitalGiro() {
		return capitalGiro;
	}

	public void setCapitalGiro(double capitalGiro) {
		this.capitalGiro = capitalGiro;
	}

	public Integer getRanking() {
		return ranking;
	}

	public void setRanking(Integer ranking) {
		this.ranking = ranking;
	}

	@Override
	public JSONObject toJSONObject() {
		JSONObject obj = super.toJSONObject();
		
		obj.put("ranking", ranking);
		obj.put("capitalGiro", capitalGiro);
		obj.put("dataFundacao", dataFundacao);
		
		return obj;
	}

	@Override
	public String toDATFormat() {
		return super.toDATFormat() + 
			   this.dataFundacao + "|" +
			   this.capitalGiro + "|" + 
			   this.ranking + "|" ;
	}

	@Override
	public void setDAT(String DAT) {
		super.setDAT(DAT);
		String[] vet = DAT.split("\\|");
		
		this.dataFundacao = vet[7];
		this.capitalGiro = Double.parseDouble(vet[8]);
		this.ranking = Integer.parseInt(vet[9]);
	}
}
