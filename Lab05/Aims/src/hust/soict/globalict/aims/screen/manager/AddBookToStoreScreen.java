package hust.soict.globalict.aims.screen.manager;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.store.Store;

public class AddBookToStoreScreen extends AddItemToStoreScreen{

	  	private JLabel titleLabel, categoryLabel, costLabel, authorLabel;
	    private JTextField titleField, categoryField, costField, authorField;
	    private JTextArea authorsArea;
	    private JPanel authorsPanel;
	    private JButton addAuthorButton;
	    private ArrayList<String> authors;

	    public AddBookToStoreScreen(Store store, Cart cart) {
	        super(store, cart);
	        super.setTitle("Add Book");

	        titleLabel = new JLabel("Title:");
	        categoryLabel = new JLabel("Category:");
	        authorLabel = new JLabel("Authors:");
	        costLabel = new JLabel("Cost:");

	        titleField = new JTextField();
	        categoryField = new JTextField();
	        authorField = new JTextField();
	        costField = new JTextField();

	        authors = new ArrayList<>();
	        authorsPanel = new JPanel(new BorderLayout());
	        authorsArea = new JTextArea();

	        addComponents();
	    }

	    private void addComponents() {
	        JPanel panel = new JPanel(new GridLayout(4, 2));
	        addButton = new JButton("Add Book");

	        panel.add(titleLabel);
	        panel.add(titleField);

	        panel.add(categoryLabel);
	        panel.add(categoryField);

	        panel.add(costLabel);
	        panel.add(costField);

	        panel.add(authorLabel);
	        panel.add(authorField);


	        authorsArea.setEditable(false);
	        authorsPanel.add(new JScrollPane(authorsArea), BorderLayout.CENTER);

	        this.add(createCenter(panel, authorsPanel), BorderLayout.CENTER);
	        this.add(addButton, BorderLayout.SOUTH);
	    }

	    JPanel createCenter (JPanel p1, JPanel p2) {
	        JPanel panel = new JPanel(new BorderLayout());

	        panel.add(p1, BorderLayout.NORTH);
	        panel.add(p2, BorderLayout.CENTER);

	        return panel;
	    }

	    @Override
	    protected void addItemToStore() {
	        String title = titleField.getText();
	        String category = categoryField.getText();
	        float cost = Float.parseFloat(costField.getText());

	        Book book = new Book(title, category, cost, authors);
	        store.addMedia(book);

	        JOptionPane.showMessageDialog(frame, "Book added successfully.");
	        new StoreManagerScreen(store, cart);

	        dispose();
	    }

}
