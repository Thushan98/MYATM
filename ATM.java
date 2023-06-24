import java.util.Scanner;

public class ATM {
    private static Account account;

    public static void main(String[] args) {
        account = new Account("123456789", "1234", 1000.0);

        boolean loggedIn = login();
        if (loggedIn) {
            handleMenuOptions();
        } else {
            System.out.println("Login failed. Exiting the ATM.");
        }
    }

    public static boolean login() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your Account Number: ");
        String accountNumber =sc.nextLine();

        System.out.println("Enter your PIN Number: ");
        String pin =sc.nextLine();

        if (account.getAccountNumber().equals(accountNumber) && account.validatePin(pin)) {
            System.out.println("Login successful. Welcome!");
            return true;
        } else {
            System.out.println("Invalid account number or PIN.");
            return false;
        }
    }

    public static void handleMenuOptions() {
        boolean quit = false;
        while (!quit) {
            OptionMenu.displayMenu();
            int option = OptionMenu.getOptionFromUser();

            switch (option) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    withdrawMoney();
                    break;
                case 3:
                    depositMoney();
                    break;
                case 4:
                    quit = true;
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public static void checkBalance() {
        double balance = account.getBalance();
        System.out.println("Your balance is: " + balance);
    }

    public static void withdrawMoney() {
        double amount = OptionMenu.getAmountFromUser();
        account.withdraw(amount);
    }

    public static void depositMoney() {
        double amount = OptionMenu.getAmountFromUser();
        account.deposit(amount);
    }
}
