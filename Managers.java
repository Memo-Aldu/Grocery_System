/**
 * @author Memo Aldujaili
 * Class Managers, final Class
 * Creat Managers Staff, Class Managers Extends {@link Employee}
 */
public final class Managers extends Employee
{
   /**
    * PAYRATE, Is The Price At What Managers Gets Payed
    */
   private static final int PAYRATE = 20;
   
   /**
    * Managers Constructor, Takes 2 arguments And Calls Super Class Constructor {@link Employee} 
    * @param name Name Of Staff
    * @param hours Hours Clocked By Staff
    */
   public Managers(String name, double hours) 
   {
      super(name, hours);
   }

   /**
    * Managers Constructor, Takes 3 arguments And Calls Super Class Constructor {@link Employee} 
    * This Constructor Is Used To Change Type Of Staff Member
    * @param name Name Of Staff
    * @param hours Hours Clocked By Staff
    * @param id Id Of Staff
    */
   protected Managers(String name, double hours, int id)
   {
      super(name, hours, id);
   }

   /**
    * This Methode Calculates The Salary Of The Managers
    * @return Salary Of Manager, As double
    */
   public double managerSalary()
   { 
      return Math.round((getHours()*PAYRATE) * 100.0) / 100.0;
   }

   /**
    * This Methode Is Used To Remove Staff Memeber That Aren't Managers Or Owners
    * @param staff FreshcoStaff To Be Removed From staffList[]
    */
   public void remove(FreshcoStaff staff)
   {
      for(int i = 0; i < staffNumber; i++)
      {
      if (staffList[i].equals(staff))
         {
            if(staff.getClass().getName().equals(Owner.class.getName()))
            {
               System.out.println("You Don't Have Permission To Remove The Owner");
               break;
            }
            else if(staff.getClass().getName().equals(Managers.class.getName()) && (staff.equals(this) == false))
            {
               System.out.println("You Don't Have Permisson To Remove Other Managers");
            }
            else if (staff.equals(this))
            {
               System.out.println("You Can't Remove Your self");
            }
            else
            {
               staffList[i] = null;
               arangeList();
               staffNumber --;
               break;
            }
         }
      }

   }

   /**
    * This Methode Is Used To Make new Instance That Aren't Of Type Owenr Or Managers
    * @param name Name Of The New Staff
    * @param ClassType  Class Name, As String
    */
   public void hireFreshcoStaff(String name, String ClassType)
   {

      if(ClassType.equals("employee"))
      {
          Employee newStaff = new Employee(name, 0.0);
          FreshcoStaff.AddToList(newStaff);
      }
      else if(ClassType.equals("cashier"))
      {
          Cashier newStaff = new Cashier(name, 0.0);
          FreshcoStaff.AddToList(newStaff);
      }
      else if(ClassType.equals("grocery"))
      {
          Grocery newStaff = new Grocery(name, 0.0);
          FreshcoStaff.AddToList(newStaff);

      }   
   }

   @Override
   public String toString()
   {
      return "Status : Manager" + ", Name: " + getName()+ ", ID: " + getID()  + ", Hours clocked: " + getHours() + ", Salary: "  + managerSalary() + "$";
   }

}