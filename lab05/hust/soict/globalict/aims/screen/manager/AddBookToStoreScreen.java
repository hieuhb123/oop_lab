package hust.soict.globalict.aims.screen.manager;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.store.Store;

public class AddBookToStoreScreen extends Screen implements ActionListener{
	private JTextField titleInput, categoryInput, costInput, authorInput;
	public AddBookToStoreScreen(Store store) {
		super(store);
	}
	
	JPanel createCenter() {
	    JPanel center = new JPanel(new GridBagLayout());
	    GridBagConstraints gbc = new GridBagConstraints();
	    gbc.anchor = GridBagConstraints.WEST;
	    gbc.insets = new Insets(10, 10, 10, 10);

	    // Title components
	    JLabel titleLabel = new JLabel("Enter title:");
	    titleInput = new JTextField(20);
	    addComponents(center, titleLabel, titleInput, gbc);

	    // Category components
	    JLabel categoryLabel = new JLabel("Enter category:");
	    categoryInput = new JTextField(20);
	    gbc.gridy++;
	    addComponents(center, categoryLabel, categoryInput, gbc);

	    // Cost components
	    JLabel costLabel = new JLabel("Enter cost:");
	    costInput = new JTextField(20);
	    gbc.gridy++;
	    addComponents(center, costLabel, costInput, gbc);

	    // Authors components
	    JLabel authorsLabel = new JLabel("Enter authors' name:");
	    authorInput = new JTextField(20);
	    gbc.gridy++;
	    addComponents(center, authorsLabel, authorInput, gbc);

	    // Submit button
	    JButton submitButton = new JButton("Submit");
	    submitButton.setPreferredSize(new Dimension(100, 30));
	    gbc.gridy++;
	    gbc.fill = GridBagConstraints.HORIZONTAL;
	    center.add(submitButton, gbc);
	    
	    submitButton.addActionListener(this);
	    
	    return center;
	}

	private void addComponents(JPanel panel, JLabel label, JTextField textField, GridBagConstraints gbc) {
	    gbc.gridx = 0;
	    gbc.gridwidth = 1;
	    panel.add(label, gbc);

	    gbc.gridx = 1;
	    gbc.gridwidth = 2;
	    gbc.fill = GridBagConstraints.HORIZONTAL;
	    panel.add(textField, gbc);

	    gbc.gridy++;
	}

	
	public void actionPerformed(ActionEvent e){
		String action = e.getActionCommand();
        if (action.equals("Add CD")){
        	dispose();
            new AddCompactDiscToStoreScreen(store);
        }
        else if (action.equals("Add DVD")){
            dispose();
            new AddDigitalVideoDiscToStoreScreen(store);
        }
        else if (action.equals("Submit")){
            String title = titleInput.getText();
            String category = categoryInput.getText();
            float cost = Float.parseFloat(costInput.getText());
            ArrayList<String> authors = new ArrayList<String>();
            String author = authorInput.getText();
            String temp = "";
            for (int i = 0; i < author.length(); i++){
                if (author.charAt(i) != ','){
                    temp += author.charAt(i);
                }
                else {
                    authors.add(temp);
                    temp = "";
                }
            }
            Book book = new Book(1, title, category, cost, authors);
            store.addMedia(book);
            JOptionPane.showMessageDialog(this, "The book has been added successfully!!!");
            dispose();
            new StoreManagerScreen(store);

        }
        else{
            dispose();
            new StoreManagerScreen(store);
        }
    }
	
}
