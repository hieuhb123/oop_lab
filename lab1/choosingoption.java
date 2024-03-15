import javax.swing.JOptionPane;

public class choosingoption {
    public static void main(String[] args) {
        int option = JOptionPane.showConfirmDialog(null,"Yes", 
        "No", JOptionPane.YES_NO_OPTION);

        JOptionPane.showMessageDialog(null, "You've chosen: "
        + (option==JOptionPane.YES_OPTION?"Yes":"No"));

        System.exit(0);
    }
}