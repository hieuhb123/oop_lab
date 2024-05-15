package hust.soict.globalict.aims.screen.manager;

import java.awt.*;

import javax.swing.*;
import java.awt.event.*;

public class playScreen {
	JDialog dialog;
	public playScreen(String title) {
		dialog = new JDialog((Frame)null, "Playing Media", true);
		dialog.setLayout(new BorderLayout());
		dialog.setSize(400,250);
		dialog.setLocationRelativeTo(null);
		
		JLabel message = new JLabel("You are watching " + title);
		message.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton buttonBack = new JButton("Back");
		buttonBack.addActionListener(new btnBack());
		
		JLabel image = new JLabel();
		image.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panelButton = new JPanel();
		panelButton.setLayout(new FlowLayout(FlowLayout.CENTER));
		panelButton.add(buttonBack);
		dialog.add(message, BorderLayout.NORTH);
		dialog.add(image, BorderLayout.CENTER);
		dialog.add(panelButton, BorderLayout.SOUTH);
		
		dialog.setVisible(true);
	}
	
	private class btnBack implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			dialog.dispose();
		}
	}
}
