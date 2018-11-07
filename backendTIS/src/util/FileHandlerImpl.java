package util;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import java.io.IOException;

import java.util.List;

import java.util.ArrayList;

public class FileHandlerImpl<E extends toDAT> implements FileHandler<E> {
	private static final String defaultFilePath = System.getProperty("user.dir") + "\\dist\\data\\";
	private String filePath;
		
	public FileHandlerImpl(String fileName) {
		filePath = FileHandlerImpl.defaultFilePath + fileName; 
	}

	@Override
	public void saveToFile(List<E> fileContents) {
		DataOutputStream saida;

		try {
			saida = new DataOutputStream(new FileOutputStream(filePath, true));
		
			for(toDAT data : fileContents) {
				saida.writeUTF(data.toDATFormat() + "\n");
				saida.flush();
			}
	
			saida.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void saveToFile(E fileContent) {
		DataOutputStream saida;
		
		try {
			saida = new DataOutputStream(new FileOutputStream(filePath, true));
			saida.writeUTF(fileContent.toDATFormat() + "\n");
			saida.flush();
			
			saida.close();
		} catch (FileNotFoundException | EOFException e ) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}		
	
	@Override
	public List<String> getFileContents() {
		List<String> result = new ArrayList<String> ();
		String str;
		
		try {
			DataInputStream entrada = new DataInputStream(new FileInputStream(filePath));
			
			while ((entrada.available() > 0) && (str = entrada.readUTF()) != null) {
				result.add(str);
			}
			
			entrada.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return result;
	}

}
