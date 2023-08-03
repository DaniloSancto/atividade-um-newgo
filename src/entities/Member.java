package entities;

import java.util.Date;

import enums.DocumentType;

public class Member {

	private Long number;
	private String name;
	private Date date;
	private Document<DocumentType, Long> document;

	public Member() {
	}

	public Member(Long number, String name, Date date, Document<DocumentType, Long> document) {
		this.number = number;
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

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
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
		return "n° Carteirinha: " + number + "\nNome: " + name + "\nData: " + date + "\nDocumento: " + document;
	}

}
