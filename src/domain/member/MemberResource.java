package domain.member;

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

import data.Member;
import data.document.CPF;
import data.document.Document;
import data.document.RG;
import data.util.Routes;

public class MemberResource {
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

	private List<Member> members = new ArrayList<>();

	public boolean insertMember(Member member) {
		members.add(member);
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(Routes.MEMBER_FILE_PATH, true))) {
			writer.write(member + "\n");
			return true;
		} catch (IOException e) {
			System.out.println("Error writing file: " + e.getMessage());
		}
		return false;
	}

	public Member findByDocument(Document document) {
		for (Member entity : members) {
			if (entity.getDocument().getType().equals(document.getType())
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

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(Routes.MEMBER_FILE_PATH))) {

			for (Member entity : members) {
				writer.write(entity + "\n");
			}
		} catch (IOException e) {
			System.out.println("Error writing file: " + e.getMessage());
		}
	}

	public void deleteMemberByCardNumber(String cardNumber) {
		Member entity = new Member();
		for (Member member : members) {
			if (member.getCardNumber().equals(cardNumber)) {
				entity = member;
			}
		}
		System.out.println(entity);
		members.remove(entity);

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(Routes.MEMBER_FILE_PATH))) {

			for (Member member : members) {
				writer.write(member + "\n");
			}
		} catch (IOException e) {
			System.out.println("Error writing file: " + e.getMessage());
		}
	}

	public List<Member> getAllMembersFromDocument() {
		List<Member> list = new ArrayList<>();

		try (BufferedReader reader = new BufferedReader(new FileReader(Routes.MEMBER_FILE_PATH))) {
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
		Document document;
		if (fields[3].charAt(0) == 'R') {
			document = new RG(fields[3].substring(3));
		} else {
			document = new CPF(fields[3].substring(4));
		}

		return new Member(cardNumber, name, date, document);
	}

	public List<Member> getMembers() {
		return members;
	}
}
