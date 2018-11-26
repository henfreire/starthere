package DAO;

public interface UsuarioDAO<E> extends CRUD<E, Long> {
	public E getByEmail(String nome);
}
