import java.util.Scanner;

public class ATM {
    private Bank bank;
    private Scanner scanner;

    public ATM(Bank bank) {
        this.bank = bank;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("===============================");
        System.out.println("     WELCOME TO JAVA ATM");
        System.out.println("===============================");

        System.out.print("Enter User ID: ");
        String userId = scanner.nextLine();

        System.out.print("Enter PIN: ");
        String pin = scanner.nextLine();

        Account currentUser = bank.authenticate(userId, pin);

        if (currentUser != null) {
            System.out.println("\nLogin Successful! Welcome, " + currentUser.getUserId());
            showMenu(currentUser);
        } else {
            System.out.println("\nInvalid User ID or PIN. Exiting...");
        }
    }

    private void showMenu(Account user) {
        int choice = 0;
        while (choice != 5) {
            System.out.println("\n--- ATM MENU (Balance: Rs. " + user.getBalance() + ") ---");
            System.out.println("1. Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            System.out.print("Choose an option (1-5): ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    user.printHistory();
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmt = scanner.nextDouble();
                    user.withdraw(withdrawAmt);
                    break;
                case 3:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmt = scanner.nextDouble();
                    user.deposit(depositAmt);
                    break;
                case 4:
                    handleTransfer(user);
                    break;
                case 5:
                    System.out.println("Thank you for using Java ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option! Please choose 1 to 5.");
            }
        }
    }

    private void handleTransfer(Account sender) {
        System.out.print("Enter recipient User ID: ");
        String recipientId = scanner.next();
        Account recipient = bank.getAccount(recipientId);

        if (recipient == null) {
            System.out.println("Recipient User ID not found!");
            return;
        }
        if (recipient.getUserId().equals(sender.getUserId())) {
            System.out.println("Cannot transfer to your own account!");
            return;
        }

        System.out.print("Enter amount to transfer: ");
        double amount = scanner.nextDouble();

        if (amount > 0 && amount <= sender.getBalance()) {
            sender.updateBalance(-amount);
            recipient.updateBalance(amount);
            sender.addTransferRecord("Transfer to " + recipientId, amount);
            recipient.addTransferRecord("Transfer from " + sender.getUserId(), amount);
            System.out.println("Successfully transferred Rs. " + amount + " to " + recipientId);
        } else {
            System.out.println("Insufficient balance or invalid amount!");
        }
    }
}