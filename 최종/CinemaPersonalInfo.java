package miniproject2;

//package miniproject1;

public class CinemaPersonalInfo {    
    public String userID;    
    private String userPW;
    private int reservationNumber;

    public String getUserID(){
        return userID;
    }
    public void setUserID(String userID){
        this.userID = userID;
    }
    public String getUserPW(){
        return userPW;
    }
    public void setUserPW(String userPW){
        this.userPW = userPW;
    }
    public int getReservationNumber(){
        return reservationNumber;
    }
    public void setReservationNumber(int reservationNumber){
        this.reservationNumber = reservationNumber;
    }
    public void showPersonalInfo(){
        System.out.println("ID: " + this.userID);
        System.out.println("PW: "+ this.userPW);
        System.out.println("Reservation Number: "+ this.reservationNumber);
    }
}
