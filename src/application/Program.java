package application;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

import entities.Club;
import entities.Document;
import entities.Member;
import enums.DocumentType;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);


		Club club = new Club();

		boolean createFolder = new File(Club.FOLDER_PATH).mkdir();
		File file = new File(Club.FILE_PATH);
		
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			club.getMembers().addAll(club.getAllMembersFromDocument());
		}

		System.out.println(createFolder ? "Pasta criada no caminho 'C:/Dados dos Sócios'"
				: "Pasta já existente no caminho 'C:/Dados dos Sócios'");

		
		boolean running = true;
		while (running) {
			System.out.println("\n" + club.getMembers());
			System.out.println("\nSELECIONE ALGUMA OPÇÃO\n\n"
					+ "1- Cadastrar novos sócios\n"
					+ "2- Consultar por documento\n"
					+ "3- Consultar por nome\n"
					+ "4- Atualizar um registro por número de carteirinha\n"
					+ "5- Excluir registro por número de carteirinha\n"
					+ "6- Finalizar execução\n");

			switch (sc.nextInt()) {
			case 1:
				System.out.print("Digite o numero da carteirinha: ");
				String cardNumber = sc.next();
				System.out.print("Digite o nome do Sócio: ");
				sc.nextLine();
				String name = sc.nextLine();
				System.out.print("Digite o tipo de documento(RG/CPF): ");
				DocumentType docType = DocumentType.valueOf(sc.next().toUpperCase());
				System.out.print("Digite o numero do " + docType.name() + "(somente números): ");
				String docValue = sc.next();
				
				Member member = new Member(cardNumber, name, new Date(), new Document<>(docType, docValue));

				club.insertMember(member);
				System.out.println("\n" + member);
				break;
				
			case 2:
				System.out.print("Digite o tipo de documento(RG/CPF): ");
				docType = DocumentType.valueOf(sc.next().toUpperCase());
				System.out.print("Digite o numero do " + docType.name() + "(somente números): ");
				docValue = sc.next();
				System.out.println(club.findByDocument(new Document<DocumentType, String>(docType, docValue)));
				break;
				
			case 3:
				System.out.print("Digite o nome do Sócio: ");
				sc.nextLine();
				name = sc.nextLine();
				System.out.println(club.findByName(name));
				break;
				
			case 4:
				System.out.print("Digite o numero da carteirinha: ");
				cardNumber = sc.next();
				System.out.print("Digite o novo nome do Sócio: ");
				sc.nextLine();
				name = sc.nextLine();
				System.out.print("Digite o tipo de documento(RG/CPF): ");
				docType = DocumentType.valueOf(sc.next().toUpperCase());
				System.out.print("Digite o numero do " + docType.name() + "(somente números): ");
				docValue = sc.next();
				
				Member updatedMember = new Member(cardNumber, name, new Date(), new Document<>(docType, docValue));
				
				club.updateMemberByCardNumber(cardNumber, updatedMember);
				
				break;
				
			case 5:
				running = false;
				break;

			case 6:
				running = false;
				break;
				
			default:
				System.out.println("*Valor inválido*");
				break;
			}

		}

		sc.close();
	}

}
