public class Reservation {
    private int pnr;
    private String passengerName;
    private int age;
    private String trainNumber;
    private String trainName;
    private String classType;
    private String journeyDate;
    private String fromStation;
    private String toStation;

    public Reservation(int pnr, String passengerName, int age, String trainNumber, String trainName, String classType, String journeyDate, String fromStation, String toStation) {
        this.pnr = pnr;
        this.passengerName = passengerName;
        this.age = age;
        this.trainNumber = trainNumber;
        this.trainName = trainName;
        this.classType = classType;
        this.journeyDate = journeyDate;
        this.fromStation = fromStation;
        this.toStation = toStation;

    }
    public int getpnr()  {
        return pnr;
    }

    @Override 
    public String toString() {
        return "\n---------------------------------------" +
               "\nPNR Number     :  " + pnr +
               "\nPassenger      :  " + passengerName + "(Age: " + age + ")" +
               "\nTrain          :  " + trainNumber   + " - " + trainName +
               "\nClass & Date   :  " + classType     + " | " + journeyDate +
               "\nRoute          :  " + fromStation   + " -> " + toStation +
               "\n---------------------------------------";
    }


}