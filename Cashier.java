/**
 * @author Memo Aldujaili
 * Class Cashier, final Class
 * Creat Cashier Staff, Class Cashier Extends {@link Employee}
 */
public final class Cashier extends Employee
   {
   /**
    * cashierCode 4 Dighet Code For Cash Machine
    */
   private int cashierCode;
         
   /**
    * Cashier Constructor, Takes 2 arguments And Calls Super Class Constructor {@link Employee}
    * @param name Name Of Staff
    * @param hours Hours Clocked By Staff
    * Generate 4 Dighet Code see {@link #generateCashCode}
    */
   public Cashier(String name, double hours) 
   {
      super(name, hours);
      this.cashierCode = generateCashCode();
   }

   /**
    * Cashier Constructor, Takes 3 arguments And Calls Super Class Constructor {@link Employee} 
    * @param name Name Of Staff
    * @param hours Hours Clocked By Staff
    * @param id Id Of Staff
    * Generate 4 Dighet Code see {@link #generateCashCode}
    */
   protected Cashier(String name, double hours, int id) 
   {
      super(name, hours, id);
      this.cashierCode = generateCashCode();
   }
   /**
    * @return Cashier Code, As Int
    */
   public int getCashierCode()
   {
      return this.cashierCode;
   }
   /**
    * Change cashierCode
    */
   public void changeCashierCode()
   {
      this.cashierCode = generateCashCode();
   }

   /**
    * This Methode Generates A 4 digit Code
    * @return 4 Dighet Number, As Int
    */
   public int generateCashCode()
   {
      int Code = 0;
      boolean avalable  = false;
      while (true)
      {
         int fourDigit = rand.nextInt(9999);
         avalable = checkCashCode(fourDigit);
         if(avalable == true)
         {
            Code = fourDigit;
            break;
         }
      }
      return Code;
   }

   /**
    * This Methode Checks If The Cash Code Exist With Other Staff
    * @param code 4 digit Number
    * @return boolean, True If cashCode Is Unique And False If cashCode Exist With Other Staff 
    */
   private boolean checkCashCode(int code) {
   Boolean isAvalable = false;
   if (staffNumber != 0)
   {
      for (int i = 0; i < staffNumber; i++)
      {
         if(staffList[i].getClass().getName().equals(Cashier.class.getName()))
         {
            if(code == ((Cashier) staffList[i]).getCashierCode())
            {
               isAvalable = false;
               break;
            }
         }
         
         else
         {
            isAvalable = true;
         }
      }
   }
   else
   {
      isAvalable = true;
         
   }
   return isAvalable;
   
   }

   @Override
   public String toString()
   {
      return "Chasier department"+", Name: "+ getName() + ", ID: " + getID()  + ", Hours clocked: " + getHours() + ", Cashier Acsses Code: "  + getCashierCode() + ", Salary: "+ calcSalary()+"$";
   }

}
