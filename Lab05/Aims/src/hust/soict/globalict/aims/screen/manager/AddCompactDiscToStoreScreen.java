
package hust.soict.globalict.aims.screen.manager;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.store.Store;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen{

    private JLabel titleLabel, categoryLabel, costLabel, lengthLabel, directorLabel, artistLabel;
    private JTextField titleField, categoryField, artistField, directorField, costField, lengthField;
    private JButton addButton;
    private JFrame frame;

    public AddCompactDiscToStoreScreen (Store store, Cart cart) {
        super(store, cart);
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
        
  	
        frame = this;
 

        addComponents();
    }

    private void addComponents() {
        JPanel panel = new JPanel(new GridLayout(6, 2));
        addButton = new JButton("Add CD");

        panel.add(titleLabel);
        panel.add(titleField);

        panel.add(categoryLabel);
        panel.add(categoryField);

        panel.add(costLabel);
        panel.add(costField);
        
        panel.add(lengthLabel);
        panel.add(lengthField);

        panel.add(directorLabel);
        panel.add(directorField);

        panel.add(artistLabel);
        panel.add(artistField);

        this.add(panel, BorderLayout.CENTER);
        this.add(addButton, BorderLayout.SOUTH);
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
        new StoreManagerScreen(store, cart);

        dispose();
    }
}
