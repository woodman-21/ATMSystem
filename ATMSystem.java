import java.util.Scanner;

public class ATMSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ATM myATM = new ATM(10000.00, 1234); // starting balance & PIN

        System.out.println("\n==============================");
        System.out.println("   WELCOME TO JAVA ATM SYSTEM");
        System.out.println("==============================\n");

        System.out.print("Enter your PIN: ");
        int enteredPIN = sc.nextInt();

        if (!myATM.verifyPIN(enteredPIN)) {
            System.out.println("Incorrect PIN. Access Denied.");
        }

        System.out.println("PIN Verified. Access Granted!\n");

        int choice;

        do {
            System.out.println("\n==============================");
            System.out.println("          ATM MENU");
            System.out.println("==============================");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.println("==============================");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    myATM.checkBalance();
                    break;

                case 2:
                    System.out.print("Enter deposit amount: Rs. ");
                    double dep = sc.nextDouble();
                    myATM.deposit(dep);
                    break;

                case 3:
                    System.out.print("Enter withdrawal amount: Rs. ");
                    double wd = sc.nextDouble();
                    myATM.withdraw(wd);
                    break;

                case 4:
                    System.out.println("\nThank you for using ATM. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 4);

        sc.close();
    }
}


class ATM {
    private double balance;
    private int pin;

    // Constructor
    ATM(double balance, int pin) {
        this.balance = balance;
        this.pin = pin;
    }

    // Check Balance
    void checkBalance() {
        System.out.println("\nCurrent Balance: Rs. " + balance);
    }

    // Deposit Money
    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Rs. " + amount + " deposited successfully.");
            System.out.println("Updated Balance: Rs. " + balance);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    // Withdraw Money
    void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount!");
        } else if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else {
            balance -= amount;
            System.out.println("Rs. " + amount + " withdrawn successfully.");
            System.out.println("Remaining Balance: Rs. " + balance);
        }
    }

    // PIN Verification
    boolean verifyPIN(int enteredPIN) {
        return this.pin == enteredPIN;
    }
}