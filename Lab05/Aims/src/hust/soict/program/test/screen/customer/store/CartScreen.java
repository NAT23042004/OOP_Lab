package hust.soict.program.test.screen.customer.store;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.screen.customer.controller.CartController;
import hust.soict.globalict.aims.screen.customer.controller.ItemController;
import hust.soict.globalict.aims.screen.customer.controller.ViewStoreController;
import hust.soict.globalict.aims.store.Store;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CartScreen extends Application{

	private static Store store;
	private static Cart cart;

	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		final String CART_FXML_FILE_PATH = "/hust/soict/globalict/aims/screen/customer/view/Cart.fxml";
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(CART_FXML_FILE_PATH));
		CartController cartController = new CartController(store, cart);
		fxmlLoader.setController(cartController);
		Parent root = fxmlLoader.load();
		
		primaryStage.setTitle("Cart");
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		store = new Store();
		cart = new Cart();
		ItemController itemController = new ItemController(store, cart);
		
		launch(args);
	}

}
