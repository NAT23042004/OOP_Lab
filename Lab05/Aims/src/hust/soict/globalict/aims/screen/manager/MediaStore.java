package hust.soict.globalict.aims.screen.manager;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;
import java.net.URLEncoder;

import javax.naming.LimitExceededException;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.Playable;

public class MediaStore extends JPanel {
	private Media media;
	private Cart cart;

	public MediaStore(Media media, Cart cart) {
		this.media = media;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JLabel title = new JLabel(media.getTitle());
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 15));
		title.setAlignmentX(CENTER_ALIGNMENT);
		
		JLabel cost = new JLabel(""+media.getCost()+ " $");
		cost.setAlignmentX(CENTER_ALIGNMENT);
		
		JPanel container = new JPanel();
		container.setLayout(new FlowLayout(FlowLayout.CENTER));   
		
		JButton addToCartButton = new JButton("Add to cart");
        addToCartButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                	cart.addMedia(media);
                    JOptionPane.showMessageDialog(null, "" + 
                	media.getTitle() + " has been added to cart", "Success", 
                	JOptionPane.INFORMATION_MESSAGE);
                } catch (LimitExceededException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), 
                    		"Error", JOptionPane.ERROR_MESSAGE);
                }
                
            }
        });
        container.add(addToCartButton);
		
		
        if(media instanceof Playable) {
            JButton playButton = new JButton("Play");
            playButton.addActionListener(e -> {
                try {
                    String mediatitle = media.getTitle();
                    String url = "https://www.google.com/search?q=" + URLEncoder.encode(mediatitle, "UTF-8");
                    Desktop.getDesktop().browse(new URI(url));
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            });
            container.add(playButton);
        }
		this.add(Box.createVerticalGlue());
		this.add(title);
		this.add(cost);
		this.add(Box.createVerticalGlue());
		this.add(container);
		
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}
	
	
}
