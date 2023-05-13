package sait.bms.problemdomain;

public class CookBook extends Book{

	 String publisher = "";
	String diet = "";
	public CookBook(){
		
	}
	public CookBook (String isbn, String callNumber, int available, int total, String title, String publisher, String diet) {
	super(isbn, callNumber, available, total, title);
	this.publisher = publisher;
	this.diet = diet;
	}

	public String getPublisher() {
	return publisher;
	}
	public String getDiet() {
		return diet;
	}

	public String size() {
	return diet;
	}
	public String printToSave() {
		return super.printToSave() + getPublisher() + ";" + getDiet() + ";";
		
	}

	@Override
	public String toString() {
	return super.toString() + "\nPublisher " +
	getPublisher() + "\nDiet" + getDiet();
	}
}