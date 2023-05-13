package sait.bms.problemdomain;

public class Periodicals extends Book{
	private	String frequency = "";
	
	public Periodicals() {
		
	}
	public Periodicals(String isbn, String callNumber, int available, int total, String title, String frequency) {
		super(isbn, callNumber, available, total, title);
		this.frequency = frequency;
	}
	public String getFrequency() {
		return frequency;
	}
	public String printToSave() {
		return super.printToSave() + getFrequency() + ";";
		
	}
	
	@Override
	public String toString() {
		return super.toString() + "\nFrequency: " + getFrequency();
	}
}
