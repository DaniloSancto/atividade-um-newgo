package data.document;

public class CPF implements Document {
	private String type;
	private String value;

	public CPF() {
	}

	public CPF(String value) {
		type = "CPF";
		this.value = value;
	}

	@Override
	public boolean verifyDocument() {
		return true;
	}

	@Override
	public String getType() {
		return type;
	}

	@Override
	public String getValue() {
		return value;
	}

	@Override
	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return type + "-" + value;
	}
}
