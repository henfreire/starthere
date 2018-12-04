package DAOTest;

import org.junit.BeforeClass;
import org.junit.Test;

import DAO.EmpresaDAO;
import DAOImpl.EmpresaDAOImpl;
import model.Empresa;

public class EmpresaDAOTest {
	private static EmpresaDAO<Empresa, Long> empDAO;
	private static Empresa emp;
	
	@BeforeClass
    public static void runOnceBeforeClass() {
		empDAO = new EmpresaDAOImpl();
		
		String  nome = "Exemplo SA",
				email = "exemplo@teste.com",
				senha="123";
		emp = new Empresa();
		emp.setSenha(senha);
		emp.setId(Long.parseLong("13"));
    }

	@Test
	public void addTest() {
		empDAO.add(emp);
	}

	@Test
	public void updateTest() {
		emp.setEmail("exemplo2@teste.com");
		empDAO.update(emp);
	}
	
	@Test
	public void removeTest() {
		empDAO.delete(emp);
	}	

	@Test
	public void getTest() {
		empDAO.get(emp.getId());
	}	
}
