package model;

public interface IUsuario extends TISModel  {	
	public void setUserData(IUsuario user);
	public String getEmail();
	public String getNome();
	public String getSenha();
	public void setSenha(String senha);
}
