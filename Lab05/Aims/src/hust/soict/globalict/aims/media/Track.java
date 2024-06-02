package hust.soict.globalict.aims.media;

import hust.soict.globalict.aims.exception.PlayerException;

public class Track implements Playable{

	private String title;
	private int length;
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
	
	public Track() {
		super();
	}

	public boolean equals(Object obj) {
		Track t = (Track) obj; // Cast the obj parameter to the type Track
		return (this.title.equals(t.title) & (this.length == t.length));
	}
	public void play() throws PlayerException {
		if(this.getLength() > 0) {
			System.out.println("Playing Track: " + this.getTitle());
			System.out.println("Track length: " + this.getLength());
		}else {
			throw new PlayerException("ERROR: DVD length is non-positive!");
		}
	}


}
