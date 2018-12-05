package DAO;

import java.util.List;

import DAOImpl.DAOException;

public interface CRUD<E, K> {
	public List<E> getAll() ;
	public E get(K id) ;
	public void add(E ele) throws DAOException ;
	public void update(E ele) ;
	public E delete(E ele) ;		
}
