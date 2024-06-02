package hust.soict.globalict.aims.screen.manager;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.store.Store;

public abstract class AddItemToStoreScreen extends JFrame{
	protected JFrame frame;
    protected Store store;
    protected Cart cart;
    JButton addButton;


    public AddItemToStoreScreen (Store store, Cart cart) {
        this.store = store;
        this.cart = cart;
        frame = new JFrame();

        setTitle("Add item");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setVisible(true);

        add(createMenuBar(), BorderLayout.NORTH);

        addButton = new JButton("Add");
        addButton.addActionListener(e -> addItemToStore());
    }

    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");

        JMenuItem viewStoreMenu = new JMenuItem("View store");
        menu.add(viewStoreMenu);
        viewStoreMenu.addActionListener(new btnMenuListener());

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }

    private class btnMenuListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
            new StoreManagerScreen(store, cart);
        }
    }

    protected abstract void addItemToStore();
}
