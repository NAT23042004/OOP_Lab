package hust.soict.globalict.aims.media;

import java.awt.Desktop;
import java.net.URI;
import java.net.URLEncoder;

import hust.soict.globalict.aims.exception.PlayerException;

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

	public String toString() {
		return "DVD - " + title + " - " + category + 
				(director != null ? " - " + director : " ") +
				(length > 0 ? " - " + length : " ") + ": $" + cost;
	}
	public boolean isMatch(String title) {
		return this.title.toLowerCase().equals(title.toLowerCase());
	}

	public void play() throws PlayerException{
		if(this.getLength() > 0) {
			if(this.getLength() > 0) {
				 try {
	                 String mediatitle = this.getTitle();
	                 String url = "https://www.google.com/search?q=" + URLEncoder.encode(mediatitle, "UTF-8");
	                 Desktop.getDesktop().browse(new URI(url));
	             } catch (Exception e1) {
	                 e1.printStackTrace();
	             }
			}
		}else {
			throw new PlayerException("ERROR: DVD length is non-positive!");
		}
	}
	}
