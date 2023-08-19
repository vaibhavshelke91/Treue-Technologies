import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class App extends Context {

    private static final String TAG = "App";
    private File dataFile = new File("db.txt");
    private Scanner sc = new Scanner(System.in);
    private User loggedUser=null;
    private List<ParkingSpot> allParkingSpots=ParkingSpot.getAllParkingSpot();

    @Override
    public void start() throws IOException {
        if (!dataFile.exists()) {
            dataFile.createNewFile();
        }
        drawResource();

    }

    @Override
    public void searchSpot() {
       System.out.println("\n\n\t\tSearch Parking Spots");
       System.out.print("\n\tEnter Spot number to search (1-20) : ");
       int pNo=sc.nextInt();
       for(int i=0;i<allParkingSpots.size();i++){
        ParkingSpot ps=allParkingSpots.get(i);
        if((ps!=null && ps.getNumber()==pNo)){
            System.out.println("\n\t Parking Number : "+ps.getNumber());
            System.out.println("\n\tParking Name : "+ps.getName());
            if(ps.isBooked()){
                System.out.println("\n\tSorry ! This Spot is not available for booking (press any key to go back) : ");
                sc.next();
                showDashboard(loggedUser);
                return;
            }
            System.out.print("\n\tThis Parking Spot is Available for Book, Do you want to book now ? (y/n) : ");
            char ch=sc.next().charAt(0);
            switch (ch){
                case 'y':{
                    bookSpot(i);
                    break;
                }
                case 'n':{
                    showDashboard(loggedUser);
                    break;
                }
            }
        }

       }

    }

    @Override
    public void bookSpot(int number) {
        ParkingSpot sp=allParkingSpots.get(number);
        sp.setBooked(true);
        sp.setBookedBy(loggedUser.getFirstName());
        sp.setBookedEmail(loggedUser.getEmail());
        System.out.println("\n\tSuccessfully Booked !");
        showDashboard(loggedUser);
    }

    @Override
    public void availableSpot() {
    
        for (int i = 0; i < allParkingSpots.size(); i++) {
            ParkingSpot spot=allParkingSpots.get(i);
            if(!spot.isBooked()){
                System.out.println("\n\t Spot Number : "+spot.getNumber()+"\t"+spot.getName());
            }
        }
        System.out.print("\n\tEnter any key to go back : ");
        sc.next();
        showDashboard(loggedUser);
    }

    @Override
    public void registerUser() {
        System.out.println("\n\n\tRegister New User");
        System.out.print("\n\tEnter Your First Name : ");
        String firstName = sc.next();
        System.out.print("\n\tEnter Your Last Name : ");
        String lastName = sc.next();
        System.out.print("\n\tEnter Your Email Address : ");
        String email = sc.next();
        System.out.print("\n\tEnter Your Mobile No : ");
        long number = sc.nextLong();
        System.out.print("\n\tEnter Your Password : ");
        String password=sc.next();
       
        User user = new User(firstName, lastName, number, email,password);
        FileUtil fileUtil=new FileUtil();
        if(fileUtil.append(user)){
            System.out.println("\n\tRegistration Successfull !");
            System.out.println("\n\t1.Login \t\t2.Main Menu");
            int ch=sc.nextInt();
            switch (ch){
                case 0:loginUser();break;
                case 1:drawResource();break;
                default :drawResource();
            }
            drawResource();
        }else{
            System.out.println("\n\tSomething Went Error !");

        }

    }

    @Override
    public void loginUser() {
        System.out.println("\n\n\tLogin");
        System.out.print("\n\tEnter Your Email : ");
        String email=sc.next();
        System.out.print("\n\tEnter Your Password : ");
        String password=sc.next();
        FileUtil fileUtil=new FileUtil();
        User user=fileUtil.isUserAvailable(email,password);
        if(user==null){
            System.out.println("\n\tInvalid email or Password");
            System.out.println("\n\t1.Login again \t\t2.Main Menu");
            int ch=sc.nextInt();
            switch(ch){
                case 1:loginUser();break;
                case 2:drawResource();break;
                default :drawResource();
            }
        }else{
            System.out.println("\n\tSuccessfully Logged in !");
            loggedUser=user;
            showDashboard(user);
        }
    }

    @Override
    public void confirm() {

    }

    @Override
    public void myAccount(){
        System.out.println("\n\n\t\t My Account");
        System.out.println("\n\tFirst Name : "+loggedUser.getFirstName());
        System.out.println("\n\tLast Name : "+loggedUser.getLastName());
        System.out.println("\n\tEmail : "+loggedUser.getEmail());
        System.out.println("\n\tMobile No : "+loggedUser.getMobileNumber());
        System.out.print("\n\n\tEnter Any Key to go Back : ");
        sc.next();
        showDashboard(loggedUser);
    }

    private void myBooking(){
        for (ParkingSpot parkingSpot : allParkingSpots) {
            if(parkingSpot.getBookedEmail()==loggedUser.getEmail()){
                System.out.println("Your Booked Spot No : "+parkingSpot.getNumber());
            }
        }
        showDashboard(loggedUser);
    }

    private void showDashboard(User user){
        System.out.println("\n\n\t\tWelcome, "+user.getFirstName());
        System.out.println("\n\t1.Search Parking Spot");
        System.out.println("\n\t2.Check Parking Availability");
        System.out.println("\n\t3.Check My Booking");
        System.out.println("\n\t4.My Account");
        System.out.println("\n\t5.Log out");
        System.out.print("Enter your Choice here : ");
        int ch=sc.nextInt();
        switch(ch){
            case 1:{
                searchSpot();
                break;
            }
            case 2:{
                availableSpot();
                break;
            }
            case 3:{
                myBooking();
                break;
            }
            case 4:{
                myAccount();
                break;
            }
            case 5:{
                loggedUser=null;
                drawResource();
                break;
            }
            default:{
                System.out.println("\n\tInvalid Option !");
            }
        }
    }

    private void drawResource() {

        System.out.println("\n\n\t\t\tWelcome To Online Parking System");
        System.out.println("\t1.Login User");
        System.out.println("\t2.New User ? Register here");
        System.out.println("\t3.Exit System ");
        System.out.print("\tEnter Your Choice here : ");

        int ch = sc.nextInt();
        switch (ch) {
            case 1: {
                loginUser();
                break;
            }
            case 2: {
                registerUser();
                break;
            }
            case 3: {
                System.exit(0);
                break;
            }

            default: {
                System.out.println("Invalid selection please try again !");
                drawResource();
            }
        }
    }

}
