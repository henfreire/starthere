package service;

import java.util.ArrayList;
import java.util.List;

import model.Investidor;
import model.Usuario;

public class InvestidorService implements UsuarioService {

	public static List<Investidor> investidores = new ArrayList<Investidor> ();
	
	public InvestidorService() {}
	
	@Override
	public void add(String nome, String email, String senha) {
		Investidor newEmp = new Investidor(nome, senha, email);
		InvestidorService.investidores.add(newEmp);
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Usuario buscar(String email) {
		for(int i = 0; i < InvestidorService.investidores.size() ; i++) {
			Usuario user = InvestidorService.investidores.get(i);
			if(email.equals(user.getEmail())) {
				return user;
			}
		}
		
		return null;
	}
	@Override
	public Usuario buscar(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
