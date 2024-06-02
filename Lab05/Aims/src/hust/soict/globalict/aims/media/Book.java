package hust.soict.globalict.aims.media;
import java.lang.Object;
import java.util.*;
public class Book extends Media{
	private List<String> authors = new ArrayList<String>();
	public Book() {
		
	}
	public Book(String title, String category, float cost, ArrayList<String> authors2) {
		super(title, category, cost);
	}

	public List<String> getAuthors() {
		return authors;
	}

	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}
	
	public boolean checkAuthor(String authorName) {
		return authors.contains(authorName);
	}
	
	public void addAuthor(String authorName) {
		if(!checkAuthor(authorName)) {
			authors.add(authorName);
			System.out.printf("Adding %s to authors'list successfully.\n", authorName);
		}
		else {
			System.out.println("The author is already in the authors'list.");
		}
	}
	public void removeAuthor(String authorName) {
		if(checkAuthor(authorName)) {
			authors.remove(authorName);
			System.out.printf("Removing %s from authors'list successfully.\n", authorName);
		}
		else {
			System.out.println("Can not remove. The authorName is not in the authors'list.");
		}
	}
	
}
