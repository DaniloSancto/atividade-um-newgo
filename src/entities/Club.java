package entities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import enums.DocumentType;

public class Club {
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

	private List<Member> members = new ArrayList<>();

	public static final String FOLDER_PATH = "C:\\Dados dos Sócios";
	public static final String FILE_PATH = FOLDER_PATH + "\\registro de sócios.txt";

	public Club() {
	}

	public void insertMember(Member member) {
		members.add(member);
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
			writer.write(member + "\n");
		} catch (IOException e) {
			System.out.println("Error writing file: " + e.getMessage());
		}
	}

	public Member findByDocument(Document<DocumentType, String> document) {
		for (Member entity : members) {
			if (entity.getDocument().getKey().equals(document.getKey())
					&& entity.getDocument().getValue().equals(document.getValue())) {
				return entity;
			}
		}
		return null;
	}

	public Member findByName(String name) {
		for (Member entity : members) {
			if (entity.getName().equalsIgnoreCase(name)) {
				return entity;
			}
		}
		return null;
	}

	public void updateMemberByCardNumber(String cardNumber, Member member) {
		int count = 0;
		for (Member entity : members) {
			if (entity.getCardNumber().equals(cardNumber)) {
				members.set(count, member);
			}
			count++;
		}

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {

			for (Member entity : members) {
				writer.write(entity + "\n");
			}
		} catch (IOException e) {
			System.out.println("Error writing file: " + e.getMessage());
		}
	}

	public void deleteMemberByCardNumber(String cardNumber) {
		
	}

	public List<Member> getMembers() {
		return members;
	}

	public List<Member> getAllMembersFromDocument() {
		List<Member> list = new ArrayList<>();

		try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
			String line = reader.readLine();

			while (line != null) {
				String[] fields = line.split(",");

				list.add(getMemberFromStringSplit(fields));

				line = reader.readLine();
			}

			reader.close();
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
		return list;
	}

	private Member getMemberFromStringSplit(String[] fields) throws ParseException {
		String cardNumber = fields[0];
		String name = fields[1];
		Date date = dateFormat.parse(fields[2]);
		DocumentType docType;
		String documentValue;

		if (fields[3].charAt(0) == 'R') {
			docType = DocumentType.RG;
			documentValue = fields[3].substring(3);
		} else {
			docType = DocumentType.CPF;
			documentValue = fields[3].substring(4);
		}

		return new Member(cardNumber, name, date, new Document<DocumentType, String>(docType, documentValue));
	}

}
