package service;

import java.util.ArrayList;
import java.util.List;

import model.StartUp;
import model.Usuario;

public class StartupService implements UsuarioService {

	public static List<StartUp> startups = new ArrayList<StartUp> ();
	
	public StartupService() {}
	
	@Override
	public void add(String nome, String email, String senha) {
		StartUp newEmp = new StartUp(nome, senha, email);
		StartupService.startups.add(newEmp);
	}

	@Override
	public void delete(long id) {
		
	}

	@Override
	public Usuario buscar(String email) {
		for(int i = 0; i < StartupService.startups.size() ; i++) {
			Usuario user = StartupService.startups.get(i);
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
