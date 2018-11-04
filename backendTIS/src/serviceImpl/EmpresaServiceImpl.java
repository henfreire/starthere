package serviceImpl;

import DAOImpl.EmpresaDAOImpl;
import model.Empresa;

public class EmpresaServiceImpl extends UsuarioServiceImpl<Empresa> {
	public EmpresaServiceImpl() {
		super( new EmpresaDAOImpl() );
	}

	@Override
	public Empresa buildNewUser(String nome, String email, String senha) {
		Empresa empresa = new Empresa (nome, email);
		empresa.setSenha(senha);
		return empresa;
	}
}
