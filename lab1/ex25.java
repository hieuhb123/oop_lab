import java.util.Scanner;
public class ex25 {
	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Enter the number 1: ");
	        double a = scanner.nextDouble();
	        System.out.print("Enter the number 2: ");
	        double b = scanner.nextDouble();
	        double sum = a+b;
	        double difference = a-b;
	        double mul = a*b;
	        System.out.println("Sum: "+ sum);
	        System.out.println("Difference :"+difference);
	        System.out.println("Product: " + mul);

	        if (b == 0) {
	            System.out.println("The divisor is not valid");
	        }
	        else {
	            double quotient = a/b;
	            System.out.println("Quotient: " + quotient);
	        }
	    }
}