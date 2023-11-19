import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit of $" + amount + " successful. Current balance: $" + balance);
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal of $" + amount + " successful. Current balance: $" + balance);
            return true;
        } else {
            System.out.println("Insufficient funds. Withdrawal failed.");
            return false;
        }
    }
}

public class ATM {
    private BankAccount userAccount;

    public ATM(BankAccount account) {
        this.userAccount = account;
    }

    public void displayMenu() {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nATM Menu:");
            System.out.println("1.Check Balance\n2.Deposit\n3.Withdraw\n4.Exit\n");
   
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    System.out.print("Enter deposit amount: $");
                    double depositAmount = sc.nextDouble();
                    deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: $");
                    double withdrawAmount = sc.nextDouble();
                    withdraw(withdrawAmount);
                    break;
                case 4:
                    System.out.println("Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again and enter correct choice.");
                    break;
            }
        } while (choice != 4);
    }

    public void checkBalance() {
        System.out.println("Your Current Balance Is: $" + userAccount.getBalance());
    }

    public void deposit(double amount) {
        if (amount > 0) {
            userAccount.deposit(amount);
        } else {
            System.out.println("Invalid deposit.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0) {
            userAccount.withdraw(amount);
        } else {
            System.out.println("Invalid withdrawal.");
        }
    }

    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000); 
        ATM atm = new ATM(userAccount);
        atm.displayMenu();
    }
}
