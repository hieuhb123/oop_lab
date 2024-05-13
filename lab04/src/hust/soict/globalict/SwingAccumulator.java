package hust.soict.globalict;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.*;

public class SwingAccumulator extends JFrame{
    private JTextField tfInput;
    private JTextField tfOutput;
    private int sum = 0;

    public SwingAccumulator(){
        Container cp = getContentPane();

        cp.setLayout(new GridLayout(2, 2));

        cp.add(new JLabel("Enter an Interger: "));

        this.tfInput = new JTextField(10);
        cp.add(tfInput);
        tfInput.addActionListener(new TFInputListener());

        cp.add(new Label("The Accumulated Sum is: "));

        this.tfOutput = new JTextField(10);
        tfOutput.setEditable(false);
        cp.add(tfOutput);

        this.setTitle("Swing Accumulator");
        this.setSize(350, 120);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new SwingAccumulator();
    }

    private class TFInputListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            int numberInt = Integer.parseInt(tfInput.getText());
            sum += numberInt;
            tfInput.setText("");
            tfOutput.setText(sum + "");
        }
    }

}
