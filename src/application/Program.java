package application;

import java.io.File;
import java.util.Date;
import java.util.Scanner;

import entities.Club;
import entities.Document;
import entities.Member;
import enums.DocumentType;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String path = "C:\\Dados dos Sócios";
		
		Club club = new Club();

		boolean createFile = new File(path).mkdir();

		System.out.println(createFile ? "Pasta criada no caminho 'C:/Dados dos Sócios'"
				: "Pasta já existente no caminho 'C:/Dados dos Sócios'");

		boolean running = true;
		while (running) {
			System.out.println("\nSELECIONE ALGUMA OPÇÃO\n\n"
					+ "1- Cadastrar novos sócios\n"
					+ "2- Consultar por documento\n"
					+ "3- Consultar por nome\n"
					+ "4- Atualizar um registro por número de carteirinha\n"
					+ "5- Excluir registro por número de carteirinha\n"
					+ "6- Finalizar execução\n");
			
			switch(sc.nextInt()) {
			case 1:
				System.out.print("Digite o numero da carteirinha: ");
				Long number = sc.nextLong();
				System.out.print("Digite o nome do Sócio: ");
				sc.nextLine();
				String name = sc.nextLine();
				System.out.print("Digite o tipo de documento(RG/CPF): ");
				DocumentType docType = DocumentType.valueOf(sc.next().toUpperCase());
				System.out.print("Digite o numero do " + docType.name() + "(somente números): ");
				Long documentNumber = sc.nextLong();
				
				Document<DocumentType, Long> document = new Document<>(docType, documentNumber);
				Member member = new Member(number, name, new Date(), document);
				
				club.getMembers().add(member);
				
				System.out.println("\n" + club.getMembers());
				break;
				
			case 6:
				running = false;
				break;
			}
			
		}

		sc.close();
	}

}
