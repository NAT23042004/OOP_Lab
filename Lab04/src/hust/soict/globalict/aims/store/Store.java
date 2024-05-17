package hust.soict.globalict.aims.store;

import java.util.ArrayList;

import hust.soict.globalict.aims.media.*;
public class Store {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private ArrayList<Media> itemsInStore =
			new ArrayList<Media>();
	public void addMedia(Media media) {
		if(itemsInStore.size() >= MAX_NUMBERS_ORDERED) {
			System.out.println("The Store is already full.");
		}
		else {
			for(Media t : itemsInStore) {
				if(t.equals(media)) {
					System.out.println("The media is already in the Store.");
					return;
				}
			}
			itemsInStore.add(media);
			System.out.println("The media is already in the Store.");
		}
	}
	public void removeMedia(Media media) {
		if(itemsInStore.size() < 1) {
			System.out.println("There isn't any media in the Store.");
		}
		else {
			for(Media t : itemsInStore) {
				if(t.equals(media)) {
					itemsInStore.remove(media);
					System.out.println("Remove the media successfully.");
					return;
				}
			}
			System.out.println("Can not remove. The media is not in the Store.");
		}
	}
	public double totalCost() {
		double cost = 0;
		for(Media media : itemsInStore) {
			cost += (double)media.getCost();
	    }
		return cost;
	}
	
	public void printCart() {
        System.out.println("******************************Cart Display******************************");
        int index = 1;
        for (Media media : itemsInStore) {
            System.out.printf("%d. %s\n", index, itemsInStore.toString());
            index++;
        }
        System.out.printf("Total Cost: %-5.2f\n", totalCost());
        System.out.printf("************************************************************************\n");
    }
	public Media searchByID(int i) {
		if(i < itemsInStore.size()) {
			int index = 0;
			for(Media media : itemsInStore) {
			index++;
			if(index == i) {
            return media;
		    }
		 }
	  }
		return null;
	}
	public Media searchByTitle(String title) {
		for(Media media : itemsInStore) {
			if(media.getTitle().equals(title)) {			
			return media;
		}
	  }
	return null;
	}
	public ArrayList<Media> getItemsInStore() {
		return itemsInStore;
	}
	
}
