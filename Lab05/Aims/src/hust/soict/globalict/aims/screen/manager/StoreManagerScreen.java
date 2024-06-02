package hust.soict.globalict.aims.screen.manager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.screen.customer.controller.CartController;
import hust.soict.globalict.aims.screen.customer.controller.ViewStoreController;
import hust.soict.globalict.aims.store.Store;
import hust.soict.program.test.screen.customer.store.CartScreen;
import hust.soict.program.test.screen.customer.store.ViewStoreScreen;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StoreManagerScreen extends JFrame{
	private Store store;
	private Cart cart;
	
	public StoreManagerScreen(Store store, Cart cart) {
		this.store = store;
		this.cart = cart;
		
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(createCenter(), BorderLayout.CENTER);
		
		setTitle("Store");
		setSize(1024, 768);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	private void initializeJavaFXToolkit() {
        if (Platform.isFxApplicationThread()) {
            return;
        }

        final JFXPanel fxPanel = new JFXPanel();
    }

	
	 	
	

	JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		return north;
	}
	
	JMenuBar createMenuBar() {
		JMenu menu = new JMenu("Options");
		JMenu smUpdateStore = new JMenu("Update Store");
		
		JMenuItem addBookMenu= new JMenuItem("Add Book");
		addBookMenu.addActionListener(e->{
			new AddBookToStoreScreen(store, cart);
		});
		smUpdateStore.add(addBookMenu);
		
		JMenuItem addCDMenu=new JMenuItem("Add CD");
		addCDMenu.addActionListener(e->{
			new AddCompactDiscToStoreScreen(store, cart);
		});
		smUpdateStore.add(addCDMenu);
		
		JMenuItem addDVDMenu= new JMenuItem("Add DVD");
		addDVDMenu.addActionListener(e->{
			new AddDigitalVideoDiscToStoreScreen(store, cart);
		});
		smUpdateStore.add(addDVDMenu);
		menu.add(smUpdateStore);
		
		JMenuItem viewStoreMenu= new JMenuItem("View store");
		viewStoreMenu.addActionListener(e->{
			openStoreScreen();
		});
		menu.add(viewStoreMenu);
		
		JMenuItem viewCartMenu= new JMenuItem("View cart");
		viewCartMenu.addActionListener(e->{
			openCartScreen();
		});
		menu.add(viewCartMenu);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);
		
		return menuBar;
	}
	
	public void openStoreScreen() {
		initializeJavaFXToolkit();
		Platform.runLater(() -> {
			Stage primaryStage = new Stage();
			final String VIEW_STORE_FXML_FILE_PATH = "/hust/soict/globalict/aims/screen/customer/view/Store.fxml";
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(VIEW_STORE_FXML_FILE_PATH));
			ViewStoreController viewStoreController = new ViewStoreController(store, cart);
			fxmlLoader.setController(viewStoreController);
			Parent root = null;
			try {
				root = fxmlLoader.load();
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (NullPointerException e2) {
				e2.printStackTrace();
			}

			primaryStage.setTitle("Store");
			primaryStage.setScene(new Scene(root));
			primaryStage.show();
		});
	}
	
	public void openCartScreen() {
	    initializeJavaFXToolkit();
	    Platform.runLater(() -> {
	        Stage primaryStage = new Stage();
	        final String CART_FXML_FILE_PATH = "/hust/soict/globalict/aims/screen/customer/view/Cart.fxml";
	        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(CART_FXML_FILE_PATH));
	        CartController cartController = new CartController(store, cart);
	        fxmlLoader.setController(cartController);
	        Parent root = null;
	        try {
	            root = fxmlLoader.load();
	        } catch (IOException e1) {
	            e1.printStackTrace();
	        } catch (NullPointerException e2) {
	            e2.printStackTrace();
	        }

	        primaryStage.setTitle("Cart");
	        primaryStage.setScene(new Scene(root));
	        primaryStage.show();
	    });
	}

	
	
	JPanel createHeader() {
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
		
		JLabel title = new JLabel("AIMS");
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
		title.setForeground(Color.CYAN);
		
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		header.add(title);
		header.add(Box.createHorizontalGlue());
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		
		return header;
	}
	
	JPanel createCenter() {
		
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(3, 3, 2, 2));
		
		ArrayList<Media> mediaInStore = store.getItemsInStore();
		for (int i = 0; i < mediaInStore.size(); i++) {
		        MediaStore cell = new MediaStore(mediaInStore.get(i), cart);
		        center.add(cell);
		}
		return center;
	}
	public static void main(String args[]) {
		Store store = new Store();
		Cart cart = new Cart();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
				"Animation", "Roger Aller", 87, 19.95f);
		System.out.println(dvd1.getId());
		store.addMedia(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
				"Science Fiction", "George Lucas", 87, 24.95f);
		System.out.println(dvd2.getId());
		store.addMedia(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
				"Animation", 18.99f);
		System.out.println(dvd3.getId());
		store.addMedia(dvd3);
		
		try {
			new StoreManagerScreen(store, cart);
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		
	}
	

}
