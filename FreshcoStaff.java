import java.util.Random;

/**
 * @author Memo Aldujaili
 * Creat Staff Memebers At A Company Named Freshco
 * Class FreshcoStaff
 */
public class FreshcoStaff
{
   /**
    * Name Of Staff
    * Id Of Staff
    */
   private String name;
   private final int id;
   /**
    * stafNumber Is Total Number Of Staff
    * StaffList Is List Of Type(FreshcoStaff) Max Capacity Is 100
    */
   protected static int staffNumber;
   protected static FreshcoStaff[] staffList = new FreshcoStaff[100];
   /**
    * rand 
    * @see Random
    */
   protected static Random rand = new Random();

   /**
    * FreshcoStaff Constructor, Takes 1 Argument
    * @param name Name Of Staff
    * Creats Id
    * @see #MakeId
    */
   public FreshcoStaff(String name)
   {
      this.name = name;
      this.id = MakeId();
   }
   /**
    * FreshcoStaff Constructor, Takes 2 Argument, Used For Changing Object Type While Keeping Same Id
    * @param name Name Of Staff
    * @param id Id Of Staff
    */
   protected FreshcoStaff(String name,int id)
   {
      this.name = name;
      this.id = id;
   }

   /**
    * 
    * @return Staff List, as FreshcoStaff[]
    */
   public static FreshcoStaff[] getStaffList()
   {
      return staffList;
   }
   /**
    * @param Id Id Of Staff
    * @return boolean, True If Staff Exist And False If Staff Does Not Exist In staffList[] See {@link #staffList}
    */
   public static boolean checkStaffWithId(int id)
   {
      boolean exist = false;
      for(int i = 0; i < staffNumber; i ++)
      {
         if(staffList[i].getID() == id)
         {
            exist = true;
            break;
         }

      }
      return exist;
   }

   /**
    * Get Staff From Id 
    * @param id Id Of Staff
    * @return Staff In staffList[] See {@link #staffList}, As FreshcoStaff
    */
   public static FreshcoStaff getStaffWithId(int id)
   {
      FreshcoStaff tempStaff = null;
      for(int i = 0; i < staffNumber; i++)
      {
         if(staffList[i].getID() == id)
         {
            tempStaff = staffList[i];
            break;
         }
      }
      return tempStaff;
   }
   /**
    * 
    * @return Name Of Staff, As String
    */
   public String getName()
   {
      return this.name;
   }
   /**
    * 
    * @return Id Of Staff, As Int
    */
   public int getID()
   {
      return this.id;
   }
   /**
    * Change Name Of Staff
    * @param name Name Of Staff
    */
   public void setName(String name)
   {
      this.name = name;
   }
   /**
    * @return Staff Number Count In staffList[] See {@link #staffList}, As Int
    */

   public static int getStaffNumber()
   {
      return staffNumber;
   }

   /**
    * Add Staff To List staffList[] See {@link #staffList}
    * @param staff Staff Member, Type FreshcoStaff
    */
   public static void AddToList(FreshcoStaff staff)
   {
      staffNumber ++;
      staffList[staffNumber-1] = staff;
      
   }

   /**
    * Delete Null Staff
    */
   public static void arangeList()
   {
      for(int i = 0; i < staffNumber; i++)
      {
         if (staffList[i] == null && staffList[i+1] != null)
         {
            staffList[i] = staffList[i+1];
            staffList[i+1] = null;
         }
      }
   }

   /**
    * Creat Unique 6 digit Id, Checks Avabality See {@link #checkId}
    * @return Id, As Int
    */
   private static int MakeId()
   {
      int ID = 0;
      while (true)
      {
         int SixDig = rand.nextInt(900000);
         if(checkId(SixDig) && ((SixDig/100000.0) >= 1))
         {
            ID = SixDig;
            break;
         }
      }
      return ID;

   }
   /**
    * 
    * @param id Id Of Staff, Type Int
    * @return boolean, True If Id Is Unique And False If Id Exist With Other Staff
    */
   private static boolean checkId(int id)
   {
   Boolean idIsAvalable = false;
   if (staffNumber != 0)
   {
      for (int i = 0; i < staffNumber; i++)
      {
         if(id == staffList[i].getID())
         {
            idIsAvalable = false;
            break;
         }
         else
         {
            idIsAvalable = true;
         }
      }
   }
   else
   {
      idIsAvalable = true;
      
   }
   return idIsAvalable;

   }
   @Override
   public String toString()
   {
      return "Name: "+ getName() + ", ID: " + getID();
   }
}



