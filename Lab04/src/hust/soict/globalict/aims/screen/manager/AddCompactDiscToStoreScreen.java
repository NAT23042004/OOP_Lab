package hust.soict.globalict.aims.screen.manager;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.store.Store;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen{

	private JLabel titleLabel, categoryLabel, costLabel, lengthLabel, directorLabel, artistLabel;
    private JTextField titleField, categoryField, artistField, directorField, costField, lengthField;

    public AddCompactDiscToStoreScreen (Store store) {
        super(store);
        super.setTitle("Add CD");

        titleLabel = new JLabel("Title:");
        categoryLabel = new JLabel("Category:");
        costLabel = new JLabel("Cost:");
        lengthLabel = new JLabel("Length:");
        directorLabel = new JLabel("Director:");
        artistLabel = new JLabel("Artist:");


        titleField = new JTextField();
        categoryField = new JTextField();
        costField = new JTextField();
        lengthField = new JTextField();
        directorField = new JTextField();
        artistField = new JTextField();

    }

    @Override
	protected void addItemToStore() {
        String title = titleField.getText();
        String category = categoryField.getText();
        String artist = artistField.getText();
        String director = directorField.getText();
        float cost = Float.parseFloat(costField.getText());
        int length = Integer.parseInt(lengthField.getText());

        CompactDisc cd = new CompactDisc(title, category, cost, length, director, artist);
        store.addMedia(cd);
        JOptionPane.showMessageDialog(frame, "CD added successfully.");
        new StoreManagerScreen(store);

        dispose();
    }
}
