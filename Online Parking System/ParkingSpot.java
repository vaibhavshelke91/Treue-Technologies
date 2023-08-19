import java.util.ArrayList;
import java.util.List;

public class ParkingSpot {

    private String name;
    private int number;
    private boolean isBooked=false;
    private String bookedBy;
    private String bookedEmail;

    public String getBookedBy() {
        return bookedBy;
    }
    public String getBookedEmail() {
        return bookedEmail;
    }
    public boolean isBooked() {
        return isBooked;
    }
    public void setBooked(boolean isBooked) {
        this.isBooked = isBooked;
    }
    public void setBookedBy(String bookedBy) {
        this.bookedBy = bookedBy;
    }
    public void setBookedEmail(String bookedEmail) {
        this.bookedEmail = bookedEmail;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public int getNumber() {
        return number;
    }

    public ParkingSpot(int number,String name){
        this.number=number;
        this.name=name;
    }
    public ParkingSpot(){

    }
    
    public static List<ParkingSpot> getAllParkingSpot(){
        ArrayList<ParkingSpot> parkingSpots=new ArrayList<>();
        for (int i = 0 ;i<=20;i++){
           parkingSpots.add(new ParkingSpot(i+1, "Parking Spot "+i+1));
        }
        return parkingSpots;
    }
}
