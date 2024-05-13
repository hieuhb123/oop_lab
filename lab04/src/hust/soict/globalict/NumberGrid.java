package hust.soict.globalict;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.*;

public class NumberGrid extends JFrame{
    private JButton[] btnNumbers = new JButton[10];
    private JButton btnDelete, btnReset;
    private JTextField tfDisplay;
    public NumberGrid(){
        tfDisplay = new JTextField();
        tfDisplay.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

        JPanel panelBottons = new JPanel(new GridLayout(4, 3));
        addButtons(panelBottons);

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(tfDisplay, BorderLayout.NORTH);
        cp.add(panelBottons, BorderLayout.CENTER);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Number Grid");
        this.setSize(200, 200);
        this.setVisible(true);
    }
    private void addButtons(JPanel panelBottons) {
        ButtonListener btnListener = new ButtonListener();
        for(int i = 1; i <= 9 ; i++){
            btnNumbers[i] = new JButton(i+"");
            panelBottons.add(btnNumbers[i]);
            btnNumbers[i].addActionListener(btnListener);
        }
        btnDelete = new JButton("DEL");
        panelBottons.add(btnDelete);
        btnDelete.addActionListener(btnListener);

        btnNumbers[0] = new JButton(0+"");
        panelBottons.add(btnNumbers[0]);
        btnNumbers[0].addActionListener(btnListener);

        btnReset = new JButton("C");
        panelBottons.add(btnReset);
        btnReset.addActionListener(btnListener);
    }

    public static void main(String[] args) {
        new NumberGrid();
    }

    private class ButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String button = e.getActionCommand();
            if(button.charAt(0) >= '0' && button.charAt(0) <= '9')
                tfDisplay.setText(tfDisplay.getText() + button);    
            else if(button.equals("DEL")){
                tfDisplay.setText(tfDisplay.getText().substring(0, tfDisplay.getText().length() - 1)); 
            }   
            else{
                tfDisplay.setText("");
            }    
        }
    }
}
