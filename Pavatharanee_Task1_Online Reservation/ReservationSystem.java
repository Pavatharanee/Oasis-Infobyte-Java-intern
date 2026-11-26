import java.util.HashMap;
import java.util.Map;

public class ReservationSystem {
    private Map<Integer, Reservation> bookings;
    private int nextPnr;

    public ReservationSystem() {
        bookings = new HashMap<>();
        nextPnr = 1001;
    }

    public int bookTicket(String passengerName, int age, String trainNumber,
                          String trainName, String classType, String journeyDate,
                          String fromStation, String toStation) {
        int pnr = nextPnr++;
        Reservation res = new Reservation(pnr, passengerName, age, trainNumber,
                                          trainName, classType, journeyDate,
                                          fromStation, toStation);
        bookings.put(pnr, res);
        System.out.println("\nTicket Booked Successfully! Your PNR is: " + pnr);
        System.out.println(res);
        return pnr;
    }

    public Reservation getTicket(int pnr) {
        return bookings.get(pnr);
    }

    public boolean cancelTicket(int pnr) {
        if (bookings.containsKey(pnr)) {
            bookings.remove(pnr);
            System.out.println("Ticket with PNR " + pnr + " has been cancelled.");
            return true;
        } else {
            System.out.println("PNR " + pnr + " not found!");
            return false;
        }
    }
}