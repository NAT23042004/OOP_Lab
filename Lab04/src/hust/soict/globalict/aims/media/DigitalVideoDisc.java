package hust.soict.globalict.aims.media;

public class DigitalVideoDisc extends Disc implements Playable{ 
 
	
	public DigitalVideoDisc(String title) {
		super();
		this.title = title;
	}
	public DigitalVideoDisc(String title, String category, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
	}
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.cost = cost;
	}
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.cost = cost;
		this.length = length;
	}
	public DigitalVideoDisc() {
		super();
	}
	
	public DigitalVideoDisc(String title, String category, String director, int length, double cost) {
		// TODO Auto-generated constructor stub
	}
	public String toString() {
		return "DVD - " + title + " - " + category + 
				(director != null ? " - " + director : " ") +
				(length > 0 ? " - " + length : " ") + ": $" + cost;
	}
	public boolean isMatch(String title) {
		return this.title.toLowerCase().equals(title.toLowerCase());
	}

	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}
	}
