package hust.soict.globalict.aims.screen.manager;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen{

	 private JLabel titleLabel, categoryLabel, directorLabel, lengthLabel, costLabel;
	    private JTextField titleField, categoryField, directorField, lengthField, costField;

	    public AddDigitalVideoDiscToStoreScreen(Store store) {
	        super(store);
	        super.setTitle("Add DVD");

	        titleLabel = new JLabel("Title:");
	        categoryLabel = new JLabel("Category:");
	        directorLabel = new JLabel("Director:");
	        lengthLabel = new JLabel("Length:");
	        costLabel = new JLabel("Cost:");

	        titleField = new JTextField();
	        categoryField = new JTextField();
	        directorField = new JTextField();
	        lengthField = new JTextField();
	        costField = new JTextField();

	    }

	   
	    @Override
	    protected void addItemToStore() {
	        String title = titleField.getText();
	        String category = categoryField.getText();
	        String director = directorField.getText();
	        int length = Integer.parseInt(lengthField.getText());
	        double cost = Double.parseDouble(costField.getText());

	        DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, length, cost);
	        store.addMedia(dvd);
	        JOptionPane.showMessageDialog(frame, "DVD added successfully.");
	        new StoreManagerScreen(store);

	        dispose();
	    }
}