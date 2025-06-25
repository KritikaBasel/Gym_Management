/**
 * Write a description of class RegularMember here.
 *
 * @author (Kritika)
 * @version (a version number or a date)
 */
public class RegularMember extends GymMember

{  //initializing instance variable
    private final int attendanceLimit;//constant
    private boolean isEligibleForUpgrade;
    private String removalReason;
    private String referralSource;
    private String plan;
    private double price;
   
   //Creating Constructor 
   public RegularMember(int id,String name,String location,String phone,String email,String gender,String DOB,String membershipStartDate,String referralSource)
     {
         super(id,name,location,phone,email,gender,DOB,membershipStartDate);
         this.referralSource=referralSource;
         this.isEligibleForUpgrade=false;
         this.attendanceLimit=30;
         this.plan= "Basic";
         this.price=6500;
         this.removalReason="";
     }
        //getter method
    public String getReferralSource(){
         return this.referralSource;
     }
     
    public boolean getIsEligibleForUpgrade(){
         return this.isEligibleForUpgrade;
     }
     
    public String getRemovalReason(){
         return this.removalReason;
     }
     
    public int getAttendanceLimit(){
         return this.attendanceLimit;
     }
     
    public String getPlan(){
         return this.plan;
     }
     
    public double getPrice(){
         return this.price;
     }
  
     
     //attendance & loyalty points
     @Override
     public void markAttendance(){
         attendance=attendance+1;
         loyaltyPoints=loyaltyPoints+5;
         System.out.println("the attendance is"+attendance);
         System.out.println("the loyaltyPoints is"+loyaltyPoints);
     }
     
     // plan's price
     public double getPlanPrice(String plan){
         switch(plan.toLowerCase())
         {
             case "basic":
                 return 6500;
                 
             case "standard":
                 return 8500;
                 
             case "deluxe":
                 return 10500;
                 
             default:
                 System.out.println("invalid plan"+plan);
                 return -1;
         
     }
    }
    
     //upgrade from the current plan
     public String upgradePlan(String nPlan){
         if(attendance<this.attendanceLimit){
             return "Cannot upgrade the current because of low attendance";
         }
         
         if(nPlan.equalsIgnoreCase(plan)){
             return "Cannot upgrade cause you are subscribed to the same membership";
         }
         
         double nPrice=getPlanPrice(nPlan);
         
         if(nPrice ==-1){
             return "The entered plan not found";
         }
         
        if (nPrice <= this.price) {
            return "Cannot upgrade to same \n or lower plans.";
        }
         //for the upgrade
         this.plan=nPlan;
         this.price=nPrice;
         return "Sucessfully updated the membership!!";
        }
     
     //Remove the membership
     public void revertRegularMember(String removalReason){
         //calling parent class methos
         super.resetValue();
         
         this.isEligibleForUpgrade=false;
         this.plan="basic";
         this.price=6500;
         this.removalReason=removalReason;
         //printing the reason
         System.out.println("this account has been reverted because"+removalReason);
         
     }
     
     //Display all the data
     public void display(){
         super.display();//firstly cally parent class method using super keyword
         System.out.println("The referral source is: "+getReferralSource());
         System.out.println("The plan's type is: "+getPlan());
         System.out.println("The price is: "+getPrice());
         
         if(!removalReason.isEmpty()){
             System.out.println("The removal reason is: "+getRemovalReason());
         }
     }      
}
