/**
 * @author Memo Aldujaili
 * Class Owner, final Class
 * Creat Owner Staff, Class Owner Extends {@link FreshcoStaff}
 */
public final class Owner extends FreshcoStaff
{

   /**
   * Owner Constructor, Takes 1 arguments And Calls Super Class Constructor {@link FreshcoStaff} 
   * @param name Name Of Owner
   */
   public Owner(String name) 
   {
      super(name);

   }

   /**
    * This Methode Is Used To Change Staff Class Type
    * And It Calls See {@link #remove} And {@link #AddToList}
    * @param staff FreshcoStaff Instance 
    * @param promotion Class Name, As String
    */
   public void promote(FreshcoStaff staff, String promotion)
   {
      if(promotion.equals("employee"))
      {
         Employee a = new Employee(staff.getName(), 0 ,staff.getID());
         remove(staff);
         AddToList(a);
      }
      else if(promotion.equals("cashier"))
      {
         Cashier b = new Cashier(staff.getName(), 0, staff.getID()) ;
         remove(staff);
         AddToList(b);
      }
      else if(promotion.equals("grocery"))
      {
         Grocery c = new Grocery(staff.getName(),0, staff.getID());
         remove(staff);
         AddToList(c);
      }
      else if(promotion.equals("manager"))
      {
         Managers d = new Managers(staff.getName(),0, staff.getID());
         remove(staff);
         AddToList(d);
      }
   }
   
   /**
    * This Methode Is Used To Remove Staff Memeber
    * This Methode Calls {@link #arangeList}
    * @param staff FreshcoStaff To Be Removed From staffList[]
    */
   public void remove(FreshcoStaff staff)
   {
      for(int i = 0; i < staffNumber; i++)
      {
      if (staffList[i].equals(staff))
         {
            if(staff.equals(this))
            {
               System.out.println("Owner cannot remove him self");
               break;
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
    * This Methode Is Used To Make new Instance That Aren't Of Type Owenr.
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
      else if(ClassType.equals("manager"))
      {
          Managers newStaff = new Managers(name, 0.0);
          FreshcoStaff.AddToList(newStaff); 
      }     
   }
   @Override
   public String toString()
   {
      return "Status : Owner" + ", Name: " + getName()+ ", ID: " + getID();
   }
      
}
