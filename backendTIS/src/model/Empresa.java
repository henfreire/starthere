package model;

public class Empresa extends Usuario {

	public Empresa(Long id) {
		super(id);
	}
	
	public Empresa(Long id, String nome, String senha, String email) {
		super(id, nome, senha, email);
	}

	@Override
	public String toString() {
		return super.toString();
	}
}
