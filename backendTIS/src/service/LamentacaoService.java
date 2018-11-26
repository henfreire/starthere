package service;

import java.util.List;

public interface LamentacaoService<Lam> extends CRUDService<Lam, Long> {
	public List<Lam> getAll();
}
