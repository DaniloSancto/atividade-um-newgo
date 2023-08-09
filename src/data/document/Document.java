package data.document;

public interface Document {
	
	boolean verifyDocument();

	String getType();

	String getValue();

	void setValue(String value);
}
