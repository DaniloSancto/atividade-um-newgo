package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

import enums.DocumentType;

public class Member {

	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private Long cardNumber;
	private String name;
	private Date date;
	private Document<DocumentType, Long> document;

	public Member() {
	}

	public Member(Long cardNumber, String name, Date date, Document<DocumentType, Long> document) {
		this.cardNumber = cardNumber;
		this.name = name;
		this.date = date;
		this.document = document;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(Long cardNumber) {
		this.cardNumber = cardNumber;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Document<DocumentType, Long> getDocument() {
		return document;
	}

	public void setDocument(Document<DocumentType, Long> document) {
		this.document = document;
	}

	@Override
	public String toString() {
		return cardNumber + "," + name + "," + sdf.format(date) + "," + document;
	}

}
