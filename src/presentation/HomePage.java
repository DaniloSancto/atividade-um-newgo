package presentation;

import java.util.Scanner;

import presentation.util.ClearScreen;

public class HomePage {

	public HomePage() {
		
	}

	public void screenWriter(Scanner scanner) {
		boolean running = true;

		while (running) {
			System.out.println("\nSELECIONE ALGUMA OPÇÃO\n\n" + "1- Sistema de cadastro de novos Sócios\n");

			switch (scanner.nextInt()) {
			case 1:
				ClearScreen.clear();
				//memberPage.registerOfMembers(scanner);
				break;
			}
		}

	}

}
