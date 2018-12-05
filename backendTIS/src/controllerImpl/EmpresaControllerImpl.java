package controllerImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONObject;

import controller.EmpresaController;
import serviceImpl.EmpresaServiceImpl;
import util.RNException;
import service.EmpresaService;
import service.EventoService;
import model.Empresa;
import model.Startup;
import model.Evento;

public class EmpresaControllerImpl extends UsuarioControllerImpl implements EmpresaController {	
	private final String BRAZILIAN_DATE_FORMAT = "DD/MM/YYYY";
	private EmpresaService<Empresa, Startup, Evento, Long> empresaService;
	private EventoService<Empresa, Evento, Long> evtService;
	
	public EmpresaControllerImpl () {
		this.empresaService = new EmpresaServiceImpl ();
	}
	
	@Override
	public JSONObject sendRoute(String route, JSONObject requestData) {
		JSONObject result = null;
		
		if(route.startsWith("/addEvento")) {
			result = this.addEvento(requestData);
		} else {
			return super.sendRoute(route, requestData);
		}
		
		return result;
	}
	

	@Override
	public JSONObject addEvento(JSONObject obj) {
		JSONObject result = new JSONObject ();
		
		String  nome,
				descricao,
				dataEventoStr;
		Long id;
		
		try {
			id = Long.parseLong(obj.getString("idEmpresa"));
			nome = obj.getString("nome");
			descricao = obj.getString("descricao");
			dataEventoStr = obj.getString("dataEvento");
			
	        Date dataEvento = this.getDate(dataEventoStr);
	        
			Evento evento = new Evento ();
			
			evento.setNome(nome);
			evento.setDataEvento(dataEvento);
			evento.setDescricao(descricao);
			
			Empresa emp = new Empresa ();
			emp.setId(id);
			
			this.evtService.add(evento, null);
			
			result.put("evento", evento.toJSONObject());
		} catch (RNException e) {
			e.printStackTrace();
			result.put("RNException", e.getMessage());
		} catch(ParseException e) {
			e.printStackTrace();
			result.put("ParseException", e.getMessage());
		}
		
		return result;
	}
	
	private Date getDate (String date) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat(BRAZILIAN_DATE_FORMAT);
        return formatter.parse(date);
	}
//
//	@Override
//	public JSONObject add(JSONObject obj) {
//		JSONObject result =  new JSONObject ();
//		String nome, email, senha;
//
//		email = obj.getString("email");
//		senha = obj.getString("senha");
//		nome = obj.getString("nome");
//		
//		Empresa emp = new Empresa();
//		
//		emp.setEmail(email);
//		emp.setSenha(senha);
//		emp.setNome(nome);
//
//		try {
//			this.empresaService.add(emp);
//			result.put("empresa", emp.toJSONObject());
//		} catch (RNException e) {
//			e.printStackTrace();
//			emp = null;
//			result.append("RNException", e.getMessage());
//		}
//		
//		return result;
//	}

	@Override
	public JSONObject update(JSONObject obj) {
		return null;
	}

	@Override
	public JSONObject delete(long id) {
		return null;
	}
}
