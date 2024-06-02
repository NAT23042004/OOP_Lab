package hust.soict.globalict.aims.screen.customer.controller;

import javax.naming.LimitExceededException;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.exception.PlayerException;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.Playable;
import hust.soict.globalict.aims.store.Store;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class ItemController {

    @FXML
    private Button btnAddToCart;

    @FXML
    private Button btnPlay;

    @FXML
    private Label lblCost;

    @FXML
    private Label lblTitle;
    
    private Store store;

	private Cart cart;
	private Media media;
	
   
    public ItemController(Store store, Cart cart) {
        this.store = store;
        this.cart = cart;
    }
    
    @FXML
    void btnAddToCartClicked(ActionEvent event) {
    	try {
			cart.addMedia(media);
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("Add to cart");
			alert.setHeaderText(null);
			alert.setContentText(media.getTitle() + " has been added to cart");
			alert.showAndWait();
		} catch (LimitExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Add to cart");
			alert.setHeaderText(null);
			alert.setContentText(e.getMessage());
			alert.showAndWait();
		}
    }

    @FXML
	void btnPlayClicked(ActionEvent event) {
		try {
			((Playable) media).play();
		} catch (PlayerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Play");
			alert.setHeaderText(null);
			alert.setContentText(e.getMessage());
			alert.showAndWait();
		}
    }



	public void setData(Media media) {
    	this.media = media;
    	lblTitle.setText(media.getTitle());
    	lblCost.setText(media.getCost()+" $");
    	if(media instanceof Playable) {
    		btnPlay.setVisible(true);
    	}
    	else {
    		btnPlay.setVisible(false);
    		HBox.setMargin(btnAddToCart, new Insets(0, 0, 0, 60));
    	}
    }
    
}
