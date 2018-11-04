package serviceImpl;

import DAOImpl.InvestidorDAOImpl;
import model.Investidor;

public class InvestidorServiceImpl extends UsuarioServiceImpl<Investidor> {
	public InvestidorServiceImpl() {
		super(new InvestidorDAOImpl());
	}

	@Override
	public Investidor buildNewUser(String nome, String email, String senha) {
		Investidor ivs = new Investidor(nome, email);
		ivs.setSenha(senha);
		return ivs;
	}
}
