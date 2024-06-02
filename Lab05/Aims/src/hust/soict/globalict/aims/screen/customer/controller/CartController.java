package hust.soict.globalict.aims.screen.customer.controller;

import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.Playable;
import hust.soict.globalict.aims.store.Store;

import java.io.IOException;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.exception.PlayerException;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


public class CartController {
    	private Cart cart;

		private Store store;
	    
	    public CartController(Cart cart) {
	    	super();
	    	this.cart = cart;
	    }
	    
	    public CartController(Store store, Cart cart) {
			// TODO Auto-generated constructor stub
	    	this.cart = cart;
	    	this.store = store;
	    	
	    	
		}

	
		@FXML
	    private Button btnPlay;

	    @FXML
	    private Button btnRemove;

	    @FXML
	    private TableColumn<Media, String> colMediaCategory;

	    @FXML
	    private TableColumn<Media, Float> colMediaCost;

	    @FXML
	    private TableColumn<Media, Integer> colMediaId;

	    @FXML
	    private TableColumn<Media, String> colMediaTitle;

	    @FXML
	    private Label costLabel;

	    @FXML
	    private ToggleGroup filterCategory;

	    @FXML
	    private TableView<Media> tblMedia;
	   
	    @FXML
	    private RadioButton radioBtnFilterId;

	    @FXML
	    private RadioButton radioBtnFilterTitle;

	    @FXML
	    private TextField tfFilter;
	    
	    @FXML
	    private Button btnPlaceOrder;
	    
	    @FXML
	    private Button btnViewStore;

	    @FXML
	    void btnPlayPressed(ActionEvent event) {
	    	Media media = tblMedia.getSelectionModel().getSelectedItem();
	        try {
	            ((Playable) media).play();
	        } catch (PlayerException e) {
	           e.printStackTrace();
	        }
	      
	    }

	    @FXML
	    void btnRemovePressed(ActionEvent event) {
	    	Media media = tblMedia.getSelectionModel().getSelectedItem();
	    	cart.removeMedia(media);
		    costLabel.setText(String.format("%.2f $", cart.totalCost()));	
	    }
	    void updateButtonBar(Media media) {
	        btnRemove.setVisible(true);
	        if(media instanceof Playable) {
	            btnPlay.setVisible(true);
	        } else btnPlay.setVisible(false);
	    }

	    @FXML
	    void btnViewStorePressed(ActionEvent event) {
	    	try {
	    		final String STORE_FXML_PATH = "/hust/soict/globalict/aims/screen/customer/view/Store.fxml";
	    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_PATH));
	    			fxmlLoader.setController(new ViewStoreController(store, cart));
	    			Parent root = fxmlLoader.load();
	    			Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
	    			stage.setScene(new Scene(root));
	    			stage.setTitle("Store");
	    			stage.show();
	    			
	    	}catch(IOException e) {
	    		e.printStackTrace();
	    	}
	    }
	    
	    @FXML
   	 	void btnPlaceOrderPressed(ActionEvent event) {
   			Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
   	        alert.setTitle("Place Orders");
   	        alert.setHeaderText("Are you sure to place orders!");
   	        if (alert.showAndWait().get() == ButtonType.OK) {
   		    	cart.placeOrder();
   	        	Alert successAlert = new Alert(Alert.AlertType.CONFIRMATION);
   	            successAlert.setTitle("Order Placed");
   	            successAlert.setHeaderText(null);
   	            successAlert.setContentText("The order has been placed successfully! What would you like to do next?");
   	            costLabel.setText(String.format("%.2f $", cart.totalCost()));	

   	            ButtonType exitButton = new ButtonType("Exit");
   	            ButtonType stayButton = new ButtonType("Stay");

   	            successAlert.getButtonTypes().setAll(exitButton, stayButton);

   	            if (successAlert.showAndWait().get() == exitButton) {
   	                System.exit(0); 
   	            } else {
   	                successAlert.close();   	            
   	             }
   	        }
   	 	}
	    
	
		@FXML
	    public void initialize() {
	    	colMediaId.setCellValueFactory(
	    			new PropertyValueFactory<Media, Integer>("id"));
	    	colMediaTitle.setCellValueFactory(
	    			new PropertyValueFactory<Media, String>("title"));
	    	colMediaCategory.setCellValueFactory(
	    			new PropertyValueFactory<Media, String>("category"));
	    	colMediaCost.setCellValueFactory(
	    			new PropertyValueFactory<Media, Float>("cost"));
	    	if(cart.getItemsOrdered() != null) {
	    		tblMedia.setItems(cart.getItemsOrdered());
	    	}
	    	
	    	btnPlay.setVisible(false);
	    	btnRemove.setVisible(false);
	    	
	    	tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {
	    		@Override
	    		public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
	    			updateButtonBar(newValue);
	    		}
	    		void updateButtonBar(Media media) {
		    		if(media == null) {
		    			btnPlay.setVisible(false);
		    			btnRemove.setVisible(false);
		    		}
		    		else {
		    			btnRemove.setVisible(true);
		    			if(media instanceof Playable) {
		    				btnPlay.setVisible(true);
		    			}
		    			else {
		    				btnPlay.setVisible(false);
		    			}
		    		}
		    	}
	    	}); 
	    	
	    	tfFilter.textProperty().addListener(new ChangeListener<String>() {
	    		@Override
	    		public void changed(ObservableValue<? extends String> observable, String oldValue,
	    				String newValue) {
	    			showFilteredMedia(newValue);
	    		}
	    		
	    		void showFilteredMedia(String value) {
	    			FilteredList<Media> filteredList = new FilteredList<>(cart.getItemsOrdered());

	                if (!value.isEmpty() && radioBtnFilterId.isSelected()) {
	                    filteredList.setPredicate(media -> {
	                        String idString = String.valueOf(media.getId());
	                        return idString.equals(value);
	                    });
	                } else if (!value.isEmpty() &&  radioBtnFilterTitle.isSelected()) {
	                    filteredList.setPredicate(media -> {
	                        String title = media.getTitle().toLowerCase();
	                        return title.contains(value.toLowerCase());
	                    });
	                } else {
	                    filteredList.setPredicate(null);
	                }
	                tblMedia.setItems(filteredList);
	    		}
	    	});
	    	
	    costLabel.setText(String.format("%.2f $", cart.totalCost()));	
	    }
	    
}
