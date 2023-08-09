package data.document;

public class RG implements Document {
	private String type;
	private String value;

	public RG() {
	}

	public RG(String value) {
		type = "RG";
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
