public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();

        // Adding sample user accounts
        bank.addAccount(new Account("user1", "1234" , 5000.0));
        bank.addAccount(new Account("user2", "5678" , 3000.0));

        // Starting the ATM
        ATM atm = new ATM(bank);
        atm.start();
    }
}