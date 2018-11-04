package DAO;

public interface UsuarioDAO<E, K> extends CRUD<E, K> {
	public E getByEmail(String nome);
}
