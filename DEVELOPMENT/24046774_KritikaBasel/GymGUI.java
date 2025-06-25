import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import javax.swing.JTextArea;

/**
 * Write a description of class GymGUI here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class GymGUI implements ActionListener
{//initializing everything outside the constructor
    private JLabel gymMember, memberInfo, gymInfo, id, name, location, phone, trainer, startC;
    private JLabel email, dob, gender, plan, price, paidAmt, premiumPlan, discount, start, referral;
    private JTextField idText, nameText, locationText, premiumPlanText, phoneText, emailText, trainerText;
    private JTextField priceText, paidText, discountText, startText, referralText;
    private JComboBox<String> yearDob, monthDob, dayDob, planYear, planMonth, planDay;
    private JComboBox<String> planC;
    private JRadioButton otherButton, maleButton, femaleButton;
    private ButtonGroup button;
    private JButton clear, readFile, saveFile, display, addRegular, addPremium;
    private JFrame frame,rframe,pframe,readFrame;
    private JPanel panel,rpanel,ppanel;
    private JLabel ptitle,pId,pIdText,pName,pAmt,  pLocation, pPhone, pEmail,pStart, pDob, pGender,pStartText,pActive,pPlan,pAttendance,pLoyal; 
    private JTextField  pNameText, pLocationText ,pPhoneText, pEmailText,pDobText, pGenderText,pAttendText,pActiveText,pPlanText,pLoyalText;
    private JLabel title,rId,rIdText,rName, removal, rLocation, rPhone, rEmail,rStart, rDob, rGender,rStartText,active,rPlan,attendance,removalReason,loyal; 
    private JTextField  rNameText,pAmtText, rLocationText,removalText ,rPhoneText, rEmailText,rDobText, rGenderText,attendText,activeText,rPlanText,removalReasonText,loyalText;
    private JButton markAttendance, activateMembership, deactivateMembership,revertMember,revertRegularMember,revertPremiumMember;
    private JButton pMarkAttendance, pActivateMembership, pDeactivateMembership;
    private JButton upgradePlan, due, discountBtn;
    private FileReader reading;
    private File file;
    private FileWriter writing;
    private JTextArea textArea;
    private File Doc;
    private ArrayList<GymMember> gym = new ArrayList<>(); 

    public GymGUI()//constructor
    {
        //creating new frame
        frame = new JFrame("GYM");
        panel = new JPanel();
        panel.setLayout(null);

        gymMember = new JLabel(" W Gym ");
        gymMember.setFont(new Font("Arial", Font.BOLD, 24));
        gymMember.setBounds(350, 20, 300, 30);
        panel.add(gymMember);

        memberInfo = new JLabel("Member's Info");
        memberInfo.setFont(new Font("Arial", Font.BOLD, 16));
        memberInfo.setBounds(350, 70, 200, 25);
        panel.add(memberInfo);

        // ID label
        id = new JLabel("ID");
        id.setBounds(50, 110, 100, 25);
        panel.add(id);

        idText = new JTextField();
        idText.setBounds(150, 110, 200, 25);
        panel.add(idText);

        // Name label
        name = new JLabel("Name");
        name.setBounds(50, 145, 100, 25);
        panel.add(name);

        nameText = new JTextField();
        nameText.setBounds(150, 145, 200, 25);
        panel.add(nameText);

        // Location
        location = new JLabel("Location");
        location.setBounds(50, 180, 100, 25);
        panel.add(location);

        locationText = new JTextField();
        locationText.setBounds(150, 180, 200, 25);
        panel.add(locationText);

        // Phone
        phone = new JLabel("Phone");
        phone.setBounds(50, 215, 100, 25);
        panel.add(phone);

        phoneText = new JTextField();
        phoneText.setBounds(150, 215, 200, 25);
        panel.add(phoneText);

        // Email
        email = new JLabel("Email");
        email.setBounds(50, 250, 100, 25);
        panel.add(email);

        emailText = new JTextField();
        emailText.setBounds(150, 250, 200, 25);
        panel.add(emailText);

        // Date of Birth
        dob = new JLabel("DOB");
        dob.setBounds(50, 285, 100, 25);
        panel.add(dob);

        String[] year = new String[100];
        for (int i = 0; i < 100; i++) {//using for loop for ot to show the year until 100 years
            year[i] = String.valueOf(1980 + i);
        }
        yearDob = new JComboBox<>(year);
        yearDob.setBounds(150, 285, 70, 25);
        yearDob.insertItemAt("Year", 0);
        yearDob.setSelectedIndex(0);
        panel.add(yearDob);

        String[] month = new String[]{"Month", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};//months list
        monthDob = new JComboBox<>(month);
        monthDob.setBounds(230, 285, 60, 25);
        monthDob.setSelectedIndex(0);
        panel.add(monthDob);

        String[] day = new String[31];//loop for days
        for (int i = 0; i < 31; i++) {
            day[i] = String.valueOf(i + 1);//string
        }
        dayDob = new JComboBox<>(day);
        dayDob.setBounds(300, 285, 60, 25);
        dayDob.insertItemAt("Day", 0);//default in combo box
        dayDob.setSelectedIndex(0);
        panel.add(dayDob);

        //Gender
        gender = new JLabel("Gender");
        gender.setBounds(50, 320, 100, 25);
        panel.add(gender);

        button = new ButtonGroup();
        maleButton = new JRadioButton("Male");
        maleButton.setBounds(150, 320, 60, 25);
        button.add(maleButton);
        panel.add(maleButton);

        femaleButton = new JRadioButton("Female");
        femaleButton.setBounds(220, 320, 70, 25);
        button.add(femaleButton);
        panel.add(femaleButton);

        otherButton = new JRadioButton("Others");
        otherButton.setBounds(300, 320, 80, 25);
        button.add(otherButton);
        panel.add(otherButton);

        gymInfo = new JLabel("Gym Inquiries");
        gymInfo.setFont(new Font("Arial", Font.BOLD, 16));
        gymInfo.setBounds(350, 360, 200, 25);
        panel.add(gymInfo);

        //Membership start date
        start = new JLabel("Membership Start Date");
        start.setBounds(50, 400, 200, 25);
        panel.add(start);

        String[] planYearArray = new String[50];
        for (int i = 0; i < 50; i++) {
            planYearArray[i]= (String.valueOf(2015+i));
        }
        planYear = new JComboBox<>(planYearArray);
        planYear.setBounds(230, 400, 70, 25);
        planYear.insertItemAt("Year", 0);
        planYear.setSelectedIndex(0);
        panel.add(planYear);

        String[] planMonthArray = new String[]{"Month", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
        planMonth = new JComboBox<>(planMonthArray);
        planMonth.setBounds(310, 400, 60, 25);
        planMonth.setSelectedIndex(0);
        panel.add(planMonth);

        String[] planDayArray = new String[32];
        for (int i = 0; i < 31; i++) {
            planDayArray[i] = String.valueOf(i + 1);
        }
        planDay = new JComboBox<>(planDayArray);
        planDay.setBounds(380, 400, 60, 25);
        planDay.insertItemAt("Day", 0);
        planDay.setSelectedIndex(0);
        panel.add(planDay);

        plan = new JLabel("Plan");//plan to select
        plan.setBounds(50, 470, 100, 25);
        panel.add(plan);

        String[] planCombo = new String[]{"Basic", "Standard", "Deluxe"};
        planC = new JComboBox<>(planCombo);
        planC.setBounds(150, 470, 100, 25);
        planC.addActionListener(this);
        panel.add(planC);

        price = new JLabel("Price");//price that had to be field
        price.setBounds(50, 505, 100, 25);
        panel.add(price);

        priceText = new JTextField();
        priceText.setBounds(150, 505, 100, 25);
        priceText.setEditable(false);
        panel.add(priceText);

        premiumPlan = new JLabel("Premium Plan:");
        premiumPlan.setBounds(400, 505, 100, 25);
        panel.add(premiumPlan);

        premiumPlanText = new JTextField("50000");//non editable premium price
        premiumPlanText.setBounds(500, 505, 200, 25);
        premiumPlanText.setEditable(false);
        panel.add(premiumPlanText);
        //discount

        referral = new JLabel("Referral Source");
        referral.setBounds(50, 540, 100, 25);
        panel.add(referral);

        referralText = new JTextField();
        referralText.setBounds(150, 540, 200, 25);
        panel.add(referralText);

        //Trainer 's name
        trainer = new JLabel("Trainers Name:");
        trainer.setBounds(400, 540, 200, 25);
        panel.add(trainer);

        trainerText = new JTextField();
        trainerText.setBounds(500, 540, 150, 25);
        panel.add(trainerText);

        // Buttons
        addRegular = new JButton("ADD REGULAR MEMBER");
        addRegular.setBounds(90, 590, 200, 30);
        addRegular.addActionListener(this);
        panel.add(addRegular);

        addPremium = new JButton("ADD PREMIUM MEMBER");
        addPremium.setBounds(500, 590, 200, 30);
        addPremium.addActionListener(this);
        panel.add(addPremium);

        clear = new JButton("Clear");
        clear.setBounds(80, 650, 100, 25);
        clear.addActionListener(this);
        panel.add(clear);

        readFile = new JButton("Read from file");
        readFile.setBounds(250, 650, 130, 25);
        readFile.addActionListener(this);
        panel.add(readFile);

        saveFile = new JButton("Save to file");
        saveFile.setBounds(440, 650, 130, 25);
        saveFile.addActionListener(this);
        panel.add(saveFile);

        display = new JButton("Display");
        display.setBounds(600, 650, 100, 25);
        display.addActionListener(this);
        panel.add(display);

        frame.add(panel);
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);//it totally shuts the program running on the background
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);// aligns in the center
        frame.setVisible(true);
    }

    public void RegularMemberAc(RegularMember gym){
        rframe = new JFrame("Member's ACCOUNT");
        rpanel= new JPanel();
        rpanel.setLayout(null);

        title = new JLabel(" Regular Member Account");
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setBounds(320, 20, 300, 30);
        rpanel.add(title);

        //id
        rId = new JLabel("Id:");
        rId.setBounds(90, 80, 180, 25);
        rpanel.add(rId);

        rIdText = new JLabel(String.valueOf(gym.getId()));
        rIdText.setBounds(185, 80, 200, 25);
        rpanel.add(rIdText);

        //membershipStartDate
        rStart =new JLabel ("Membership Start Date:");
        rStart.setBounds(470, 80, 180, 25);
        rpanel.add(rStart);

        rStartText= new JLabel(gym.getMembershipStartDate());
        rStartText.setBounds(630, 80, 180, 25);
        rpanel.add(rStartText);

        //Name

        rName = new JLabel("Name");
        rName.setBounds(90, 115, 100, 25);
        rpanel.add(rName); 

        rNameText= new JTextField(gym.getName());
        rNameText.setBounds(185, 115, 200, 25);
        rNameText.setEditable(false);
        rpanel.add(rNameText);

        //location
        rLocation = new JLabel("Location");
        rLocation.setBounds(470, 115, 100, 25);
        rpanel.add(rLocation);

        rLocationText = new JTextField(gym.getLocation());
        rLocationText.setBounds(630, 115, 200, 25);
        rLocationText.setEditable(false);
        rpanel.add(rLocationText);

        //Phone
        rPhone = new JLabel("Phone");
        rPhone.setBounds(90,150, 100, 25);
        rpanel.add(rPhone);

        rPhoneText = new JTextField(gym.getPhone());
        rPhoneText.setBounds(185,150, 200, 25);
        rPhoneText.setEditable(false);
        rpanel.add(rPhoneText);

        //Email
        rEmail = new JLabel("Email");
        rEmail.setBounds(470, 150, 100, 25);
        rpanel.add(rEmail);

        rEmailText = new JTextField(gym.getEmail());
        rEmailText.setBounds(630, 150, 200, 25);
        rEmailText.setEditable(false);
        rpanel.add(rEmailText);

        //Date Of Birth
        rDob = new JLabel("DOB");
        rDob.setBounds(90, 185, 100, 25);
        rpanel.add(rDob);

        rDobText = new JTextField(gym.getDOB());
        rDobText.setBounds(185, 185, 200, 25);
        rDobText.setEditable(false);
        rpanel.add(rDobText);
        //Gender
        rGender = new JLabel("Gender");
        rGender.setBounds(470, 185, 100, 25);
        rpanel.add(rGender);

        rGenderText = new JTextField(gym.getGender());
        rGenderText.setBounds(630, 185, 200, 25);
        rGenderText.setEditable(false);
        rpanel.add(rGenderText);

        attendance=new JLabel("Attendance:");
        attendance.setBounds(90,220,100,25);
        rpanel.add(attendance);

        attendText=new JTextField("0");
        attendText.setBounds(185,220, 200,25);
        attendText.setEditable(false);
        rpanel.add(attendText);

        loyal=new JLabel("Loyalty Points");
        loyal.setBounds(470,220,100,25);
        rpanel.add(loyal);

        loyalText=new JTextField("0.0");
        loyalText.setBounds(630,220,200,25);
        loyalText.setEditable(false);
        rpanel.add(loyalText);

        active=new JLabel("Active Status:");
        active.setBounds(90,255,100,25);
        rpanel.add(active);

        activeText=new JTextField("Inactive");
        activeText.setBounds(185,255, 200,25);
        activeText.setEditable(false);
        rpanel.add(activeText);

        rPlan=new JLabel("Plan:");
        rPlan.setBounds(470,255,100,25);
        rpanel.add(rPlan);

        rPlanText=new JTextField("Regular");
        rPlanText.setBounds(630,255, 200,25);
        rPlanText.setEditable(false);
        rpanel.add(rPlanText);

        // Adding Buttons
        markAttendance = new JButton("Mark Attendance");
        markAttendance.setBounds(185, 300, 200, 25);
        markAttendance.addActionListener(this);
        rpanel.add(markAttendance);

        upgradePlan= new JButton("Upgrade Plan");
        upgradePlan.setBounds(470, 300, 200, 25);
        upgradePlan.addActionListener(this);
        rpanel.add(upgradePlan);

        activateMembership = new JButton("Activate Membership");
        activateMembership.setBounds(185, 335, 200, 25);
        activateMembership.addActionListener(this);
        rpanel.add(activateMembership);

        deactivateMembership= new JButton("Deactivate Membership");
        deactivateMembership.setBounds(470, 335, 200, 25);
        deactivateMembership.addActionListener(this);
        rpanel.add(deactivateMembership);

        revertRegularMember=new JButton("Revert Member");
        revertRegularMember.setBounds(185,370, 200,25);
        revertRegularMember.addActionListener(this);
        rpanel.add(revertRegularMember);

        //Removal Reason
        removalReason = new JLabel("Removal reason");
        removalReason.setBounds(470, 370, 200, 25);
        rpanel.add(removalReason);

        removalReasonText = new JTextField();
        removalReasonText.setBounds(470 , 400 , 200, 25);
        rpanel.add(removalReasonText);
        //frames to display
        rframe.add(rpanel);
        rframe.setSize(900,550);
        rframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rframe.setResizable(false);
        rframe.setLocationRelativeTo(null);
        rframe.setVisible(true);
    }

    public void PremiumMemberAc(PremiumMember gym){
        pframe = new JFrame("Member's ACCOUNT");
        ppanel= new JPanel();
        ppanel.setLayout(null);

        ptitle = new JLabel(" Premium Member Account");
        ptitle.setFont(new Font("Arial", Font.BOLD, 24));
        ptitle.setBounds(290, 20, 400, 30);
        ppanel.add(ptitle);

        //id
        pId = new JLabel("Id:");
        pId.setBounds(90, 80, 180, 25);
        ppanel.add(pId);

        pIdText = new JLabel(String.valueOf(gym.getId()));
        pIdText.setBounds(185, 80, 200, 25);
        ppanel.add(pIdText);

        //membershipStartDate
        pStart =new JLabel ("Membership Start Date:");
        pStart.setBounds(470, 80, 180, 25);
        ppanel.add(pStart);

        pStartText= new JLabel(gym.getMembershipStartDate());
        pStartText.setBounds(630, 80, 180, 25);
        ppanel.add(pStartText);

        //Name

        pName = new JLabel("Name");
        pName.setBounds(90, 115, 100, 25);
        ppanel.add(pName); 

        pNameText= new JTextField(gym.getName());
        pNameText.setBounds(185, 115, 200, 25);
        pNameText.setEditable(false);
        ppanel.add(pNameText);

        //location
        pLocation = new JLabel("Location");
        pLocation.setBounds(470, 115, 100, 25);
        ppanel.add(pLocation);

        pLocationText = new JTextField(gym.getLocation());
        pLocationText.setBounds(630, 115, 200, 25);
        pLocationText.setEditable(false);
        ppanel.add(pLocationText);

        //Phone
        pPhone = new JLabel("Phone");
        pPhone.setBounds(90,150, 100, 25);
        ppanel.add(pPhone);

        pPhoneText = new JTextField(gym.getPhone());
        pPhoneText.setBounds(185,150, 200, 25);
        pPhoneText.setEditable(false);
        ppanel.add(pPhoneText);

        //Email

        pEmail = new JLabel("Email");
        pEmail.setBounds(470, 150, 100, 25);
        ppanel.add(pEmail);

        pEmailText = new JTextField(gym.getEmail());
        pEmailText.setBounds(630, 150, 200, 25);
        pEmailText.setEditable(false);
        ppanel.add(pEmailText);

        //Date Of Birth
        pDob = new JLabel("DOB");
        pDob.setBounds(90, 185, 100, 25);
        ppanel.add(pDob);

        pDobText = new JTextField(gym.getDOB());
        pDobText.setBounds(185, 185, 200, 25);
        pDobText.setEditable(false);
        ppanel.add(pDobText);
        //Gender
        pGender = new JLabel("Gender");
        pGender.setBounds(470, 185, 100, 25);
        ppanel.add(pGender);

        pGenderText = new JTextField(gym.getGender());
        pGenderText.setBounds(630, 185, 200, 25);
        pGenderText.setEditable(false);
        ppanel.add(pGenderText);
        //attendance
        pAttendance=new JLabel("Attendance:");
        pAttendance.setBounds(90,220,100,25);
        ppanel.add(pAttendance);

        pAttendText=new JTextField("0");
        pAttendText.setBounds(185,220, 200,25);
        pAttendText.setEditable(false);
        ppanel.add(pAttendText);
        //loyalty points
        pLoyal=new JLabel("Loyalty Points");
        pLoyal.setBounds(470,220,100,25);
        ppanel.add(pLoyal);

        pLoyalText=new JTextField("0.0");
        pLoyalText.setBounds(630,220,200,25);
        pLoyalText.setEditable(false);
        ppanel.add(pLoyalText);
        //actice status
        pActive=new JLabel("Active Status:");
        pActive.setBounds(90,255,100,25);
        ppanel.add(pActive);

        pActiveText=new JTextField("Inactive");
        pActiveText.setBounds(185,255, 200,25);
        pActiveText.setEditable(false);
        ppanel.add(pActiveText);

        pPlan=new JLabel("Plan:");
        pPlan.setBounds(470,255,100,25);
        ppanel.add(pPlan);

        pPlanText=new JTextField("Premium");
        pPlanText.setBounds(630,255, 200,25);
        pPlanText.setEditable(false);
        ppanel.add(pPlanText);

        // Adding Buttons
        pMarkAttendance = new JButton("Mark Attendance");
        pMarkAttendance.setBounds(185, 300, 200, 25);
        pMarkAttendance.addActionListener(this);
        ppanel.add(pMarkAttendance);

        discountBtn= new JButton("Discount");
        discountBtn.setBounds(470, 300, 200, 25);
        discountBtn.addActionListener(this);
        ppanel.add(discountBtn);

        pActivateMembership = new JButton("Activate Membership");
        pActivateMembership.setBounds(185, 335, 200, 25);
        pActivateMembership.addActionListener(this);
        ppanel.add(pActivateMembership);

        pDeactivateMembership= new JButton("Deactivate Membership");
        pDeactivateMembership.setBounds(470, 335, 200, 25);
        pDeactivateMembership.addActionListener(this);
        ppanel.add(pDeactivateMembership);

        //pay due amount
        pAmt = new JLabel("Amount");
        pAmt.setBounds(185, 370, 200, 25);
        ppanel.add(pAmt);

        pAmtText = new JTextField();
        pAmtText.setBounds(185 , 405 , 200, 25);
        ppanel.add(pAmtText);
        //revert member
        
        revertPremiumMember=new JButton("Revert Member");
        revertPremiumMember.setBounds(470,370, 200,25);
        revertPremiumMember.addActionListener(this);
        ppanel.add(revertPremiumMember);

        due=new JButton("Pay Due Amount");
        due.setBounds(470,405, 200,25);
        due.addActionListener(this);
        ppanel.add(due);

        pframe.add(ppanel);
        pframe.setSize(900,550);
        pframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pframe.setResizable(false);
        pframe.setLocationRelativeTo(null);
        pframe.setVisible(true);
    }
    //methof to clear everything
    public void clearEverything(){
        idText.setText("");
        nameText.setText("");
        locationText.setText("");
        phoneText.setText("");
        emailText.setText("");
        priceText.setText("");
        referralText.setText("");
        trainerText.setText("");
        button.clearSelection();
        yearDob.setSelectedIndex(0);
        monthDob.setSelectedIndex(0);
        dayDob.setSelectedIndex(0);
        planYear.setSelectedIndex(0);
        planMonth.setSelectedIndex(0);
        planDay.setSelectedIndex(0);
        planC.setSelectedIndex(0);
    }
    //helper method
    private GymMember searchMember(int id) {
        for (GymMember exist : gym) {
            if (exist.getId() == id) {
                return exist;
            }
        }
        return null;
    }
    //reader
    public void detailsFromFile() {
        JFrame readFrame = new JFrame("Saved Member Details");
        readFrame.setSize(1000, 500);
        readFrame.setLocationRelativeTo(null);
        readFrame.setLayout(null);

        textArea = new JTextArea();
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        textArea.setEditable(false);
        textArea.setBounds(10, 10, 960, 440);

        try {
            file = new File("MemberDetails.txt");

            if (!file.exists() || file.length() == 0) {
                textArea.setText("No saved member details found.");
            } else {
                reading = new FileReader(file);
                int chart;
                String content="";

                while ((chart = reading.read()) != -1) {
                    content+=(char) chart;
                }//read until the last character

                textArea.setText(content);
                reading.close();
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(readFrame, "Error reading file: " + ex.getMessage());
        }

        readFrame.add(textArea);
        readFrame.setVisible(true);
    }
    //save
    public void saveToFile() {
        try {
            File file = new File("MemberDetails.txt");
            writing = new FileWriter(file, false); // true for append mode but false

            // Write header only if the file is empty
            if (file.length() == 0) {
                writing.write(String.format("%-5s %-15s %-15s %-15s %-15s %-15s %-10s %-10s %-10s %-15s %-10s %-15s %-15s %-15s\n", 
                        "ID", "Name", "Location", "Phone", "Email", "Start Date", "Plan", "Price", "Attendance", 
                        "Loyalty", "Active", "FullPayment", "Discount", "Paid"));
            }
            if (gym.size() == 0) {
                JOptionPane.showMessageDialog(frame, "No members to save.");
                writing.close();
                return;
            }
            for (GymMember check : gym) {
                if (check instanceof RegularMember) {
                    RegularMember r = (RegularMember) check;
                    writing.write(String.format("%-5d %-15s %-15s %-15s %-15s %-15s %-10s %-10s %-10s %-15s %-10s %-15s %-15s %-15s\n",//format of printing
                            r.getId(), r.getName(), r.getLocation(), r.getPhone(), r.getEmail(), r.getMembershipStartDate(),
                            r.getPlan(), r.getPrice(), r.getAttendance(), r.getLoyaltyPoints(), //getter method
                            r.getActiveStatus(), "N/A", "N/A", "N/A"));
                    clearEverything();
                } else if (check instanceof PremiumMember) {
                    PremiumMember pre = (PremiumMember) check;
                    writing.write(String.format("%-5d %-15s %-15s %-15s %-15s %-15s %-10s %-10.2f %-10s %-15s %-10s %-15s %-15.2f %-15.2f\n",
                            pre.getId(), pre.getName(), pre.getLocation(), pre.getPhone(), pre.getEmail(), pre.getMembershipStartDate(),
                            "Premium", pre.getPremiumCharge(), pre.getAttendance(), pre.getLoyaltyPoints(), 
                            pre.getActiveStatus(), pre.getIsFullPayment(), pre.getDiscountAmount(), pre.getPaidAmount()));

                }
                clearEverything();
            }
            System.out.println("Number of members to save: " + gym.size());

            //  Flush before closing to ensure data is saved
            writing.flush();
            writing.close();

            JOptionPane.showMessageDialog(frame, "Data saved successfully!");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(frame, "Error saving data: " + ex.getMessage());
        }
    }   

    public void actionPerformed(ActionEvent event) {
        //selecting the price according to the plan
        String selectedPlan = (String) planC.getSelectedItem();
        switch (selectedPlan) {
            case "Basic":
                priceText.setText("6500");

                break;
            case "Standard":
                priceText.setText("8500");

                break;
            case "Deluxe":
                priceText.setText("10500");

                break;
            default:
                priceText.setText(" ");

        }

        // To Display
        if (event.getSource() == display) {
            String abc = idText.getText();
            if (abc.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Empty id field");
                return;
            }
            try {
                int id = Integer.parseInt(abc); // Parse the ID from input
                boolean found=false;//default value false
                for (GymMember exist : gym) {//if the id already exist in arraylist

                    if (exist.getId() == id) {//comparing
                        if(exist instanceof RegularMember){
                            RegularMember regM = (RegularMember) exist; 
                            RegularMemberAc(regM);
                        }
                        if(exist instanceof PremiumMember){
                            PremiumMember preM = (PremiumMember) exist;
                            PremiumMemberAc(preM);
                        }
                        //MemberAc(exist); //does exists
                        found=true;//becomes true
                        break;
                    }
                }
                if(!found){//if it does not exist
                    JOptionPane.showMessageDialog(frame, "This ID doesnot exist please enter the existing ID");
                }
            } catch (NumberFormatException e) {//if anything else added than number then this will run
                JOptionPane.showMessageDialog(frame, "Please enter a valid numeric ID.");
            }
        }
        //Clear button to remove data temporarily
        else if (event.getSource() == clear) {
            clearEverything();
        } 
        //Adding regular member
        else if (event.getSource() == addRegular) {
            try {//if any field id null then popup will be displayed
                int id=Integer.parseInt(idText.getText());
                if(idText.getText().isEmpty() ||
                nameText.getText().isEmpty() ||
                locationText.getText().isEmpty() ||
                phoneText.getText().isEmpty() ||
                emailText.getText().isEmpty() ||
                referralText.getText().isEmpty() ||
                planC.getSelectedItem() == null ||
                yearDob.getSelectedItem() == null ||
                monthDob.getSelectedItem() == null ||
                dayDob.getSelectedItem() == null ||
                planYear.getSelectedItem() == null ||
                planMonth.getSelectedItem() == null ||
                planDay.getSelectedItem() == null ||
                (!maleButton.isSelected() && !femaleButton.isSelected() && !otherButton.isSelected()))
                {

                    JOptionPane.showMessageDialog(frame, "Please fill in all required fields.");
                    return;
                }
                // Validate phone number
                String phone = phoneText.getText();
                if (!phone.matches("^[0-9]{10}$")) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid phone number.");
                    return;
                }
                // Validate email
                String email = emailText.getText();
                if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid email address.");
                    return;
                }

                String gender = maleButton.isSelected() ? "Male" :femaleButton.isSelected() ? "Female" :otherButton.isSelected() ? "Others" : "Unspecified";
                String dob = yearDob.getSelectedItem() + "/ " +monthDob.getSelectedItem() + "/ " + dayDob.getSelectedItem();//selected item is stored
                String start= planYear.getSelectedItem() + "/" +planMonth.getSelectedItem() + "/" + planDay.getSelectedItem();
                //all the imformation is stored in an object of child class
                RegularMember fault = new RegularMember(id, nameText.getText(), locationText.getText(),phoneText.getText(), emailText.getText(), gender,dob,start,referralText.getText());
                for (GymMember exit : gym) {//if the id already exists then compares
                    if (exit.getId() == id) {
                        JOptionPane.showMessageDialog(frame, "ID already exists.");
                        return; // Don't add if ID exists
                    }
                }
                gym.add(fault);//adding fault in gym arraylist
                //Clear 

                JOptionPane.showMessageDialog(frame, "Regular member added.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Please fill all the details.");
            }
        }
        else if (event.getSource() == addPremium) {
            //if any field is empty then the popup will be shown
            try {
                int id=Integer.parseInt(idText.getText());
                if(idText.getText().isEmpty() ||
                nameText.getText().isEmpty() ||
                locationText.getText().isEmpty() ||
                phoneText.getText().isEmpty() ||
                emailText.getText().isEmpty() ||
                trainerText.getText().isEmpty()||
                planC.getSelectedItem() == null ||
                yearDob.getSelectedItem() == null ||
                monthDob.getSelectedItem() == null ||
                dayDob.getSelectedItem() == null ||
                planYear.getSelectedItem() == null ||
                planMonth.getSelectedItem() == null ||
                planDay.getSelectedItem() == null ||
                (!maleButton.isSelected() && !femaleButton.isSelected() && !otherButton.isSelected()))
                {

                    JOptionPane.showMessageDialog(frame, "Please fill in all required fields.");
                    return;
                }
                // Validate phone number
                String phone = phoneText.getText();
                if (!phone.matches("^[0-9]{10}$")) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid phone number (10 digits).");
                    return;
                }

                // Validate email
                String email = emailText.getText();
                if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid email address.");
                    return;
                }

                String gender = maleButton.isSelected() ? "Male" :femaleButton.isSelected() ? "Female" :otherButton.isSelected() ? "Others" : "Unspecified";
                String dob = yearDob.getSelectedItem() + "/ " +monthDob.getSelectedItem() + "/ " + dayDob.getSelectedItem();//Selected items is store
                String start= planYear.getSelectedItem() + "/" +planMonth.getSelectedItem() + "/" + planDay.getSelectedItem();
                //storing the value of every cpmponent in an object
                PremiumMember fault = new PremiumMember(id, nameText.getText(), locationText.getText(),phoneText.getText(), emailText.getText(), gender,dob,start,trainerText.getText());
                //for loop to compare the id if it already exists
                for (GymMember exit : gym) {
                    if (exit.getId() == id) {
                        JOptionPane.showMessageDialog(frame, "ID already exists.");
                        return; // Don't add if ID exists
                    }
                }

                gym.add(fault);

                JOptionPane.showMessageDialog(frame, "Premium member added.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Invaild");
            }
        }
        else if(event.getSource()==readFile){
            detailsFromFile();//calling the function
        }
        else if(event.getSource() == saveFile) {
            saveToFile();
        }
        else if(event.getSource()== markAttendance){
            GymMember attend=searchMember(Integer.parseInt(rIdText.getText()));//comparing id
            if (attend instanceof RegularMember) {
                RegularMember reg = (RegularMember) attend;//downcasting
                if(reg.activeStatus){//mark attendance true
                    reg.markAttendance();
                    attendText.setText(String.valueOf(reg.getAttendance()));
                    loyalText.setText(String.valueOf(reg.getLoyaltyPoints()));
                    JOptionPane.showMessageDialog(rframe, "Attendance marked for ID: " +attend.getId() );
                    saveToFile();
                }
                else{
                    JOptionPane.showMessageDialog(rframe, "Attendance cannot be marked.\nAccount is not activated");
                }
            }

        }
        else if(event.getSource()== pMarkAttendance){//PREMIUM MARK ATTENDANCE
            GymMember attend=searchMember(Integer.parseInt(pIdText.getText()));
            if (attend instanceof PremiumMember) {
                PremiumMember pre = (PremiumMember) attend;//DOWN CASTING
                if(pre.activeStatus){
                    pre.markAttendance();
                    pAttendText.setText(String.valueOf(pre.getAttendance()));
                    pLoyalText.setText(String.valueOf(pre.getLoyaltyPoints()));
                    JOptionPane.showMessageDialog(pframe, "Attendance marked for " +attend.getId() );
                    saveToFile();
                }
                else{
                    JOptionPane.showMessageDialog(pframe, "Attendance cannot be marked.\nAccount is not activated");
                }
            }
        }

        else if(event.getSource()==revertPremiumMember){//REVERT MEMBER OF PREMIUM
            GymMember revert = searchMember(Integer.parseInt(pIdText.getText()));
            if (revert instanceof PremiumMember) {
                PremiumMember pre = (PremiumMember) revert;
                if(pre.activeStatus){
                    pre.revertPremiumMember();
                    pAttendText.setText(String.valueOf(pre.getAttendance()));
                    pLoyalText.setText(String.valueOf(pre.getLoyaltyPoints()));
                    pActiveText.setText("Inactive");//SET TO INACTIVE

                    JOptionPane.showMessageDialog(pframe,"Membership reverted");
                    saveToFile();
                }else{
                    JOptionPane.showMessageDialog(pframe,"Membership not activated");
                }
            }

        }
        else if(event.getSource()==revertRegularMember){//REVERT MEMBER FOR REGULAR
            GymMember revert = searchMember(Integer.parseInt(rIdText.getText()));
            String fReason = removalReasonText.getText();//REASON MUST BE THERE

            if (revert instanceof RegularMember) {
                if(fReason==null  || fReason.isEmpty()){
                    JOptionPane.showMessageDialog(rframe,"Please fill the reason");

                }else{
                    try{
                        Integer.parseInt(fReason);
                        JOptionPane.showMessageDialog(rframe,"The reason must be valid");
                    }

                    catch(NumberFormatException e){
                        RegularMember reg = (RegularMember) revert;
                        if(reg.activeStatus){
                            reg.revertRegularMember(fReason);
                            rPlanText.setText(reg.getPlan());
                            attendText.setText(String.valueOf(reg.getAttendance()));
                            loyalText.setText(String.valueOf(reg.getLoyaltyPoints()));
                            activeText.setText("Inactive");
                            removalReasonText.setText("");

                            JOptionPane.showMessageDialog(rframe, "Membership reverted. \nReason: " + fReason);
                            saveToFile();//SAVE THE FILE IN THE TEXT FILE
                        }else{
                            JOptionPane.showMessageDialog(rframe, "Membership not activated"); 
                        }
                    }    
                }
            } 
        }

        else if(event.getSource()==activateMembership){//ACTIVATE FOR REGULAR
            GymMember active=searchMember(Integer.parseInt(rIdText.getText()));
            if (!active.getActiveStatus()){
                active.activateMembership();
                JOptionPane.showMessageDialog(rframe,"Membership Activated.");
                activeText.setText("Active");
                saveToFile();
            }else{
                JOptionPane.showMessageDialog(rframe,"Membership already Activated.");
            }

        }
        else if(event.getSource()==pActivateMembership){//ACTIVATE FOR PREMIUM
            GymMember active=searchMember(Integer.parseInt(pIdText.getText()));
            if (!active.getActiveStatus()){
                active.activateMembership();
                JOptionPane.showMessageDialog(pframe,"Membership Activated.");
                pActiveText.setText("Active");
                saveToFile();
            }else{
                JOptionPane.showMessageDialog(pframe,"Membership already Activated.");
            }

        }
        else if(event.getSource()==pDeactivateMembership){//DEACTIVATE FOR PREMIUM
            GymMember deactive=searchMember(Integer.parseInt(pIdText.getText()));
            if(deactive.getActiveStatus()){
                deactive.deactivateMembership();
                JOptionPane.showMessageDialog(pframe,"Membership Deactivated.");
                pActiveText.setText("Inactive");
                saveToFile();
            }
            else{
                JOptionPane.showMessageDialog(pframe,"Membership already Deactivated.");
            }
        }
        else if(event.getSource()==deactivateMembership){//DEACTIVATE FOR REGULAR
            GymMember deactive=searchMember(Integer.parseInt(rIdText.getText()));
            if(deactive.getActiveStatus()){
                deactive.deactivateMembership();
                JOptionPane.showMessageDialog(rframe,"Membership Deactivated.");
                activeText.setText("Inactive");
                saveToFile();
            }

            else{
                JOptionPane.showMessageDialog(rframe,"Membership already Deactivated.");
            }
        }

        else if(event.getSource()==upgradePlan){//UPGRADE PLAN
            GymMember upgrade=searchMember(Integer.parseInt(rIdText.getText()));

            if(upgrade instanceof RegularMember){

                RegularMember reg=(RegularMember) upgrade;
                if(reg.activeStatus){
                    String newPlan=JOptionPane.showInputDialog(rframe,"Enter New Plan(Basic,Standard,Deluxe):");

                    if(newPlan!=null){
                        String finall=reg.upgradePlan(newPlan);
                        if(finall.equals("Sucessfully updated the membership!!")){
                            JOptionPane.showMessageDialog(rframe,finall+"\nNew plan:"+reg.getPlan()+"\nNew price"+reg.getPrice());
                            rPlanText.setText(String.valueOf(reg.getPlan()));

                        }
                        else{JOptionPane.showMessageDialog(rframe,finall);
                            saveToFile();
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(rframe,"Empty input");
                    }
                }
                else{
                    JOptionPane.showMessageDialog(rframe,"Membership not activated.");
                }
            }
        }
        else if(event.getSource()==due){//PAY DUE AMOUNT
            GymMember due = searchMember(Integer.parseInt(pIdText.getText()));
            String amt =pAmtText.getText();
            if(due.activeStatus){  
                if(amt.isEmpty()){
                    JOptionPane.showMessageDialog(pframe,"Please Enter the balance.");
                    return;  
                }
                double left;
                try{
                    left=Double.parseDouble(amt);
                }
                catch(NumberFormatException e){
                    JOptionPane.showMessageDialog(pframe,"Please Enter A Valid Number.");
                    return;
                }
                if (due instanceof PremiumMember) {
                    PremiumMember pre = (PremiumMember) due;
                    String total=pre.payDueAmount(left);
                    JOptionPane.showMessageDialog(pframe,total);
                    pAmtText.setText("");
                    saveToFile();
                }

            }
            else{
                JOptionPane.showMessageDialog(pframe,"Membership not activated.");
            }
        }
        else if(event.getSource()==discountBtn){//DISCOUNT BUTTON
            GymMember discount=searchMember(Integer.parseInt(pIdText.getText()));
             if(discount instanceof PremiumMember){
                PremiumMember dis=(PremiumMember) discount;
                String display=dis.calculateDiscount();
                JOptionPane.showMessageDialog(pframe,display);
                saveToFile(); 
            }
        }
    }

    public static void main(String args[])
    {
        new GymGUI();//calling the main class
    }
}