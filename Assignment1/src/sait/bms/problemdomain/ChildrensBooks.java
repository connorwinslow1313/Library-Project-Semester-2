package sait.bms.problemdomain;

public class ChildrensBooks extends Book {
	public String authors = "";
	public String format = "";
	
	public ChildrensBooks() {
		
	}
	public ChildrensBooks(String isbn, String callNumber, int available, int total, String title, String authors, String format) {
		super(isbn, callNumber, available, total, title);
		this.authors = authors;
		this.format = format;
	}
	public String getAuthors() {
		return authors;
	}
	public String getFormat() {
		return format;
	}
	
	public String printToSave() {
		return super.printToSave() + getAuthors() + ";" + getFormat() + ";";
		
	}
	
	@Override
	public String toString() {
		return super.toString() + "\nAuthors: " + getAuthors() + "\nFormat: " + getFormat();
	}
	
	
	
	
	
	
	
}
