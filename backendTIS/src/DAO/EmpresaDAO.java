package DAO;

import java.util.List;

public interface EmpresaDAO <E, K> {
	public List<E> getEmpresas();
	public K getNextId();
	public E getEmpresa(K id);
	public void addEmpresa(E empresa);
	public void updateEmpresa(E empresa);
	public void deleteEmpresa(E empresa);	
	
}
