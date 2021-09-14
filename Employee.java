/**
 * @author Memo Aldujaili
 * Creat Employee, Employee Class Extends {@link FreshcoStaff}
 */
public class Employee extends FreshcoStaff
{
   /**
    * PAYRATE, Is The Price At What Managers Gets Payed
    * numberOfEmployers Is Totale Employee Count
    * hours Is Hours Clocked By Employee
    */
   private static final double PAYRATE = 13.50;
   private static int numberOfEmployers;
   private double hours;

   /**
    * Employee Constructor, Takes 2 arguments And Calls Super Class Constructor {@link FreshcoStaff}  
    * @param name Name Of Employee As String
    * @param hours Hours Clocked By Employee As Double
    */
   public Employee(String name, double hours) 
   {
      super(name);
      this.hours = hours;
      numberOfEmployers++;
   }

   /**
    * Employee Constructor, Takes 3 arguments And Calls Super Class Constructor {@link FreshcoStaff}
    * @param name Name Of Employee 
    * @param hours Hours Of Employee 
    * @param id Id Of Employee
    */
   protected Employee(String name, double hours, int id) 
   {
      super(name, id);
      this.hours = hours;
      numberOfEmployers++;
   }
   /**
    * @return numberOfEmployers, As Int
    */
   public static int getNumEmployers()
   {
      return numberOfEmployers;
   }

   /**
    * 
    * @return Hours Of Employee, As double
    */
   public double getHours()
   {
      return this.hours;
   }

   /**
    * Changes Hours Of Employee
    * @param newHours New Hours Of Employee
    */
   public void setHours(double newHours)
   {
      this.hours = newHours;
   }

   /**
    * Calculates The Salary Of Employee
    * @return Salary Of Employye, As double
    */
   public double calcSalary()
   {
      return Math.round((this.hours*PAYRATE) * 100.0) / 100.0;
   }

   @Override
   public String toString()
   {
      return "Status : Employee, Name: "+ getName() + ", ID: " + getID()  + ", Hours clocked: " + getHours()  + ", Salary: " + calcSalary() + "$";
   }
}
