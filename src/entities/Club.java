package entities;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import enums.DocumentType;

public class Club {

	private List<Member> members = new ArrayList<>();
	
	private static final String filePath = "C:\\Dados dos Sócios\\registro de sócios.csv";
	
	public Club() {
	}
	
	public void insertMember(Member member) {
		members.add(member);
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
			for(Member item : members) {
				bw.write(String.valueOf(item));
				bw.newLine();
			}
		}
		catch(IOException e) {
			System.out.println("Error writing file: " + e.getMessage());
		}
	}
	
	public Member findByDocument(Document<DocumentType, Long> document) {
		return new Member();
	}

	public Member findByName(String name) {
		return new Member();
	}
	
	public void updateMemberByCardNumber(Long cardNumber, Member member) {
		
	}
	
	public void deleteMemberByCardNumber(Long cardNumber) {
		
	}
	
	public List<Member> getMembers() {
		return members;
	}
	
}
