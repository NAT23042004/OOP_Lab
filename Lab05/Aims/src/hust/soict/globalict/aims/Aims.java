package hust.soict.globalict.aims;

import hust.soict.globalict.aims.cart.*;
import hust.soict.globalict.aims.exception.PlayerException;
import hust.soict.globalict.aims.media.*;
import hust.soict.globalict.aims.store.*;
import java.util.Scanner;

import javax.naming.LimitExceededException;

import java.util.Collections;

public class Aims {
	private static Scanner scan = new Scanner(System.in);
	private static int choice;
	private static String inputString;
	private static int inputInt;
	private static Store store = new Store();
	private static Cart cart = new Cart();
	private static Media item;

	public static Media createMedia() {
		System.out.println("Choose a media:\n1. DVD\t2. Book\t3. CD");
		choice = scan.nextInt();
		scan.nextLine();

		switch (choice) {
		case 1:
			DigitalVideoDisc dvd = new DigitalVideoDisc();

			System.out.print("Title: ");
			inputString = scan.nextLine();
			dvd.setTitle(inputString);

			System.out.print("Category: ");
			inputString = scan.nextLine();
			dvd.setCategory(inputString);

			System.out.print("Director: ");
			inputString = scan.nextLine();
			dvd.setDirector(inputString);

			System.out.print("Length: ");
			inputInt = scan.nextInt();
			dvd.setLength(inputInt);

			System.out.print("Cost: ");
			float inputFloat = scan.nextFloat();
			dvd.setCost(inputFloat);

			return dvd;

		case 2:
			Book book = new Book();

			System.out.print("Title: ");
			inputString = scan.nextLine();
			book.setTitle(inputString);

			System.out.print("Category: ");
			inputString = scan.nextLine();
			book.setCategory(inputString);

			System.out.print("Number of authors: ");
			inputInt = scan.nextInt();
			scan.nextLine();

			for (int i = 1; i <= inputInt; i++) {
				System.out.print("Enter author: ");
				inputString = scan.nextLine();
				book.addAuthor(inputString);
			}

			System.out.print("Cost: ");
			inputFloat = scan.nextFloat();
			book.setCost(inputFloat);

			return book;

		case 3:
			CompactDisc cd = new CompactDisc();

			System.out.print("Title: ");
			inputString = scan.nextLine();
			cd.setTitle(inputString);

			System.out.print("Category: ");
			inputString = scan.nextLine();
			cd.setCategory(inputString);

			System.out.print("Artist: ");
			inputString = scan.nextLine();
			cd.setArtist(inputString);

			System.out.print("Cost: ");
			inputFloat = scan.nextFloat();
			cd.setCost(inputFloat);

			System.out.print("Number of tracks: ");
			int nbTracks = scan.nextInt();
			scan.nextLine();
			for (int i = 1; i <= nbTracks; i++) {
				Track track = new Track();

				System.out.print("Input title: ");
				inputString = scan.nextLine();
				track.setTitle(inputString);

				System.out.print("Input length: ");
				inputInt = scan.nextInt();
				scan.nextLine();
				track.setLength(inputInt);

				cd.addTrack(track);
			}

			return cd;

		default:
			return null;
		}
	}

	public static void showMenu() {
		System.out.println("WELCOME TO AIMS");
		System.out.println("--------------------------------");
		System.out.println("1. View store");
		System.out.println("2. Update store");
		System.out.println("3. See current cart");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
		choice = scan.nextInt();

		switch (choice) {
		case 1:
			store.printCart();

			storeMenu();
			break;

		case 2:
			Media media = createMedia();
			if (media == null) {
				System.out.println("Error creating Media");
				showMenu();
				return;
			}

			System.out.println("Choose an option:\n1. Add media\t2. Remove media");
			choice = scan.nextInt();
			if (choice == 1)
				store.addMedia(media);
			else if (choice == 2)
				store.removeMedia(media);
			else
				System.out.println("Choose only 1 or 2.");

			showMenu();
			break;

		case 3:
			cart.printCart();

			cartMenu();
			break;

		case 0:
			break;

		default:
			System.out.println("Choose only 0, 1, 2 or 3.");
			showMenu();
			break;
		}
	}

	public static void storeMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. See a media’s details");
		System.out.println("2. Add a media to cart");
		System.out.println("3. Play a media");
		System.out.println("4. See current cart");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
		choice = scan.nextInt();
		scan.nextLine();
		switch (choice) {
		case 1:
			System.out.print("Title: ");
			inputString = scan.nextLine();
			item = store.searchByTitle(inputString);
			if (item == null) {
				System.out.println("Item doesn't exist!");
				storeMenu();
				return;
			}
			System.out.println(item.toString());

			mediaDetailsMenu();
			break;
		case 2:
			System.out.print("Title: ");
			inputString = scan.nextLine();
			item = store.searchByTitle(inputString);
			if (item == null) {
				System.out.println("Item doesn't exist!");
				storeMenu();
				return;
			}
			try {
				cart.addMedia(item);
			} catch (LimitExceededException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println("There're " + cart.getSize() + " items in your cart.");

			storeMenu();
			break;
		case 3:
			System.out.print("Title: ");
			inputString = scan.nextLine();
			item = store.searchByTitle(inputString);
			if (item == null) {
				System.out.println("Item doesn't exist!");
				storeMenu();
				return;
			}
			if (item.getClass().getSimpleName().equals("Book")) {
				System.out.println("This feature does not apply for book!");
				storeMenu();
				return;
			}
			if (item.getClass().getSimpleName().equals("CompactDisc")) {
				CompactDisc cd = (CompactDisc) item;
				try {
					cd.play();
				} catch (PlayerException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				storeMenu();
				return;
			}
			if (item.getClass().getSimpleName().equals("DigitalVideoDisc")) {
				DigitalVideoDisc dvd = (DigitalVideoDisc) item;
				try {
					dvd.play();
				} catch (PlayerException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				storeMenu();
				return;
			}
		case 4:
			cart.printCart();

			cartMenu();
			return;
		case 0:
			showMenu();
			break;
		default:
			System.out.println("Choose only 0, 1, 2, 3, or 4.");
			storeMenu();
			return;
		}
	}

	public static void mediaDetailsMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Add to cart");
		System.out.println("2. Play");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
		choice = scan.nextInt();
		scan.nextLine();
		switch (choice) {
		case 1:
			try {
				cart.addMedia(item);
			} catch (LimitExceededException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			storeMenu();
			return;
		case 2:
			if (item.getClass().getSimpleName().equals("Book")) {
				System.out.println("This feature does not apply to book!");
				System.out.println(item.toString());
				mediaDetailsMenu();
				return;
			}
			if (item.getClass().getSimpleName().equals("CompactDisc")) {
				CompactDisc cd = (CompactDisc) item;
				try {
					cd.play();
				} catch (PlayerException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(item.toString());
				mediaDetailsMenu();
				return;
			}
			if (item.getClass().getSimpleName().equals("DigitalVideoDisc")) {
				DigitalVideoDisc dvd = (DigitalVideoDisc) item;
				try {
					dvd.play();
				} catch (PlayerException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(item.toString());
				mediaDetailsMenu();
				return;
			}
		case 0:
			storeMenu();
			return;
		default:
			System.out.println("Choose only 0, 1, or 2!");
			System.out.println(item.toString());
			mediaDetailsMenu();
			return;
		}
	}

	public static void cartMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Filter medias in cart");
		System.out.println("2. Sort medias in cart");
		System.out.println("3. Remove media from cart");
		System.out.println("4. Play a media");
		System.out.println("5. Place order");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4-5");
		choice = scan.nextInt();
		scan.nextLine();
		switch (choice) {
		case 1:
			System.out.println("Filter by:\n1. id\t2. title");
			choice = scan.nextInt();
			scan.nextLine();
			if (choice == 1) {
				System.out.print("Id: ");
				inputInt = scan.nextInt();
				Media media = cart.searchByID(inputInt);
				if (media == null) {
					System.out.println("Not found item.");
					return;
				}
				System.out.println(media.toString());
				cartMenu();
				return;
			} else if (choice == 2) {
				System.out.print("Title: ");
				inputString = scan.nextLine();
				Media media = cart.searchByTitle(inputString);
				if (media == null) {
					System.out.println("Not found item.");
					return;
				}
				System.out.println(media.toString());
				cartMenu();
				return;
			} else {
				System.out.println("Choose only 1 or 2.");
				cartMenu();
				return;
			}
		case 2:
			System.out.println("Sort by:\n1. title\t2. cost");
			choice = scan.nextInt();
			if (choice == 1) {
				Collections.sort(cart.getItemsOrdered(), Media.COMPARE_BY_TITLE_COST);
				cart.printCart();
				cartMenu();
				return;
			} else if (choice == 2) {
				Collections.sort(cart.getItemsOrdered(), Media.COMPARE_BY_COST_TITLE);
				cart.printCart();
				cartMenu();
				return;
			} else {
				System.out.println("Choose only 1 or 2.");
				cartMenu();
				return;
			}
		case 3:
			System.out.print("Title to remove: ");
			inputString = scan.nextLine();
			Media removeItem = cart.searchByTitle(inputString);
			cart.removeMedia(removeItem);
			cartMenu();
			return;
		case 4:
			System.out.print("Title to play: ");
			inputString = scan.nextLine();
			item = cart.searchByTitle(inputString);
			if (item == null) {
				System.out.println("Item not found!");
				cartMenu();
				return;
			}
			if (item.getClass().getSimpleName().equals("Book")) {
				System.out.println("This feature does not apply to book!");
				cartMenu();
				return;
			}
			if (item.getClass().getSimpleName().equals("CompactDisc")) {
				CompactDisc cd = (CompactDisc) item;
				try {
					cd.play();
				} catch (PlayerException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				cartMenu();
				return;
			}
			if (item.getClass().getSimpleName().equals("DigitalVideoDisc")) {
				DigitalVideoDisc dvd = (DigitalVideoDisc) item;
				try {
					dvd.play();
				} catch (PlayerException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				cartMenu();
				return;
			}
			System.out.println("Item not found!");
			cartMenu();
			return;
		case 5:
			System.out.println("Order created!");
			cart.deleteAll();
			showMenu();
			return;
		case 0:
			showMenu();
			return;
		default:
			System.out.println("Choose only from 0 to 5.");
			cartMenu();
			return;
		}
	}

	public static void main(String[] args) {
		showMenu();
	}
}