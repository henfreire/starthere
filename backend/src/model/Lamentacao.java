package model;

public class Lamentacao {
	private String  nome,
				    descricao;
	private boolean status;
	private double  bonificacao;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public boolean isStatus() {
		return status;
	}
	
	public double getBonificacao() {
		return bonificacao;
	}
	
	public void setBonificacao(double bonificacao) {
		this.bonificacao = bonificacao;
	}
	
	public void finalizarLamentacao() {
		this.status = true;
	}
	
}
