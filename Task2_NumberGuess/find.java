import java.util.Random;
import java.util.Scanner;
public class find {
    public static void main(String[] args){

        //Hidden number
        Random rand=new Random();
        Scanner sc=new Scanner(System.in);

        int round =1;
        String playAgain;

        do{
            System.out.println("Round " + round);
            System.out.println("Select Difficulty: 1. Easy (1-50) | 2. Medium (1-100) | 3. Hard (1-200)");
            System.out.println("Enter choice (1/2/3): ");
            int choice = sc.nextInt();

            int maxRange = 100;
            int maxAttempts = 7;

            switch (choice) {
                case 1:
                    maxRange = 50;
                    maxAttempts = 10;
                    break;
                    case 2:
                        maxRange = 100;
                        maxAttempts = 7;
                        break;
                    case 3:
                        maxRange = 200;
                        maxAttempts = 5;
                        break;
                    default:
                        System.out.println("Invalid choice! Setting Medium difficulty.");
            }
        int hiddenNum = rand.nextInt(maxRange)+1;
        int attempts=0;
        boolean isWon=false;
                
                
        
        //user input
        while (attempts < maxAttempts ) {
        System.out.print("1 to 100 Think any number:");
        int thethinknum=sc.nextInt();
        attempts++;

        //check panrom
        if(thethinknum>hiddenNum){
            System.out.println("Too High! Attempts left: " + (maxAttempts - attempts));
        }else if(thethinknum<hiddenNum){
            System.out.println("Too Low! Attempts left: " + (maxAttempts - attempts));
        }else{
            System.out.println("You guessed it! " + attempts + "attempts!" );
            isWon=true;
            break;
        }

        }
        if (!isWon){
            System.out.println("You didn't guess the number. The number was: " + hiddenNum);
        } 
        System.out.println ("Do you want to play again? (yes/no)");
        playAgain = sc.next();
        round++;
    }
     while (playAgain.equalsIgnoreCase("yes"));

     System.out.println("Thanks for playing!");
     sc.close(); 
    }
}