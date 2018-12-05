package model;

import java.util.List;

public class Questionario implements IQuestionario<String> {
	private final String SUPER = "S";
	private final String EXCELENTE = "A";
	private final String BOM = "B";
	private final String REGULAR = "C";
	private final String RUIM = "D";
	
	private List<Integer> respostas;
	
	public Questionario(List<Integer> respostas) {
		this.respostas = respostas;
	}
	
	@Override
	public String getResultado() {
		Integer tot = this.respostas.stream()
					   				.mapToInt(i -> i).sum();
		
		return getNamedPosition(tot);
	}
	
	private String getNamedPosition(Integer pts) {
		if(pts >= 0 && pts < 5 ) {
			return RUIM;
		} else if(pts >= 5 && pts < 10 ) {
			return BOM;
		} else if(pts >= 10 && pts < 15 ) {
			return EXCELENTE;
		} else if(pts >= 20 && pts < 25 ) {
			return SUPER;
		} else {
			return REGULAR;
		}
		
	}
}
