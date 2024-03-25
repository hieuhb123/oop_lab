import java.util.Scanner;
public class ex62 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("What's your name?");
        String strName = input.nextLine();
        System.out.println("How old are you?");
        int iAge = input.nextInt();
        System.out.println("How tall are you (m)?");
        double dHeight = input.nextDouble();
        input.close();
        System.out.println("Mrs/Ms. " + strName + ", " + iAge + " years old.\n" + "Your height is " + dHeight + ".");

    }
}