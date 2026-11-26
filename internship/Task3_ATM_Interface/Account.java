import java.util.ArrayList;
import java.util.List;

public class Account {
    private String userId;
    private String pin;
    private double balance;
    private List<Transaction> history;

    public Account(String userId, String pin, double initialBalance) {
        this.userId = userId;
        this.pin = pin;
        this.balance = initialBalance;
        this.history = new ArrayList<>();
    }
    public String getUserId() {
        return userId;
    }

    public boolean validatePin(String inputPin){
        return this.pin.equals(inputPin);
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            history.add(new Transaction("Deposit", amount));
            System.out.println("Successfully deposited Rs. " + amount);
        } else {
            System.out.println("Deposite amount must be positive.");
        }
        
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            history.add(new Transaction("Withdrawal", amount));
            System.out.println("Successfully withdrew Rs. " + amount);
            return true;
        } else {
            System.out.println("Invalid withdrawl amount or insufficient balance ");
            return false;
        }
    }

    public void addTransferRecord(String type, double amount) {
        history.add(new Transaction(type, amount));
    } 

    public void updateBalance(double amount) {
        this.balance += amount;
    }

    public void printHistory() {
        System.out.println("\n--- Transaction History (" + userId + ") ---");
        if (history.isEmpty()) {
            System.out.println("No transactions found.");
        }else {
            for (Transaction transaction : history) {
                System.out.println(transaction);
            }
        }
    }


}