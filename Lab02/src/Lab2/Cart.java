package Lab2;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] =
			new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private int qtyOrdered;
	
	public int getQtyOrdered() {
		return qtyOrdered;
	}
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (this.qtyOrdered < MAX_NUMBERS_ORDERED) {
			itemsOrdered[qtyOrdered] = disc;
			qtyOrdered++;
			System.out.println("The disc has been added");
		}
		else {
			System.out.println("The cart is almost full");
		}
	}
	
	public double totalCost() {
		double cost = 0;
		for( int i = 0; i < qtyOrdered;i++) {
			cost += (double)itemsOrdered[i].getCost();
	}
		return cost;
	}
	
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		 for (int i = 0; i < qtyOrdered; i++) {
	            if (itemsOrdered[i] == disc) {
	            
	                for (int j = i; j < qtyOrdered - 1; j++) {
	                    itemsOrdered[j] = itemsOrdered[j + 1];
	                }
	                itemsOrdered[qtyOrdered - 1] = null;
	                System.out.printf("The disc %s has been removed \n", disc.getTitle());
	                qtyOrdered--;
	                break;
	            }
	        }
	}
	
	
	public void displayCart() {
        System.out.println("------- Cart Display -------");
        for (int i = 0; i < qtyOrdered; i++) {
            System.out.printf("%-20s %-15s %-20s %-5d %-5.2f \n", itemsOrdered[i].getTitle(), itemsOrdered[i].getCategory(),
            	itemsOrdered[i].getDirector(), itemsOrdered[i].getLength(), itemsOrdered[i].getCost());
        }
    }
	
	
	
}
