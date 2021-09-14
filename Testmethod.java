

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * @Class test methodes in (see {@link FreshcoStaff}, see {@link Employee}, see {@link Grocery}, see {@link Cashier} , see {@link Managers})
 * This class uses Junit 5, results of the tests are shown in a window in Vs code named " Java Test Report".
 */
public class Testmethod
{
    /**
     * 
     */
    public static Employee empTest = new Employee("Test1", 10);
    public static Cashier cashTest = new Cashier("Test2", 10.25);
    public static Owner OwnerTest = new Owner("Test3");
    public static Grocery groceryTest = new Grocery("Test4", 10.5);
    /**
     * Test Methode, see {@link FreshcoStaff#AddToList}
     */
    
    @Test
    public void addStaffTest()
    {
        FreshcoStaff.AddToList(cashTest);
        assertTrue(cashTest == FreshcoStaff.getStaffWithId(cashTest.getID()));
    }
    /**
     * Test Methode, see {@link Owner#remove}
     */
    @Test
    public void removeStaffTest()
    {
        OwnerTest.remove(cashTest);
        assertNull(FreshcoStaff.getStaffWithId((cashTest.getID())));
    }
    /**
     * Test Methode, see {@link Employee#setHours}
     */
    @Test
    public void changeHours()
    {
        cashTest.setHours(50.24);
        double expected = 50.24;
        assertEquals( expected, cashTest.getHours());
    }
    /**
     * Test Methode, see {@link Employee#calcSalary}
     */
    @Test
    public void testSalary()
    {
        double expected = 678.24;
        double result = cashTest.calcSalary();
        assertEquals( expected, result);
    }
    /**
     * Test Methode, see {@link FreshcoStaff#setName}
     */
    @Test
    public void testChangeName()
    {
        cashTest.setName("pop1");
        String expected = "pop1";
        assertEquals(expected, cashTest.getName());
    }
    /**
     * Test Methode, see {@link Cashier#changeCashierCode}
     */
    @Test
    public void testchangeCashCode()
    {
        int currentCashCode = cashTest.getCashierCode();
        cashTest.changeCashierCode();
        assertNotEquals(currentCashCode, cashTest.getCashierCode());
    }
    /**
     * Test Methode, see {@link Grocery#calcSalary}
     */
    @Test
    public void calculateSalaryWithSkid()
    {
        double salaryBefore = groceryTest.calcSalary();
        groceryTest.setSkidsFinished(10.0);
        double newSalary = groceryTest.calcSalary();
        assertNotEquals(salaryBefore, newSalary);
    }
    /**
     * Test Methode, see {@link Grocery#getSkidFinished}
     */
    @Test
    public void testGetSkid()
    {
        double result = groceryTest.getSkidFinished();
        assertEquals(10.0, result);
    }
    /**
     * Test Methode, see {@link Owner#promote}
     */
    @Test
    public void testPromote()
    {
        String classTypeBefore = empTest.getClass().getName();
        OwnerTest.promote(empTest,"manager");
        assertNotEquals(classTypeBefore, FreshcoStaff.getStaffWithId((empTest.getID())).getClass().getName());
    }
    /**
     * Test Methode, see {@link Employee#getNumEmployers}
     */
    @Test
    public void testEmployeeNumber()
    {
        int expected = 4;
        assertEquals( expected, Employee.getNumEmployers());
    }
}