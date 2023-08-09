package presentation;

import java.io.File;
import java.util.Scanner;

import data.util.ClearScreen;
import data.util.Routes;

public class HomePage {
	MemberPage memberPage = new MemberPage();

	public HomePage() {
		boolean createFolder = new File(Routes.FOLDER_PATH).mkdir();

		System.out.println(createFolder ? "Pasta criada no caminho 'C:/Dados dos Sócios'"
				: "Pasta já existente no caminho 'C:/Dados dos Sócios'");
	}

	public void screenWriter(Scanner scanner) {
		boolean running = true;

		while (running) {
			System.out.println("\nSELECIONE ALGUMA OPÇÃO\n\n" +
					"1- Sistema de cadastro de novos Sócios\n");

			switch (scanner.nextInt()) {
			case 1:
				ClearScreen.clear();
				memberPage.registerOfMembers(scanner);
				break;
			}
		}

	}

}
