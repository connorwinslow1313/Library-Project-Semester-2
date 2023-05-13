package sait.bms.problemdomain;

import java.io.*;
import java.util.*;

public class BookDriver {

	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner (new File ("res/books.txt"));
		ArrayList <String> bookList = new ArrayList <String>();
		while (input.hasNext()) {
		bookList.add(input.nextLine());
		}
		ArrayList <Book> library = new ArrayList <Book>(splitBook(bookList));
		BookDriver bt = new BookDriver();
		bt.printMenu(library);			
}
	//code for random books
	public void randomList(ArrayList<Book> library, int numOfBooks) {
		Set<Integer> myHashSet = new HashSet<>();
		while (myHashSet.size() < numOfBooks){
			myHashSet.add((int)(Math.random() * (library.size() - 1)));
			}
			for(int c = 0; c < numOfBooks;c++){
				System.out.println(library.get((int) myHashSet.toArray()[c]).toString());
				System.out.println();
			}	
		}
	//removes a book from available via isbn
	public void rentBook(String isbn, ArrayList<Book> library) {
		for (int i = 0; i < (library.size() - 1); i++) {
			if(library.get(i).getIsbn().equals(isbn)) {
				System.out.println("The book: " + library.get(i).getTitle() + " has been checked out.");
				System.out.println("It can be located using a call number: 	" + library.get(i).getCallNumber());
				library.get(i).takeBook();
			}
		}
	}
	//takes input string and searches titles for match
	public void searchTitle(ArrayList<Book> library, String search) {
		System.out.println("Matching books: ");
		System.out.println();
		for (int i = 0; i < (library.size() - 1); i++){
			String temp = library.get(i).getTitle();
			temp = temp.toLowerCase();
			if(temp.contains(search.toLowerCase())) {
				System.out.println(library.get(i).toString());
				System.out.println();
			}
		}
	}
	
	//seperates lines into book objects and returns array list of objects
	public static ArrayList<Book> splitBook(ArrayList<String> books) {
		
		ArrayList<Book> library = new ArrayList<Book>();
		for(int c=0;c<books.size();c++) {
		String str[] = books.get(c).split(";");
		//childrens book
		if(str[0].substring(12,13).equals("0") ||  str[0].substring(12,13).equals("1")) {
				library.add(new ChildrensBooks(str[0],str[1],Integer.parseInt(str[2]),
							Integer.parseInt(str[3]),str[4],str[5],str[6]));
			}
		//cookbooks
		if(str[0].substring(12,13).equals("2") ||  str[0].substring(12,13).equals("3")) {
			library.add(new CookBook(str[0],str[1],Integer.parseInt(str[2]),
					Integer.parseInt(str[3]),str[4],str[5],str[6]));
		}
		//periodicals
		if(str.length==6) {
			library.add(new Periodicals(str[0],str[1],Integer.parseInt(str[2]),
					Integer.parseInt(str[3]),str[4],str[5]));
		}
		//paperbacks
		if(str.length==8) {
			library.add(new PaperBacks(str[0],str[1],Integer.parseInt(str[2]),
					Integer.parseInt(str[3]),str[4],str[5],str[6],str[7]));
		}
		
		}
		return library;
		}
	//writes information back into books.txt
	public static void saveToFile(ArrayList<Book> bookList) throws IOException{
		PrintWriter out= new PrintWriter ("res/books.txt");
		for(Book book : bookList) {
			out.println(book.printToSave());
			}
			out.close();
					   
		}
	//prints menu	
	public void printMenu(ArrayList<Book> library) throws IOException{
		Scanner in = new Scanner (System.in);
		int number = 0;
		while(number != 5) {
		System.out.println();
		System.out.println("Options");
		System.out.println("1. Checkout a Book");
		System.out.println("2. Find Books by Title");
		System.out.println("3. Display Books of a Specific Type");
		System.out.println("4. Produce a Random List of Books");
		System.out.println("5. Save & Exit");
		System.out.println();
		System.out.println("Enter Your Option (by Number): ");
		number = in.nextInt();
		if(number == 1) {
			System.out.println("Enter ISBN ");
			rentBook(in.next(),library);
		}
		else if (number == 2) {
			System.out.println("Enter title to seach for: ");
			String temp = in.next();
			searchTitle(library,temp);
		}
		//searches by book category
		else if (number == 3) {
			
			System.out.println("Enter a Book Type (1.Childrens Books, 2. Cook Books, 3 Paper Backs, 4. Periodicals ): ");
			int bookType = in.nextInt();
			if(bookType == 1) {
			System.out.println("Select a Format (1. Picture Books, 2. Early Readers, 3. Chapter Books): ");
			int bookFormat = in.nextInt();
			switch(bookFormat) {
			case 1:for (int i = 0; i < (library.size() - 1); i++) {
				if(library.get(i) instanceof ChildrensBooks) {
					  if(((ChildrensBooks)library.get(i)).getFormat().equals("P")) {
					    System.out.println(((ChildrensBooks)library.get(i)).toString());
					    System.out.println();
					  }
					}
			}
			break;
			case 2: for (int i = 0; i < (library.size() - 1); i++) {
				if(library.get(i) instanceof ChildrensBooks) {
					  if(((ChildrensBooks)library.get(i)).getFormat().equals("E")) {
					    System.out.println(((ChildrensBooks)library.get(i)).toString());
					    System.out.println();
					  }
					}
			}
			break;
			case 3: for (int i = 0; i < (library.size() - 1); i++) {
				if(library.get(i) instanceof ChildrensBooks) {
					  if(((ChildrensBooks)library.get(i)).getFormat().equals("C")) {
					    System.out.println(((ChildrensBooks)library.get(i)).toString());
					    System.out.println();
					  }
					}
			}
			}
			}
			
			else if (bookType == 2) {
			System.out.println("Select a Format (1. Diabetic, 2. Vegetarian, 3. Gluten-free, 4. International, 5. None ): ");
			int bookFormatC = in.nextInt();
			switch(bookFormatC) {
			case 1: for (int i = 0; i < (library.size() - 1); i++) {
				if(library.get(i) instanceof CookBook) {
					  if(((CookBook)library.get(i)).getDiet().equals("D")) {
					    System.out.println(((CookBook)library.get(i)).toString());
					    System.out.println();
					  }
					}
			}
			break;
			case 2: for (int i = 0; i < (library.size() - 1); i++) {
				if(library.get(i) instanceof CookBook) {
					  if(((CookBook)library.get(i)).getDiet().equals("V")) {
					    System.out.println(((CookBook)library.get(i)).toString());
					    System.out.println();
					  }
					}
			}
			break;
			case 3: for (int i = 0; i < (library.size() - 1); i++) {
				if(library.get(i) instanceof CookBook) {
					  if(((CookBook)library.get(i)).getDiet().equals("G")) {
					    System.out.println(((CookBook)library.get(i)).toString());
					    System.out.println();
					  }
					}
			}
			break;
			case 4:for (int i = 0; i < (library.size() - 1); i++) {
				if(library.get(i) instanceof CookBook) {
					  if(((CookBook)library.get(i)).getDiet().equals("I")) {
					    System.out.println(((CookBook)library.get(i)).toString());
					    System.out.println();
					  }
					}
			}
			break;
			case 5:for (int i = 0; i < (library.size() - 1); i++) {
				if(library.get(i) instanceof CookBook) {
					  if(((CookBook)library.get(i)).getDiet().equals("N")) {
					    System.out.println(((CookBook)library.get(i)).toString());
					    System.out.println();
					  }
					}
			}
			break;
			}
			}
			else if(bookType == 3) {
			System.out.println("Select a Format (1. Adventure, 2. Drama, 3. Education, 4. Classic, 5. Fantasy, 6. Science Fiction): ");
			int bookFormatP = in.nextInt();
			switch(bookFormatP) {
			case 1:for (int i = 0; i < (library.size() - 1); i++) {
				if(library.get(i) instanceof PaperBacks) {
					  if(((PaperBacks)library.get(i)).getGenre().equals("A")) {
					    System.out.println(((PaperBacks)library.get(i)).toString());
					    System.out.println();
					  }
					}
			}
			break;
			case 2:for (int i = 0; i < (library.size() - 1); i++) {
				if(library.get(i) instanceof PaperBacks) {
					  if(((PaperBacks)library.get(i)).getGenre().equals("D")) {
					    System.out.println(((PaperBacks)library.get(i)).toString());
					    System.out.println();
					  }
					}
			}
			break;
			case 3: for (int i = 0; i < (library.size() - 1); i++) {
				if(library.get(i) instanceof PaperBacks) {
					  if(((PaperBacks)library.get(i)).getGenre().equals("E")) {
					    System.out.println(((PaperBacks)library.get(i)).toString());
					    System.out.println();
					  }
					}
			}
			break;
			case 4: for (int i = 0; i < (library.size() - 1); i++) {
				if(library.get(i) instanceof PaperBacks) {
					  if(((PaperBacks)library.get(i)).getGenre().equals("C")) {
					    System.out.println(((PaperBacks)library.get(i)).toString());
					    System.out.println();
					  }
					}
			}
			break;
			case 5:for (int i = 0; i < (library.size() - 1); i++) {
				if(library.get(i) instanceof PaperBacks) {
					  if(((PaperBacks)library.get(i)).getGenre().equals("F")) {
					    System.out.println(((PaperBacks)library.get(i)).toString());
					    System.out.println();
					  }
					}
			}
			break;
			case 6:for (int i = 0; i < (library.size() - 1); i++) {
				if(library.get(i) instanceof PaperBacks) {
					  if(((PaperBacks)library.get(i)).getGenre().equals("S")) {
					    System.out.println(((PaperBacks)library.get(i)).toString());
					    System.out.println();
					  }
					}
			}
			break;
			}
			}
			else if(bookType == 4) {
			System.out.println("Select a Frequency (1. Daily, 2. Weekly, 3. Monthly, 4. Bimonthly, 5. Quartly): ");
			int bookFormatPr = in.nextInt();
			switch(bookFormatPr) {
			case 1: for (int i = 0; i < (library.size() - 1); i++) {
				if(library.get(i) instanceof Periodicals) {
					  if(((Periodicals)library.get(i)).getFrequency().equals("D")) {
					    System.out.println(((Periodicals)library.get(i)).toString());
					    System.out.println();
					  }
					}
			}
			break;
			case 2: for (int i = 0; i < (library.size() - 1); i++) {
				if(library.get(i) instanceof Periodicals) {
					  if(((Periodicals)library.get(i)).getFrequency().equals("W")) {
					    System.out.println(((Periodicals)library.get(i)).toString());
					    System.out.println();
					  }
					}
			}
			break;
			case 3:for (int i = 0; i < (library.size() - 1); i++) {
				if(library.get(i) instanceof Periodicals) {
					  if(((Periodicals)library.get(i)).getFrequency().equals("M")) {
					    System.out.println(((Periodicals)library.get(i)).toString());
					    System.out.println();
					  }
					}
			}
			break;
			case 4: for (int i = 0; i < (library.size() - 1); i++) {
				if(library.get(i) instanceof Periodicals) {
					  if(((Periodicals)library.get(i)).getFrequency().equals("B")) {
					    System.out.println(((Periodicals)library.get(i)).toString());
					    System.out.println();
					  }
					}
			}
			break;
			case 5: for (int i = 0; i < (library.size() - 1); i++) {
				if(library.get(i) instanceof Periodicals) {
					  if(((Periodicals)library.get(i)).getFrequency().equals("Q")) {
					    System.out.println(((Periodicals)library.get(i)).toString());
					    System.out.println();
					  }
					}
			}
			break;
			}
			}
			
		
		
		
		}
		else if (number == 4) {
			System.out.println("Enter how many random books: ");
			int numOfBooks = in.nextInt();
			randomList(library, numOfBooks);
		}
		else if (number == 5) {
			saveToFile(library);
			System.out.println("Saved!");
		}
}
}
}

