package domain;

import java.io.File;
import java.io.IOException;

import domain.util.Routes;

public class CreateFolderAndFiles {
	
	public boolean create() {
		boolean createFolder = new File(Routes.FOLDER_PATH).mkdir();
		System.out.println(createFolder ? "Pasta Criada no caminho:" + Routes.FOLDER_PATH
				: "Pasta existente no caminho:" + Routes.FOLDER_PATH);
		
		File file = new File(Routes.MEMBER_FILE_PATH);
		
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else {
			return false;
		}
		return true;
	}
	
}