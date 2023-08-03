package entities;

import java.util.ArrayList;
import java.util.List;

import enums.DocumentType;

public class Club {

	private List<Member> members = new ArrayList<>();
	
	public Club() {
	}
	
	public List<Member> getMembers() {
		return members;
	}
	
	public void insertMember(Member member) {
		
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
	
}
