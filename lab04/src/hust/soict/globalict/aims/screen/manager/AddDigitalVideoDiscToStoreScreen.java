package hust.soict.globalict.aims.screen.manager;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.store.Store;

public class AddDigitalVideoDiscToStoreScreen extends Screen implements ActionListener{
	private JTextField titleInput, categoryInput, costInput, directorInput, lengthInput;
	public AddDigitalVideoDiscToStoreScreen(Store store) {
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
	    
	    JLabel directorLabel = new JLabel("Enter director:");
	    directorInput = new JTextField(20);
	    gbc.gridy++;
	    addComponents(center, directorLabel, directorInput, gbc);

	    // Cost components
	    JLabel costLabel = new JLabel("Enter cost:");
	    costInput = new JTextField(20);
	    gbc.gridy++;
	    addComponents(center, costLabel, costInput, gbc);

	    // Authors components
	    JLabel lengthLabel = new JLabel("Enter length:");
	    lengthInput = new JTextField(20);
	    gbc.gridy++;
	    addComponents(center, lengthLabel, lengthInput, gbc);

	    // Submit button
	    JButton submitButton = new JButton("Submit");
	    submitButton.setPreferredSize(new Dimension(100, 30));
	    gbc.gridy++;
	    gbc.fill = GridBagConstraints.HORIZONTAL;
	    center.add(submitButton, gbc);

	    // Add action listener to the submit button
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
        if (action.equals("Add Book")){
        	dispose();
            new AddBookToStoreScreen(store);
        }
        else if (action.equals("Add CD")){
            dispose();
            new AddDigitalVideoDiscToStoreScreen(store);
        }
        else if (action.equals("Submit")){
        	String title = titleInput.getText();
            String category = categoryInput.getText();
            float cost = Float.parseFloat(costInput.getText());
            String artist = directorInput.getText();
            int length = Integer.parseInt(lengthInput.getText());
            DigitalVideoDisc DVD = new DigitalVideoDisc(1, title, category, artist, length, cost);
            store.addMedia(DVD);
            JOptionPane.showMessageDialog(this, "The CD has been added successfully!!!");
            dispose();
            new StoreManagerScreen(store);

        }
        else{
            dispose();
            new StoreManagerScreen(store);
        }
    }
}
