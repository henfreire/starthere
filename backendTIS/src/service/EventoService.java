package service;

import java.util.ArrayList;
import java.util.List;

import model.Empresa;
import model.Evento;

public class EventoService {
	public static List<Evento> eventos = new ArrayList<Evento> ();
	
	public EventoService() {}	
	
	public void add(String nome, String email, String senha, long idEmpresa) {
		Empresa emp = new EmpresaService().getEmpresaById(idEmpresa);
		Evento evt = new Evento(nome, emp);
		
	}

}
