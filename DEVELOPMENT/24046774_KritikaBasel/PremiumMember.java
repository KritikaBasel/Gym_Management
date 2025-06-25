/**
 * Write a description of class PremiumMember here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PremiumMember extends GymMember

{   //instance variable 
    private final double premiumCharge;
    private String personalTrainer;
    private boolean isFullPayment;
    private double paidAmount;
    private double discountAmount;

    //constructor creation
    public PremiumMember(int id,String name,String location,String phone,String email,String gender,String DOB,String membershipStartDate, String personalTrainer)
    {
        super(id,name,location,phone,email,gender,DOB,membershipStartDate);
        this.personalTrainer=personalTrainer;
        premiumCharge=50000;
        paidAmount=0;
        isFullPayment=false;
        discountAmount=0;
    }

    //Getter method
    public double getPremiumCharge(){
        return this.premiumCharge;
    }

    public String getPersonalTrainer(){
        return this.personalTrainer;
    }

    public boolean getIsFullPayment(){
        return this.isFullPayment;
    }

    public double getPaidAmount(){
        return this.paidAmount;
    }

    public double getDiscountAmount(){
        return this.discountAmount;
    }

    //Attendance & loyalty points calculation
    @Override
    public void markAttendance(){
        attendance=attendance+1;
        loyaltyPoints=loyaltyPoints+10;
        System.out.println("the attendance is: "+attendance);
        System.out.println("the loyaltyPoints is: "+loyaltyPoints);
    }

    //Payment of the due amount
    public String payDueAmount( double amount){
        if(isFullPayment==true){
            return "Payment already done!!";
        }
        //new paid amount after inserting the remaining amount
        paidAmount=amount+paidAmount;

        if(paidAmount>premiumCharge){ 
            paidAmount=paidAmount-amount;
            return "EXCEEDS THE LIMIT!!!.\nRequired:"+premiumCharge+"\nAlready Paid Balance:"+paidAmount+"\nPaid Balance"+amount+"\nRemaining:"+(premiumCharge-paidAmount);
                    
        }
        //new isfullpayment if both are same
        isFullPayment=(paidAmount==premiumCharge);
        if(isFullPayment){
            return "Payment Sucessfull:"+paidAmount+"\n No Remaining Balance.";
        }
        else{
            double remaining=premiumCharge-paidAmount;//for the remaining due balance to pay
            return"Payment Sucessfull!\nRemaining balance: "+remaining;
        }
    }

    //to calculate discount if the fullpayment is made
    public String calculateDiscount(){
        if(isFullPayment==true){
            discountAmount= 0.10* premiumCharge;
            return "The given discount is: "+ discountAmount;
        }
        else{
            return "Discount cannot be applied.\n Payment is not complete";
        }
    }

    //to reset the values to default
    public void revertPremiumMember(){
        super.resetValue();

        personalTrainer="";
        isFullPayment=false;
        paidAmount=0;
        discountAmount=0;
        System.out.println("this account has been reverted to default premium membership");
    }

    //Display the parent and chid class output
    public void display(){
        super.display();

        System.out.println("The personal trainer is: "+getPersonalTrainer());
        System.out.println("The paid amount is "+getPaidAmount());
        System.out.println("The full payment is done?? "+getIsFullPayment());

        double remaining=premiumCharge-paidAmount;
        System.out.println("the remaining Amount is: "+remaining);
    }
}
