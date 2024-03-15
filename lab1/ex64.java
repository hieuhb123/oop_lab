import java.util.Scanner;

public class ex64 {
    static boolean leapYear(int year) {
        if (year % 400 == 0) return true;
        else if (year % 100 == 0) return false;
        else return year % 4 == 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the month: ");
        String str_month = scanner.nextLine().trim(); // Trim to remove any leading or trailing whitespaces
        System.out.println("Enter the year: ");
        int year = scanner.nextInt();
        int daysInMonth;

        if (str_month.equals("Jan") || str_month.equals("Jan.") || str_month.equals("January") || str_month.equals("1")
                || str_month.equals("Mar") || str_month.equals("Mar.") || str_month.equals("March") || str_month.equals("3")
                || str_month.equals("May") || str_month.equals("May.") || str_month.equals("5") || str_month.equals("July")
                || str_month.equals("7") || str_month.equals("Jul") || str_month.equals("August") || str_month.equals("Aug")
                || str_month.equals("Aug.") || str_month.equals("8") || str_month.equals("October") || str_month.equals("Oct.")
                || str_month.equals("Oct") || str_month.equals("10") || str_month.equals("December") || str_month.equals("Dec")
                || str_month.equals("Dec.")) {
            daysInMonth = 31;
        } else if (str_month.equals("February") || str_month.equals("Feb") || str_month.equals("Feb.") || str_month.equals("2")) {
            daysInMonth = 28; // Default to 28 days
            if (leapYear(year)) daysInMonth = 29; // Update to 29 days if leap year
        } else {
            daysInMonth = 30;
        }

        System.out.println("Number of days in " + str_month + " " + year + " is " + daysInMonth);
    }
}