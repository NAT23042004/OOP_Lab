package hust.soict.globalict.aims.media;
import java.util.Scanner;
import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable{

	Scanner myInput = new Scanner(System.in);
	private String artist;
	private ArrayList<Track> tracks = new ArrayList <Track>();
	
	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public CompactDisc() {
		super();
	}
	public CompactDisc(String title, String category, float cost, int length, String director, String artist2) {
		// TODO Auto-generated constructor stub
	}
	public boolean checkTrack(Track track) {
		for(Track i : tracks) {
		if(i.getTitle().equals(track.getTitle())) {
			return true;
		}
	    }
		return false;
	}
	
	public void addTrack(Track track) {
		if(!checkTrack(track)) {
			tracks.add(track);
			System.out.printf("Adding %s to authors'list successfully.\n", track.getTitle());
		}
		else {
			System.out.println("The author is already in the tracks'list.");
		}
	}
	public void removeTrack(Track track) {	
		if(checkTrack(track)) {
			tracks.remove(track);
			System.out.printf("Removing %s from tracks'list successfully.\n", track.getTitle());
		}
		else {
			System.out.println("Can not remove. The input track is not in the tracks' list.");
		}
	}
	public int getLength() {
		int totallength = 0;
		for(Track i : tracks) {
			totallength += i.getLength();
		}
		return totallength;
	}

	
	public void play() {
		for(Track t : tracks) {
			t.play();
		}
	}
	
}
