package sait.bms.problemdomain;

public class PaperBacks extends Book{
		String author = "";
		String yearOfRelease = "";
		String genre = "";
	public PaperBacks() {
}
	public PaperBacks(String isbn, String callNumber, int available, int total, String title, String author, String yearOfRelease, String genre) {
		super(isbn, callNumber, available, total, title);
		this.author = author;
		this.yearOfRelease = yearOfRelease;
		this.genre = genre;
}
	public String getAuthor() {
		return author;
}

	public String getYearOfRelease() {
		return yearOfRelease;
}

	public String getGenre() {
		return genre;
}
	public String printToSave() {
		return super.printToSave() + getAuthor() + ";" + getYearOfRelease() + ";" + getGenre() + ";";
		
	}


	@Override
	public String toString() {
		return super.toString() + "\nAuthor(s): " +
				getAuthor() + "\nYear of Release: " + getYearOfRelease() + "\nGenre: " + getGenre();
}
}