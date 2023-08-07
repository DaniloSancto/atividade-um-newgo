package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

import enums.DocumentType;

public class Member {

	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	private String cardNumber;
	private String name;
	private Date date;
	private Document<DocumentType, String> document;

	public Member() {
	}

	public Member(String cardNumber, String name, Date date, Document<DocumentType, String> document) {
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

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Document<DocumentType, String> getDocument() {
		return document;
	}

	public void setDocument(Document<DocumentType, String> document) {
		this.document = document;
	}

	@Override
	public String toString() {
		return cardNumber + "," + name + "," + dateFormat.format(date) + "," + document;
	}

}
