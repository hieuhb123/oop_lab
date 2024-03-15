import java.util.Scanner;

public class ex63 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();

        for (int i = 1; i <= t; ++i) {
            for (int j = 1; j <= 2 * t - 1; ++j) {
                if (j >= t - i + 1 && j <= t + i - 1)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.print("\n");
        }
    }
}