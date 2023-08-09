package presentation;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

import com.google.gson.Gson;

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
	
	Gson gson = new Gson();
	
	public MemberPage() {
		File file = new File(Routes.MEMBER_FILE_PATH);
		
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else {
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
				Document document = getDocumentFromScanner(scanner);
				if (document == null) {
					ClearScreen.clear();
					System.out.println("*ERRO: Documento inválido*");
					break;
				}
				Member member = new Member(generateCardNumber.generate(), name, new Date(), document);
				ClearScreen.clear();
				memberResource.insertMember(member);
				break;
				
			case 2:
				document = getDocumentFromScanner(scanner);
				if (document == null) {
					ClearScreen.clear();
					System.out.println("*ERRO: Documento inválido*");
					break;
				}
				ClearScreen.clear();
				if(memberResource.findByDocument(document) != null) {
					System.out.println(memberResource.findByDocument(document));
				}
				else {
					System.out.println("*ERRO: Sócio não encontrado*");
				}
				break;

			case 3:
				System.out.print("Digite o nome do Sócio: ");
				scanner.nextLine();
				name = scanner.nextLine();
				
				ClearScreen.clear();
				if(memberResource.findByName(name) != null) {
					System.out.println(memberResource.findByName(name));
				}
				else {
					System.out.println("*ERRO: Sócio não encontrado*");
				}
				break;

			case 4:
				System.out.print("Digite o numero da carteirinha: ");
				String cardNumber = scanner.next().toUpperCase();
				System.out.print("Digite o novo nome do Sócio: ");
				scanner.nextLine();
				name = scanner.nextLine();
				document = getDocumentFromScanner(scanner);
				if (document == null) {
					ClearScreen.clear();
					System.out.println("*ERRO: Documento inválido*");
					break;
				}
				Member updatedMember = new Member(cardNumber, name, new Date(), document);
				ClearScreen.clear();
				if(memberResource.updateMemberByCardNumber(cardNumber, updatedMember)) {
					System.out.println("Sócio:" + updatedMember.getName() + " atualizado com sucesso!");
				}
				else {
					System.out.println("*ERRO: Sócio não encontrado*");
				}
				break;

			case 5:
				System.out.print("Digite o numero da carteirinha: ");
				cardNumber = scanner.next().toUpperCase();
				ClearScreen.clear();
				if(memberResource.deleteMemberByCardNumber(cardNumber))	{
					System.out.println("Sócio: excluído com sucesso!");
				}
				else {
					System.out.println("*ERRO: Sócio não encontrado*");
				}
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
	
	private Document getDocumentFromScanner(Scanner scanner) {
		System.out.print("Digite o tipo de documento(RG/CPF): ");
		String documentType = scanner.next().toUpperCase();
		System.out.print("Digite o numero do " + documentType + "(somente números): ");
		String documentValue = scanner.next();
		Document document;
		if (documentType.equals("RG")) {
			document = new RG(documentValue);
		}
		else if(documentType.equals("CPF")) {
			document = new CPF(documentValue);
		}
		else {
			return null;
		}
		return document;
	}
}
