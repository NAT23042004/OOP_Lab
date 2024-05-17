package hust.soict.globalict.aims.media;

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
	public void play() {
		System.out.println("Playing Track: " + this.getTitle());
		System.out.println("DVD track: " + this.getLength());		
	}


}
