package hust.soict.globalict.aims.cart;
import java.util.*;
import hust.soict.globalict.aims.media.*;
public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	public static final Comparator<Media> COMPARE_BY_TITLE_COST = 
			new MediaComparatorByTitleCost();
	public static final Comparator<Media> COMPARE_BY_CTITLE =
			new MediaComparatorByCostTitle();
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
	Scanner myInput = new Scanner(System.in);

	public int getSize() {
		return itemsOrdered.size();
	}
	public ArrayList<Media> getItemsOrdered() {
		return itemsOrdered;
	}
	
	
	public void addMedia(Media media) {
		if(itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
			System.out.println("The cart is already full.");
		}
		else {
			for(Media t : itemsOrdered) {
				if(t.equals(media)) {
					System.out.println("The media is already in the Cart.");
					return;
				}
			}
			itemsOrdered.add(media);
			System.out.println("The author is already in the tracks'list.");
		}
	}
	public void removeMedia(Media media) {
		if(itemsOrdered.size() < 1) {
			System.out.println("There isn't any media in the Cart.");
		}
		else {
			for(Media t : itemsOrdered) {
				if(t.equals(media)) {
					itemsOrdered.remove(media);
					System.out.println("Remove the media successfully.");
					return;
				}
			}
			System.out.println("Can not remove. The media is not in the Cart.");
		}
	}
	public double totalCost() {
		double cost = 0;
		for(Media media : itemsOrdered) {
			cost += (double)media.getCost();
	    }
		return cost;
	}
	
	public void printCart() {
        System.out.println("******************************Cart Display******************************");
        int index = 1;
        for (Media media : itemsOrdered) {
            System.out.printf("%d. %s\n", index, itemsOrdered.toString());
            index++;
        }
        System.out.printf("Total Cost: %-5.2f\n", totalCost());
        System.out.printf("************************************************************************\n");
    }
	public Media searchByID(int i) {
		if(i < itemsOrdered.size()) {
			int index = 0;
			for(Media media : itemsOrdered) {
			index++;
			if(index == i) {
            return media;
		    }
		 }
	  }
		return null;
	}
	public Media searchByTitle(String title) {
		for(Media media : itemsOrdered) {
			if(media.getTitle().equals(title)) {			
			return media;
		}
		}
		return null;
	}
	public void deleteAll() {
		itemsOrdered = new ArrayList<Media>();
	}
	

}

	

