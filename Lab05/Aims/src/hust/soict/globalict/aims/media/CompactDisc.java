package hust.soict.globalict.aims.media;
import java.util.Scanner;

import hust.soict.globalict.aims.exception.PlayerException;

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
	public CompactDisc(String title, String category, float cost, int length, String director, String artist) {
		// TODO Auto-generated constructor stub
		 super(title, category, cost);
	     this.artist = artist;
	}
	public boolean checkTrack(Track track) {
		return tracks.contains(track);
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

	
	public void play() throws PlayerException{ 
		if(this.getLength() > 0) { 
		// TODO Play all tracks in the CD as you have implemented 
			java.util.Iterator iter = tracks.iterator(); 
			Track nextTrack; 
			while(iter.hasNext()) { 
				nextTrack = (Track) iter.next(); 
				try { 
					nextTrack.play(); 
				}catch(PlayerException e) { 
					throw e; 
				} 
			} 
		}else { 
		throw new PlayerException("ERROR: CD length is non-positive!"); 
		} 
		}
	
}
