import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * @author Memo Aldujaili
 * Driver Class, Contains Main Methode For {@link FreshcoStaff}
 */

public class Driver
{
    /**
     * Scanner Is To Read Data Input From User, See {@link Scanner}
     */
    public static final Scanner scanner = new Scanner(System.in);

    /**
     * This Methode Is Used To Get User Int Input From Termianl
     * @return Users Int Input
     */
    public static int getUserIntValue()
    {
        while(!scanner.hasNextInt())
            {
                String input = scanner.next();
                System.out.printf("\"%s\" Is Not A Number.\n", input);
            }
        return scanner.nextInt();
    }

    /**
     * This Methode Is Used To Get User Double Input From Termianl
     * @return Users Double Input
     */
    public static double getUserDoubleValue()
    {
        double input = 0.0;
        boolean pass = false;
        while(!scanner.hasNextDouble())
            {
                if(scanner.hasNextInt())
                {
                    input = ((double) scanner.nextInt());
                    pass = true;
                    break;
                    
                }
                String input2 = scanner.next();
                System.out.printf("\"%s\" Is Not A Number.\n", input2);
            }
        if(!pass)
        {
            input = scanner.nextDouble();
        }
        return input;
    }

    /**
     * This Methode Is Used To Get User String Input From Termianl
     * This Methode Only Read One String At A Time
     * @return Users String Input
     */
    public static String getUserStringInput()
    {
        String val;
        while(!scanner.hasNext("[A-Za-z]*"))
        {
            val = scanner.next();
            System.out.printf("\"%s\" Is Not A String Of Characters.\n", val);
        }
        val = scanner.next();
        return val;
    }
    /**
     * This Method Is Used To Change Info Of The Instance Variable In {@link FreshcoStaff#staffList}
     * @param staff Staff To Be Changed, As {@link FreshcoStaff}
     * @param choice Choice, User Input As Int
     */
    public static void changeStaffInfo(FreshcoStaff staff, int choice)
    {
        //Change Hours Of staff
        if(choice == 1)
        {
            System.out.println("Please Provide New Hours For Name : "+ staff.getName() + ", ID : "+ staff.getID());
            while(true)
            {
                double newHours =  getUserDoubleValue();
                if(newHours >=  0.0){((Employee) staff).setHours(newHours);System.out.println("Hours Changed Succsefully To "+ ((Employee) staff).getHours());break;}
                else{System.out.println("Please Entre a None Negative Value");}
            }
        }
        //Change Name Of Staff
        else if(choice == 2)
        {
            System.out.println("Please Provide New Name For Name : "+ staff.getName() + ", ID : "+ staff.getID());
            String newFirstName, newLastName,confirmation;
            System.out.print("First Name : ");
            newFirstName = getUserStringInput();
            System.out.print("\nLast Name : ");
            newLastName = getUserStringInput();
            System.out.println("Are You Sure You Want To Change "+staff.getID()+" To "+newFirstName + " "+ newLastName+". Entre (y/n)");
            while(true)
            {
                confirmation = getUserStringInput().toLowerCase();
                if((confirmation).equals("y")){(staff).setName(newFirstName + " "+ newLastName);System.out.println("Name Changed Succsefully To "+ (staff).getName());break;}
                else if((confirmation).equals("n")){System.out.println("Request Stoped");break;}
                else{System.out.println("Incorrect Please Provide (y/n)");}
            }
                
        }
        //Check If Temps Staff Is Of Type Cashier
        else if(staff.getClass().getName().equals(Cashier.class.getName()))
        {
            //If User Input Is 3, Then Chnage Cash Code Of The Temp Staff
            if(choice == 3)
            {
                System.out.println("Are You Sure You Want To Change Cash Code For "+staff.getName() + ", ID : "+ staff.getID()+"\nEntre (y/n)");
                while(true)
                {

                    String verification = getUserStringInput().toLowerCase();
                    if(verification.equals("y")){((Cashier) staff).changeCashierCode();System.out.println("Cash Code Changed Succsefully To "+ ((Cashier) staff).getCashierCode());break;}
                    else if(verification.equals("n"))
                    {
                        System.out.println("Request Stoped");
                        displayStaffOptions(staff);
                        break;
                    }
                    else{System.out.println("Incorrect Please Provide (y/n)");}
                }
            }
        }//Check if Temp Staff Is Of Type Grocery
        else if(staff.getClass().getName().equals(Grocery.class.getName()))
        {
            //If User Input Is 3 Then Change Skid Count Of Temp Staff
            if(choice == 3)
            {
                System.out.println("Please Provide New Skid Count For "+staff.getName() + ", ID : "+ staff.getID());
                while(true)
                {

                    Double newSkid = getUserDoubleValue();
                    if(newSkid >= 0.0){((Grocery) staff).setSkidsFinished(newSkid);System.out.println("Skid Count Changed Succsefully To "+ ((Grocery) staff).getSkidFinished());break;}
                    else{System.out.println("Incorrect Please Provide A None Negative Number");}
                }
            }
        }
    }
    /**
     * This Methode Displays All The Option That Can Be Changed About A Staff, see {@link FreshcoStaff}
     * @param staffServing This Is The Staff That Is Being Processed 
     * @return Number Of Choices That staffServing Has
     */
    public static int displayStaffOptions(FreshcoStaff tempStaff)
    {
        int numberOfChoices = 0;
        //Display Option That Can Be Done On tempStaff Of Type Employee
        if(tempStaff.getClass().getName().equals(Employee.class.getName()))
        {
            System.out.println("Staff Info: "+tempStaff+"\nHere Are Your Option Choose The Number Accordanly\n1) Change Hours\n2) Change Name\n3) Exit");
            System.out.println();
            numberOfChoices = 3;
        }
        //Display Option That Can Be Done On tempStaff Of Type Cashier
        else if (tempStaff.getClass().getName().equals(Cashier.class.getName()))
        {
            System.out.println("Staff Info: "+tempStaff+"\nHere Are Your Option Choose The Number Accordanly\n1) Change Hours\n2) Change Name\n3) Change Cash Code \n4) Exit");
            System.out.println();
            numberOfChoices = 4;
        }
        //Display Option That Can Be Done On tempStaff Of Type Grocery
        else if (tempStaff.getClass().getName().equals(Grocery.class.getName()))
        {
            System.out.println("Staff Info: "+tempStaff+"\nHere Are Your Option Choose The Number Accordanly\n1) Change Hours\n2) Change Name\n3) Change Skid Count \n4) Exit");
            System.out.println();
            numberOfChoices = 4;
        }
        //Display Option That Can Be Done On tempStaff Of Type Manager
        else if(tempStaff.getClass().getName().equals(Managers.class.getName()))
        {
            System.out.println("Staff Info: "+tempStaff+"\nHere Are Your Option Choose The Number Accordanly\n1) Change Hours\n2) Change Name\n3) Exit");
            System.out.println();
            System.out.println();
            numberOfChoices = 3;
        }
        return numberOfChoices;
    }

    /**
     * This Methode Prints Users Option 
     * @param staffServing This Is The Staff That Is Being Processed, see {@link FreshcoStaff}
     * @return Number Of Choice That The Staff Has.
     */
    public static int showOptions(FreshcoStaff staffServing)
    {
        int numberOfChoices = 0;
        //Display Option That staffServing Of Type Employee Can Do.
        if(staffServing.getClass().getName().equals(Employee.class.getName()))
        {
            System.out.println("You Are Currently a Employer At Freshco\nHere Are Your Option Choose The Number Accordanly\n1) See Id\n2) See Hours\n3) See Salary\n4) See Full Info\n5) Exit");
            System.out.println();
            numberOfChoices = 5;
        }
        //Display Option That staffServing Of Type Cashier Can Do.
        else if (staffServing.getClass().getName().equals(Cashier.class.getName()))
        {
            System.out.println("You Are Currently a Cashier Employer At Freshco\nHere Are Your Option Choose The Number Accordanly\n1) See Id\n2) See Hours\n3) See Salary\n4) See Cahier Code\n5) See Full Info\n6) Exit");
            System.out.println();
            numberOfChoices = 6;
        }
        //Display Option That staffServing Of Type Grocery Can Do.
        else if (staffServing.getClass().getName().equals(Grocery.class.getName()))
        {
            System.out.println("You Are Currently a Grocery Employer At Freshco\nHere Are Your Option Choose The Number Accordanly\n1) See Id\n2) See Hours\n3) See Salary\n4) See Number Of Skids Finished\n5) See Full Info\n6) Exit");
            System.out.println();
            numberOfChoices = 6;
        }
        //Display Option That staffServing Of Type Manager Can Do.
        else if(staffServing.getClass().getName().equals(Managers.class.getName()))
        {
            System.out.println("You Are Currently a Manager At Freshco\nHere Are Your Option Choose The Number Accordanly\n1) See Id\n2) See Hours\n3) See Salary\n4) Change Info Of Employers\n5) Hire Employee\n6) Fire Employer\n7)See Full Info\n8) Exit");
            System.out.println();
            numberOfChoices = 8;
        }
        //Display Option That staffServing Of Type Owner Can Do.
        else if(staffServing.getClass().getName().equals(Owner.class.getName()))
        {
            System.out.println("You Are The Owner Of Freshco\nHere Are Your Option Choose The Number Accordanly\n1) See Id\n2) Promote Staff \n3) Change Info Of Staff\n4) Hire Staff\n5) Fire Employee\n6)See Full Info\n7) Exit");
            System.out.println();
            numberOfChoices = 7;
        }
        return numberOfChoices;
    }

    /**
     * This Methode Processes The Staff's Request According To their Input
     * @param staffServing This Is The Staff That Is Being Processed, see {@link FreshcoStaff}
     * @param choice choice From Options, As Int
     */
    public static void doOption(FreshcoStaff staffServing, int choice)
    {
        //Returns The staffServing Id If choice == 1
        if(choice == 1){System.out.println("Your Id Is : "+ staffServing.getID());}
        //Returns The staffServing Hours For This Week If choice == 2 And StaffServing Is Not Of Type Manager(Manager Does Not Have Hours).
        else if((choice == 2)&&(staffServing.getClass().getName().equals(Owner.class.getName()) == false)){System.out.println("Your Hours For This Week: "+ ((Employee) staffServing).getHours());}
        //If Choice == -2 And staffServing Is Of Type Owner Then User Will Choose A Staff To Promot.
        else if((choice == 2)&&(staffServing.getClass().getName().equals(Owner.class.getName()) == true))
        {
            //List Of Id;
            long[] promoId = new long[Employee.getNumEmployers()];
            System.out.println("Please Choose One Of The Following Id To Be Promoted, Or Enter (-1) To Go Back To Your Options");
            for(int i =0; i < FreshcoStaff.staffNumber; i++)
            {
                //Cant Promot a Maanager Or Owner
                if((FreshcoStaff.staffList[i].getClass().getName().equals(Owner.class.getName()) == false) && (FreshcoStaff.staffList[i].getClass().getName().equals(Managers.class.getName()) == false))
                {
                    System.out.println("Name : "+ FreshcoStaff.staffList[i].getName() + ", ID : "+ FreshcoStaff.staffList[i].getID());
                    System.out.println();
                    promoId[i] = FreshcoStaff.staffList[i].getID();
                }
            }
            //Get Id Of Staff To Promot
            for(int j= 0; j < promoId.length; j ++)
                {
                    choice =  getUserIntValue();
                    if(choice  == promoId[j])
                    {
                        //Show Promotion Type If Staff Is Found
                        FreshcoStaff tempPromoted =  FreshcoStaff.getStaffWithId(choice);
                        String[] promotionTypes = new String[]{"Employee","Cashier","Grocery","Manager"};
                        System.out.println("Staff Info\n"+tempPromoted+"\nEnter Promotion type From Option Below:");
                        for(int i = 0; i < promotionTypes.length;i++)
                        {
                            //Cant Promot A Staff To Its Own Type. Ex Cant Promot A Staff Of Type Manager To Manager
                            if(promotionTypes[i].equals(tempPromoted.getClass().getName()) == false)
                            {
                                System.out.println(promotionTypes[i]);
                            }
                        }
                        System.out.println("Entre ('Exit') To Go Back To Your Options");
                            
                        while(true)
                        {
                            //Get Promotion Type
                            String promotion = getUserStringInput().toLowerCase();
                            if((((promotion.equals("employee")) ||(promotion.equals("cashier")) ||(promotion.equals("grocery")) ||(promotion.equals("manager"))) == true && (promotion.equals(tempPromoted.getClass().getName().toLowerCase())) == false))
                            {
                                //Call promote Methode In CLass Ownerw
                                ((Owner) staffServing).promote(tempPromoted, promotion);
                                System.out.println("Staff: "+ FreshcoStaff.getStaffWithId(choice).getName() +" Is Successfully Promoted To "+ promotion+"\nInfo:\n"+FreshcoStaff.getStaffWithId(choice));
                                break;
                            }
                            else if(promotion.equals(tempPromoted.getClass().getName().toLowerCase()) == true )
                            {
                                System.out.println(tempPromoted.getName() + " Is Already A "+promotion+" Please Select Something Else Or Entre ('Exit') To Go Back To Your Options");

                            }
                            //Go Back To Option Of staffServing
                            else if(promotion.equals("exit"))
                            {
                                break;
                            }
                            else
                            {
                                System.out.println("Input: "+ promotion+ " Is Invalid, Please Entre A Valid Promotion Type Or Entre ('Exit') To Go Back To Your Options");
                            }
                        }

                            break;
                    }
                    //Leave Promotion If User Input Is -1
                    else if(choice == -1){break;}
                    else {System.out.println(choice + " Is Not A Choice Please Choose A Id from The Id's Shown Previously Or Entre (-1) To Go Back To Your Option");}

                }
            
        }
        //Give Salary Of Staff If Choice == 3 And Staff Is Not Of Type Owner
        else if((choice == 3)&&(staffServing.getClass().getName().equals(Owner.class.getName()) == false))
        {
            System.out.println("Your Salary For This Week: "+ ((Employee) staffServing).calcSalary());
        }
        //Change Info Of Other Staffs, Only Owners And Manager Can Access This
        else if(((choice == 3)&&(staffServing.getClass().getName().equals(Owner.class.getName()))) ||((choice == 4) && (staffServing.getClass().getName().equals(Managers.class.getName()))))
        {
            long[] employers = new long[FreshcoStaff.getStaffNumber()];
            System.out.println("Please Choose One Of The Following Id To Change They're Info, Or Enter (-1) To Go Back To Your Options");
            for(int i =0; i < FreshcoStaff.staffNumber; i++)
            {
                if((!(FreshcoStaff.staffList[i].getClass().getName().equals(Owner.class.getName())) && ((staffServing.getClass().getName().equals(Owner.class.getName())))) || (((staffServing.getClass().getName().equals(Managers.class.getName())) && !(FreshcoStaff.staffList[i].getClass().getName().equals(Managers.class.getName()))) && !(FreshcoStaff.staffList[i].getClass().getName().equals(Owner.class.getName()))))
                {
                    System.out.println("Name : "+ FreshcoStaff.staffList[i].getName() + ", ID : "+ FreshcoStaff.staffList[i].getID());
                    System.out.println();
                    employers[i] = FreshcoStaff.staffList[i].getID();
                }
                
            }
            Boolean found = false;
            while (true)
            {
                choice =  getUserIntValue();
                for(int j= 0; j < employers.length; j ++)
                {
                    if(choice  == employers[j])
                    {
                        FreshcoStaff tempStaff =  FreshcoStaff.getStaffWithId(choice);
                        int numChoices  = displayStaffOptions(tempStaff);
                        found =true;
                        while(true)
                        {
                            int choice2 = getUserIntValue();
                            if((choice2 <= numChoices) && (choice2 > 0))
                            {
                                changeStaffInfo(tempStaff, choice2);
                                break;
                            }
                            else{System.out.println("Input: "+choice2 + " Is Invalid, Please Entre A Valid Number From(1 - "+numChoices+ ")");}
                        }
                        break;
                    }
                    else if(choice == -1){break;}
                }
                if(!found){System.out.println(choice + " Is Not A Choice Please Choose A Id from The Id's Shown Previously Or Entre (-1) To Go Back To Your Option");}
                else if(found){break;}
            }  
        }
        //Get Info Of Staff Serving
        else if(((choice == 4) && (staffServing.getClass().getName().equals(Employee.class.getName()))) ||((choice == 5) && ((staffServing.getClass().getName().equals(Cashier.class.getName())) || (staffServing.getClass().getName().equals(Grocery.class.getName())))) || ((choice == 7) && ((staffServing.getClass().getName().equals(Managers.class.getName())))) || ((choice ==6)&&(staffServing.getClass().getName().equals(Owner.class.getName()))))
        {
            System.out.println(staffServing);
        }
        //Return To Id Menu
        else if(((choice == 5) && (staffServing.getClass().getName().equals(Employee.class.getName()))) ||((choice == 6) && ((staffServing.getClass().getName().equals(Cashier.class.getName())) || (staffServing.getClass().getName().equals(Grocery.class.getName())))) || ((choice == 8) && ((staffServing.getClass().getName().equals(Managers.class.getName())))) || ((choice ==7)&&(staffServing.getClass().getName().equals(Owner.class.getName()))))
        {
            mainMenu();
        }
        //Get Cash Code Of Staff Of Type Cashier
        else if((choice == 4) && (staffServing.getClass().getName().equals(Cashier.class.getName()))){System.out.println("Your Cash Code Is : "+ ((Cashier)staffServing).getCashierCode());}
        //Get Skis Finished By Staff Of Type Grocery
        else if((choice == 4) && (staffServing.getClass().getName().equals(Grocery.class.getName()))){System.out.println("Skids Finished From You : "+ ((Grocery)staffServing).getSkidFinished());}
        //Hire Staff This Methode Is only Accessable By Owner And Manager
        else if(((choice == 4) && (staffServing.getClass().getName().equals(Owner.class.getName()))) ||((choice == 5) && (staffServing.getClass().getName().equals(Managers.class.getName()))))
        {
            System.out.println("Please Seclect The Department In Which You Want To Hire.");
            ArrayList<String> Type = new ArrayList<>(List.of("employee","cashier","grocery","manager"));
            String chooseType, firstName,lastName;
            for(int i=0;i<Type.size();i++)  
            {
                //Managers Cant Hire Other Managers
                if((staffServing.getClass().getName().equals(Owner.class.getName())) || ((staffServing.getClass().getName().equals(Managers.class.getName()))&& !((Type.get(i).equals("manager")))))
                {
                    System.out.println(Type.get(i));   
                }  
            }  
            while (true)
            {
                //Check If Hire Position That Is Givent Is Part Of The Position Shown 
                chooseType = getUserStringInput().toLowerCase();
                if(((Type.contains(chooseType)) && (staffServing.getClass().getName().equals(Owner.class.getName()))) ||((Type.contains(chooseType)) && (staffServing.getClass().getName().equals(Managers.class.getName())) && !(chooseType.equals("manager") )))
                {
                    // Get Info For New Staff Memebers
                    System.out.println("Please Provide First Name : ");
                    firstName = getUserStringInput();
                    System.out.println("Please Provide Last Name : ");
                    lastName = getUserStringInput();
                    System.out.println("Please Confirm Request With (y/n)");
                    //Use Methode hireFreshcoStaff() In Class Owner And Class Manager
                    while(true)
                    {
                        String confirmHiring  = getUserStringInput().toLowerCase();
                        if((confirmHiring.equals("y")) && (staffServing.getClass().getName().equals(Owner.class.getName())))
                        {
                            ((Owner)staffServing).hireFreshcoStaff(firstName + " "+ lastName, chooseType);
                            System.out.println("New "+ chooseType + " Added Succesfully");
                            break;
                        }
                        else if((confirmHiring.equals("y")) && (staffServing.getClass().getName().equals(Managers.class.getName())))
                        {
                            ((Managers)staffServing).hireFreshcoStaff(firstName + " "+ lastName, chooseType);
                            System.out.println("New "+ chooseType + " Added Succesfully");
                            break;  
                        }
                        
                        else if (confirmHiring.equals("n")){System.out.println("Request Stoped");break;}
                        else{System.out.println("Please Provide Confirmation With (y/n) To Confirim Your Request");}
                    }

                    break; 
                }else{System.out.println("Please Entre Depatment Correctly Type Correctly");}
            }
            


        }
        //Fire Staff Memebers
        else if(((choice == 5) && (staffServing.getClass().getName().equals(Owner.class.getName()))) ||((choice == 6) && (staffServing.getClass().getName().equals(Managers.class.getName()))))
        {
            long[] employersID = new long[FreshcoStaff.getStaffNumber()];
            System.out.println("Please Choose One Of The Following Id To Fire, Or Enter (-1) To Go Back To Your Options");
            for(int i =0; i < FreshcoStaff.staffNumber; i++)
            {
                //Display Staff That Can Be Fired
                if((!(FreshcoStaff.staffList[i].getClass().getName().equals(Owner.class.getName())) && ((staffServing.getClass().getName().equals(Owner.class.getName())))) || (((staffServing.getClass().getName().equals(Managers.class.getName())) && !(FreshcoStaff.staffList[i].getClass().getName().equals(Managers.class.getName()))) && !(FreshcoStaff.staffList[i].getClass().getName().equals(Owner.class.getName()))))
                {
                    System.out.println("Name : "+ FreshcoStaff.staffList[i].getName() + ", ID : "+ FreshcoStaff.staffList[i].getID());
                    System.out.println();
                    employersID[i] = FreshcoStaff.staffList[i].getID();
                }
                
            }
            Boolean found = false;
            while (true)
            {
                //Get Id Input From User
                choice =  getUserIntValue();
                for(int j= 0; j < employersID.length; j ++)
                {
                    //Fire Staff Member If Confirmation Is Given
                    if(choice  == employersID[j])
                    {
                        FreshcoStaff staffToFire =  FreshcoStaff.getStaffWithId(choice);
                        System.out.println("Staff To Be Fired : "+staffToFire +"\nPlease Confirm Request With (y/n)");
                        found =true;
                        while(true)
                        {
                            String confimeFire = getUserStringInput().toLowerCase();
                            if(confimeFire.equals("y"))
                            {
                                ((Owner)staffServing).remove(staffToFire);
                                System.out.println("Staff Fired Succsefully");
                                break;
                            }
                            else if(confimeFire.equals("n")){System.out.println("Request Stoped.");break;}
                            else{System.out.println("Please Provide Confirmation With (y/n) To Confirim Your Request");}
                        }
                        break;
                    }//Return To Menu Found Is Used To Break The Loop
                    else if(choice == -1){found = true;break;}
                }
                if(!found){System.out.println(choice + " Is Not A Choice Please Choose A Id from The Id's Shown Previously Or Entre (-1) To Go Back To Your Option");}
                else if(found){break;}
    
            }
        }
    }    
    /**
     * MainMenu Methode This Methode Is Used To Go Back To The Staff List
     * This Methode Can End The Programe
     */
    public static void mainMenu()
    {
        //Print Staff Names And Ids
        System.out.println();
        for(int i =0; i < FreshcoStaff.staffNumber; i++)
        {
            System.out.println("Name : "+ FreshcoStaff.staffList[i].getName() + ", ID : "+ FreshcoStaff.staffList[i].getID());
            System.out.println();
        }
        //Keep Running Until -1 Is Given
        while(true)
        {
            System.out.println("Please Identify Your Self With Your Id.\nEnter -1 To Close Application");
            System.out.println();
            //Get User Id Input
            int id = getUserIntValue();
            if(FreshcoStaff.checkStaffWithId(id) == true)
            {
                int numberOfChoices = 0;
                int choice = 0;
                FreshcoStaff staffServing =  FreshcoStaff.getStaffWithId(id);
                while(true)
                {
                    System.out.println(); 
                    System.out.println("Hi " + staffServing.getName());
                    numberOfChoices = showOptions(staffServing);
                    while(true)
                    {
                        choice =  getUserIntValue();
                        if((choice <= numberOfChoices) &&(choice != 0)){doOption(staffServing, choice);break;}
                        else{System.out.println(choice + "Is Not A Choice Please Choose Numbers From (1 - "+numberOfChoices+ ")");}
                    }
                }  
            }
            else if(id == -1)
            {
                scanner.close();
                System.out.println("Bye");
                System.exit(0);
            }
            else{System.out.println("Id Is Not In FreshCo's System Please Enter A valid Id: To Procced");}  
        }
    }
    public static void main(String[] args) 
    {
        //Making Employee Staff Members, See {@link FreshcoStaff#Employee}
        Employee memo = new  Employee("Memo Aldu", 12.02);
        //Adding Staff "memo" To The List Of freshcoStaff
        FreshcoStaff.AddToList(memo);

        //Making Cashier Staff Members, See {@link Employee#Cashier}
        Cashier yoyo = new Cashier("Yoyo Aldu", 15.6);
        FreshcoStaff.AddToList(yoyo);

        //Making Cashier Staff Members
        Cashier max = new Cashier("Max Richard", 18.6);
        FreshcoStaff.AddToList(max);

        //Making Grocery Staff Members, See {@link Employee#Grocery}
        Grocery nat = new Grocery("Natalie Anne", 20.0);
        FreshcoStaff.AddToList(nat);

        //Making Grocery Staff Members
        Grocery batool = new Grocery("batool Aldu", 21.8);
        FreshcoStaff.AddToList(batool);
        //Changing Skid Count.
        batool.setSkidsFinished(10.0);

        //Making Grocery Staff Members
        Grocery e = new Grocery("Nat Diaz", 20.0, 50.0);
        FreshcoStaff.AddToList(e);

        //Making Managers Staff Members, See {@link Employee#Managers}
        Managers ammar = new Managers("Ammar Aldu", 60);
        FreshcoStaff.AddToList(ammar);

        //Making Managers Staff Members,
        Managers tom = new Managers("Brad Strong", 60);
        FreshcoStaff.AddToList(tom);

        //Making Owner Staff Members, See {@link FreshcoStaff#Owner}
        Owner greg = new Owner("Greg Houdy");
        FreshcoStaff.AddToList(greg);

        System.out.println("Welcome To FreshCo");
            
        System.out.println("STAFF:");

        System.out.println(FreshcoStaff.getStaffNumber());


        mainMenu();

    }
}
