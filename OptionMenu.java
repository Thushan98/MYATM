import java.util.Scanner;

public class OptionMenu {
    public static void displayMenu() {
        System.out.println("***** ATM MENU *****");
        System.out.println("1. Check Balance");
        System.out.println("2. Withdraw Money");
        System.out.println("3. Deposit Money");
        System.out.println("4. Quit");
    }

    public static int getOptionFromUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter option: ");
        return scanner.nextInt();
    }

    public static double getAmountFromUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter amount: ");
        return scanner.nextDouble();
    }
}
