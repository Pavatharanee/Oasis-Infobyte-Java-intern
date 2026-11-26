import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserAuth auth = new UserAuth();
        ReservationSystem system = new ReservationSystem();

        System.out.println("=========================================");
        System.out.println("    ONLINE RESERVATION SYSTEM");
        System.out.println("=========================================");

        System.out.print("Enter Username: ");
        String username = scanner.nextLine();

        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        if (!auth.login(username, password)) {
            System.out.println("\nInvalid credentials! Access denied.");
            scanner.close();
            return;
        }

        System.out.println("\nlogin Successful! Welcome, " + username + "!");

        int choice = 0;
        while (choice != 4) {
            System.out.println("\n--- RESERVATION MENU ---");
            System.out.println("1. Book Ticket");
            System.out.println("2. View Ticket (PNR)");
            System.out.println("3. Cancel Ticket");
            System.out.println("4. Exit");
            System.out.print("Choose an option (1-4): ");

            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Passenger Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Train Number (e.g., 12635 / 12627): ");
                    String trainNo = scanner.nextLine();
                    String trainName = getTrainName(trainNo);
                    System.out.println("Train Name (Auto-filled): " + trainName);

                    System.out.print("Class Type (SL / 3A / 2A / CC): ");
                    String classType = scanner.nextLine();

                    System.out.print("Date of Journey (DD-MM-YYYY): ");
                    String date = scanner.nextLine();

                    System.out.print("From Station: ");
                    String from = scanner.nextLine();

                    System.out.print("To Station: ");
                    String to = scanner.nextLine();

                    system.bookTicket(name, age, trainNo, trainName, classType, date, from, to);
                    break;

                case 2:
                    System.out.print("Enter PNR Number: ");
                    int searchPnr = scanner.nextInt();
                    Reservation found = system.getTicket(searchPnr);
                    if (found != null) {
                        System.out.println(found);
                    } else {
                        System.out.println("No ticket found for PNR " + searchPnr);
                    }
                    break;

                case 3:
                    System.out.print("Enter PNR Number to Cancel: ");
                    int cancelPnr = scanner.nextInt();
                    scanner.nextLine();
                    Reservation toCancel = system.getTicket(cancelPnr);
                    if (toCancel != null) {
                        System.out.println(toCancel);
                        System.out.print("Confirm cancellation? Type YES to confirm: ");
                        String confirm = scanner.nextLine();
                        if (confirm.equalsIgnoreCase("YES")) {
                            system.cancelTicket(cancelPnr);
                        } else {
                            System.out.println("Cancellation aborted.");
                        }
                    } else {
                        System.out.println("PNR " + cancelPnr + " not found!");
                    }
                    break;

                case 4:
                    System.out.println("Thank you for using Online Reservation System. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice! Enter 1 to 4.");
            }
        }
        scanner.close();
    }

    private static String getTrainName(String trainNo) {
        switch (trainNo) {
            case "12635": return "Vaigai Superfast Express";
            case "12627": return "Karnataka Express";
            case "12605": return "Pallavan Superfast Express";
            default: return "Special Express (" + trainNo + ")";
        }
    }
}