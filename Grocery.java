/**
 * @author Memo Aldujaili
 * Class Grocery, final Class
 * Creat Grocery Staff, Class Grocery Extends {@link Employee}
 */
public final class  Grocery extends Employee
{
   /**
    * BONUSPERSKID Is Bonus To Salary For Every skidsFinished
    * skidsFinished Is Total Number Of Skids Finished
    */
   private static final double BONUSPERSKID = 0.10;
   private Double skidsFinished;

   /**
    * Grocery Constructor, Takes 2 arguments And Calls Super Class Constructor {@link Employee} 
    * @param name Name Of Staff
    * @param Hours Numbers Of Hours Clocked By EMployee
    */
   public Grocery(String name, double Hours) 
   {
      super(name, Hours);
      this.skidsFinished = 0.0;
   }

   /**
    * Grocery Constructor, Takes 3 arguments And Calls Super Class Constructor {@link Employee} 
    * @param name Name Of Staff
    * @param Hours Numbers Of Hours Clocked By Employee
    * @parma NumSkids Number Of Skids Finished
    */
   public Grocery(String name, double Hours, Double NumSkids) 
   {
      super(name, Hours);
      this.skidsFinished = NumSkids;
   }
   /**
    * Grocery Constructor Used To Change Staff Type, Takes 3 arguments And Calls Super Class Constructor {@link Employee} 
    * @param name Name Of Staff
    * @param Hours Numbers Of Hours Clocked By Employee
    * @param id Id Of Staff
    */
   protected Grocery(String name, double Hours, int id) 
   {
      super(name, Hours, id);
      this.skidsFinished = 0.0;
   }
   /**
    * 
    * @return Number Of Skids Finished
    */
   public double getSkidFinished()
   {
      return this.skidsFinished;
   }
   
   /**
    * Changes The Number Of skidsFinished
    * @param newSkidCount New Skid Count
    */
   public void setSkidsFinished(Double newSkidCount)
   {
      this.skidsFinished = newSkidCount;
   }
   /**
    * This Methode Calulates The Salary Of A Grocery Employer, This Includes Bonus From skidsFinished
    */
   @Override
   public double calcSalary() 
   {
      return Math.round((super.calcSalary() + skidsFinished*BONUSPERSKID) * 100.0) / 100.0;
   }
         
   @Override
   public String toString()
   {
      return "Grocery depatment" +", Name: "+ getName() + ", ID: " + getID()  + ", Hours clocked: " + getHours() + ", Ammount of Skids finished: " + getSkidFinished() +", Salary: "+ calcSalary() +"$";
   }

}
