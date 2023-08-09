package presentation;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

import data.Member;
import data.document.CPF;
import data.document.Document;
import data.document.RG;
import data.util.ClearScreen;
import data.util.GenerateMemberCardNumber;
import data.util.Routes;
import domain.member.MemberResource;

public class MemberPage {
	GenerateMemberCardNumber generateCardNumber = new GenerateMemberCardNumber();
	MemberResource memberResource = new MemberResource();
	
	public MemberPage() {
		File file = new File(Routes.MEMBER_FILE_PATH);
		
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			memberResource.getMembers().addAll(memberResource.getAllMembersFromDocument());
		}
	}
	
	public void registerOfMembers(Scanner scanner) {
		boolean running = true;
		while (running) {
			System.out.println(memberResource.getMembers());
			System.out.println("\nSELECIONE ALGUMA OPÇÃO\n\n" +
					"1- Cadastrar novos sócios\n" +
					"2- Consultar por documento\n" +
					"3- Consultar por nome\n" +
					"4- Atualizar um registro por número de carteirinha\n" +
					"5- Excluir registro por número de carteirinha\n" +
					"6- Voltar para página inicial\n");

			switch (scanner.nextInt()) {
			case 1:
				System.out.print("Digite o nome do Sócio: ");
				scanner.nextLine();
				String name = scanner.nextLine();
				System.out.print("Digite o tipo de documento(RG/CPF): ");
				String documentType = scanner.next().toUpperCase();
				System.out.print("Digite o numero do " + documentType + "(somente números): ");
				String documentValue = scanner.next();
				Document document;
				System.out.println(documentType);
				System.out.println(documentValue);
				if (documentType.equals("RG")) {
					document = new RG(documentValue);
				}
				else if(documentType.equals("CPF")) {
					document = new CPF(documentValue);
				}
				else {
					System.out.println("*ERRO: Documento inválido*");
					break;
				}

				Member member = new Member(generateCardNumber.generate(), name, new Date(), document);
				memberResource.insertMember(member);
				ClearScreen.clear();
				break;

			case 2:
				System.out.print("Digite o tipo de documento(RG/CPF): ");
				documentType = scanner.next().toUpperCase();
				System.out.print("Digite o numero do " + documentType + "(somente números): ");
				documentValue = scanner.next();
				if (documentType.equals("RG")) {
					document = new RG(documentValue);
				}
				else if(documentType.equals("CPF")) {
					document = new CPF(documentValue);
				}
				else {
					System.out.println("*ERRO: Documento inválido*");
					break;
				}

				ClearScreen.clear();
				System.out.println(memberResource.findByDocument(document));
				break;

			case 3:
				System.out.print("Digite o nome do Sócio: ");
				scanner.nextLine();
				name = scanner.nextLine();
				
				ClearScreen.clear();
				System.out.println(memberResource.findByName(name));
				break;

			case 4:
				System.out.print("Digite o numero da carteirinha: ");
				String cardNumber = scanner.next().toUpperCase();
				System.out.print("Digite o novo nome do Sócio: ");
				scanner.nextLine();
				name = scanner.nextLine();
				System.out.print("Digite o tipo de documento(RG/CPF): ");
				documentType = scanner.next().toUpperCase();
				System.out.print("Digite o numero do " + documentType + "(somente números): ");
				documentValue = scanner.next();
				if (documentType.equals("RG")) {
					document = new RG(documentValue);
				}
				else if(documentType.equals("CPF")) {
					document = new CPF(documentValue);
				}
				else {
					System.out.println("*ERRO: Documento inválido*");
					break;
				}

				Member updatedMember = new Member(cardNumber, name, new Date(), document);
				memberResource.updateMemberByCardNumber(cardNumber, updatedMember);

				ClearScreen.clear();
				break;

			case 5:
				System.out.print("Digite o numero da carteirinha: ");
				cardNumber = scanner.next().toUpperCase();
				memberResource.deleteMemberByCardNumber(cardNumber);

				ClearScreen.clear();
				break;

			case 6:
				ClearScreen.clear();
				running = false;
				break;

			default:
				ClearScreen.clear();
				System.out.println("*Valor inválido*");
				break;
			}
		}
	}
}
