import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
    private String type;
    private double amount;
    private String timestamp;

    public Transaction(String type , double amount) {
        this.type = type;
        this.amount = amount;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        this.timestamp = LocalDateTime.now().format(dtf);
    }
    @Override 
    public String toString(){
        return "[" + timestamp + "] " + type + " : Rs. " + amount;
    }
}