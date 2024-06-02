package hust.soict.globalict.aims.cart;
import java.util.*;

import javax.naming.LimitExceededException;

import hust.soict.globalict.aims.media.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	public static final Comparator<Media> COMPARE_BY_TITLE_COST = 
			new MediaComparatorByTitleCost();
	public static final Comparator<Media> COMPARE_BY_CTITLE =
			new MediaComparatorByCostTitle();
	private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();
	Scanner myInput = new Scanner(System.in);
	
	public int getqtyOrdered() {
        return itemsOrdered.size();
    }

	public int getSize() {
		return itemsOrdered.size();
	}
	public ObservableList<Media> getItemsOrdered() {
		return itemsOrdered;
	}
	
	
	public void addMedia(Media media) throws LimitExceededException{
		if(itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
            throw new LimitExceededException("ERROR: The number of media has reached its limit");
		}
		else {
			if (itemsOrdered.contains(media)) {
				System.out.println("The media is already in the cart.");
			} else {
				itemsOrdered.add(media);
				System.out.println("The media is added successfully.");
			}
		}
	}
	public void removeMedia(Media media) {
		if(itemsOrdered.size() < 1) {
			System.out.println("There isn't any media in the Cart.");
		}
		else {
			for(Object t : itemsOrdered) {
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
			cost += (double) media.getCost();
	    }
		return cost;
	}
	
	public void printCart() {
        System.out.println("******************************Cart Display******************************");
        int index = 1;
        for (Object media : itemsOrdered) {
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
			if( media.getTitle().equals(title)) {			
			return  media;
		}
		}
		return null;
	}  
	public void placeOrder() {
        if (itemsOrdered.size() == 0) {
        	System.out.println("The cart is empty.");
        	return;
        } else {
            itemsOrdered.clear();
            System.out.println("Order is placed successfully.");
        }
    }
	public void sortMediaByTitle() {
        Collections.sort((List<Media>)itemsOrdered, Media.COMPARE_BY_TITLE_COST);
        Iterator<Media> iterator = itemsOrdered.iterator();
        iterator = itemsOrdered.iterator();
    
        while (iterator.hasNext()) {
            System.out.println(((Media)iterator.next()).toString());
        }
    }
    public void sortMediaByCost() {
        Collections.sort((List<Media>)itemsOrdered, Media.COMPARE_BY_COST_TITLE);
        Iterator<Media> iterator = itemsOrdered.iterator();
        iterator = itemsOrdered.iterator();
    
        while (iterator.hasNext()) {
            System.out.println(((Media)iterator.next()).toString());
        }
    }
    
	public void deleteAll() {
		itemsOrdered.clear();
		System.out.println("The cart is empty.");
	}
}

	

