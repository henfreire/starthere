package controller;

import service.EmpresaService;

import java.util.List;

import javax.swing.JOptionPane;

import model.Empresa;

public class EmpresaController implements UsuarioController {
	private EmpresaService empService;
	
	public EmpresaController() {
		this.empService = new EmpresaService ();
	}
	
	public void add(String nome, String senha, String email) throws Exception {
		JOptionPane.showMessageDialog(null, nome);
		this.empService.add(nome, senha, email);
	}
	
	public List<Empresa> getAll() {
		String s = null;
		
		for(int i = 0; i < this.empService.getAll().size() ; i++ ) {
			s += this.empService.getAll().get(i);
		}
		
		JOptionPane.showMessageDialog(null, s);
		return this.empService.getAll();
	}
	
}
