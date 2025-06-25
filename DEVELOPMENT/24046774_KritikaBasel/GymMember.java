
/**
 * Write a description of class GymMember here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class GymMember
{// initializing the instance variable
    protected int id;
    protected String name;
    protected String location;
    protected String phone;
    protected String email;
    protected String gender;
    protected String DOB;
    protected String membershipStartDate;

    //initializing the values
    protected int attendance;
    protected double loyaltyPoints;
    protected boolean activeStatus;

    //constructor
    public GymMember(int id,String name,String location,String phone,String email,String gender,String DOB,String membershipStartDate)
    {
        this.id=id;//passing the value
        this.name=name;
        this.location=location;
        this.phone=phone;
        this.email=email;
        this.gender=gender;
        this.DOB=DOB;
        this.membershipStartDate=membershipStartDate;
        this.attendance=0;
        this.loyaltyPoints=0d;
        this.activeStatus=false;

    }
    //Encapsulation
    //getter method
    public int getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public String getLocation(){
        return this.location;
    }

    public String getPhone(){
        return this.phone;
    }

    public String getEmail(){
        return this.email;
    }

    public String getGender(){
        return this.gender;
    }

    public String getDOB(){
        return this.DOB;
    }

    public String getMembershipStartDate(){
        return this.membershipStartDate;
    }

    public int getAttendance(){
        return this.attendance;
    }

    public double getLoyaltyPoints(){
        return this.loyaltyPoints;
    }

    public boolean getActiveStatus(){
        return this.activeStatus;
    }

    //abstract method

    public abstract  void markAttendance();

    //active membership
    public void activateMembership( ){
        if (!activeStatus)//deactivate
        {
            this.activeStatus=true;
            System.out.println("The membership is activated");
        }
        else
        {
            System.out.println("The membership is already renewed");
        }
    }

    //deactivate membership
    public void deactivateMembership(){
        if(activeStatus==true)
        {
            this.activeStatus=false;
            System.out.println("The membership is disactivated");
        }
        else
        {
            System.out.println("the membership has already been disactivated");
        }
    }

    //reset values
    public void resetValue(){
        loyaltyPoints=0.0;
        attendance=0;
        activeStatus=false;
    }

    //for all to print 
    public void display(){
        System.out.println("The id is:"+getId());
        System.out.println("The name is:"+getName());
        System.out.println("The location is:"+getLocation());
        System.out.println("The phonenumber is:"+getPhone());
        System.out.println("The email is:"+getEmail());
        System.out.println("The gender is:"+getGender());
        System.out.println("The date of birth is:"+getDOB());
        System.out.println("The membershipStartDate is:"+getMembershipStartDate());
        System.out.println("The attendance is:"+getAttendance());
        System.out.println("The loyalty points is:"+getLoyaltyPoints());
        System.out.println("The active status is:"+getActiveStatus());
    }

}
