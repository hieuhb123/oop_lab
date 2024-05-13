package hust.soict.globalict;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AWTAccumulator extends Frame {
    private TextField tfInput;
    private TextField tfOutput;
    private int sum = 0;

    public AWTAccumulator(){
        this.setLayout(new GridLayout(2, 2));

        this.add(new Label("Enter an Interger: "));

        this.tfInput = new TextField(10);
        this.add(tfInput);
        tfInput.addActionListener(new TFInputListener());

        this.add(new Label("The Accumulated Sum is: "));

        this.tfOutput = new TextField(10);
        tfOutput.setEditable(false);
        this.add(tfOutput);

        this.setTitle("AWT Accumulator");
        this.setSize(350, 120);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new AWTAccumulator();
    }

    private class TFInputListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            int numberInt = Integer.parseInt(tfInput.getText());
            sum += numberInt;
            tfInput.setText("");
            tfOutput.setText(sum + "");
        }
    }

}
