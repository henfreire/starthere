package util;

import java.util.List;

public interface FileHandler<E> {	
	public void saveToFile(E fileContent);
	public void saveToFile(List<E> fileContent);
	public List<String> getFileContents();		
}
