import java.util.Scanner;
import java.util.Arrays;

public class ex65 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter the number of elements: ");
		int n = scanner.nextInt();
		int arr[] = new int[n];
		System.out.print("Enter array: ");
		for (int i = 0; i < n; i++){
			arr[i] = scanner.nextInt();
		}
		scanner.close();
		
		Arrays.sort(arr);
		int sum = 0;
		for (int i = 0; i < n; i++) sum += arr[i];
		
		System.out.print("Sorted array: ");
		for (int i = 0; i < n; i++) System.out.print(arr[i] + " ");
		
		System.out.println("\nSum = " + sum + " Average = " + sum / n);
		
	}

}