package sait.bms.problemdomain;

public class Book {

		private String isbn = "";
		private String callNumber = "";
		private int available = -1;
		private int total = -1;
		private String title = "";
		
	public Book() {
			
		}
	public Book(String isbn, String callNumber, int available, int total, String title) {
		this.isbn = isbn;
		this.callNumber = callNumber;
		this.available = available;
		this.total = total;
		this.title = title;
		}
	public String getIsbn() {
		return isbn;
		}
	public String getCallNumber() {
		return callNumber;
	}
	public int getAvailable() {
		return available;
	}
	public int getTotal() {
		return total;
	}
	public String getTitle() {
		return title;
	}
	public void takeBook() {
		if(this.getAvailable() > 0) {
			this.available = available -1;
		}
		else {
			System.out.println("No Books Available.");
		}
	}
	//outputs atttributes in string format readable by program
	public String printToSave() {
		return getIsbn() + ";" + getCallNumber() + ";" + getAvailable() + ";" + getTotal() + ";" + getTitle()
				+ ";";
		
	}
	
	
	public String toString() {
		return "ISBN: " + getIsbn() + "\nCall number: " + getCallNumber() + "\nTotal: " + getTotal() + "\nAvailable: "
		+ getAvailable() + "\nTitle: " + getTitle();
	}
}

