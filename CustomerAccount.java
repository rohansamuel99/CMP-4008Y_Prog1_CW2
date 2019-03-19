package cw2_toll_road;

import java.util.logging.Level;
import java.util.logging.Logger;

    /**
    * Date Created: 12-Feb-2019
    * Date last updated: 22-Feb-2019
    * @author rohansamuelh
    */

/*
CustomerAccount used to store information about customer 
    i.e. name, account balance, vehicle, discount type, account balance
Class also implements an enum - DiscountType 
    with values: NONE, STAFF, FRIENDS_AND_FAMILY
Class implements Comparables
*/

public class CustomerAccount implements Comparable <CustomerAccount>
{
    
    private String firstName;
    
    private String lastName;
    
    private Vehicle customerVehicle;
    
    private int startingBalance;
   
    
    public CustomerAccount(String firstName, String secondName, Vehicle customerVehicle, int currentAccountBalance)
    {
        this.firstName = firstName;
        this.lastName = secondName;
        this.customerVehicle = customerVehicle;
        this.startingBalance = currentAccountBalance;
        
    }

    
    public Vehicle getCustomerVehicle()
    {
        return customerVehicle;
    }
    
    /*
    compareTo method should compare this account to another CustomerAccount
    */
    
    @Override
    public int compareTo(CustomerAccount o) 
    {
        return customerVehicle.getRegistrationPlate().compareTo(o.getCustomerVehicle().getRegistrationPlate());
    }
    
    private enum DiscountType
    {
        NONE,
        STAFF,
        FRIENDS_AND_FAMILY;
    }
    
    private DiscountType discount = DiscountType.NONE;
    
    /*
    To set the discount type of this account to be STAFF
    */
    
    public void activateStaffDiscount()
    {
        discount = DiscountType.STAFF;    
    }
    
    /*
    To set the discount type of this account to be FRIENDS_AND_FAMILY
        But only if the account doesnt already have an active STAFF discount
    */
    
    public void activateFriendsAndFamilyDiscount()
    {
        if(discount != DiscountType.STAFF )
        {
            discount = DiscountType.FRIENDS_AND_FAMILY;
        }   
    }
    
    /*
    Removes any active discount on the account
    */
    
    public void deactivateDiscount()
    {
        discount = DiscountType.NONE;
    }
    
    /*
    Adds more credit to the account balance
    */
    
    public void addFunds(int amount)
    {
        startingBalance += amount;   
    }
    
    /*
    Simulate the customer making a trip on the toll road
    Then calculate trip cost by calling the correct calculateBasicTripCost method
    */
    
    public int makeTrip() throws InsufficientAccountBalanceException
    {
        
        int cost = customerVehicle.calculateBasicTripCost();
        
        /*
        Cost is discounted by 50% for staff members
            And 10% for friends and family
        */
        
        if(discount == DiscountType.STAFF)
        {
            cost = (int) (0.5 * cost);
        }
        else if(discount == DiscountType.FRIENDS_AND_FAMILY) 
        {
            cost = (int) (0.9 * cost);
        }
        
        /*
        If the account has sufficient funds to make this trip, 
            The account balance should be reduced by cost of the trip and the method
            should then return the cost of the trip as an int. 
        If the account does not have a sufficient balance, 
            the method should throw an InsufficientAccountBalanceException.
        */
        
        if(startingBalance >= cost)
        {
           startingBalance -= cost;
           return cost;
        } 
        else
        {
            throw new InsufficientAccountBalanceException();
        }
        
    }
    
    @Override
    public String toString() 
    {
        String custString = null;
        try 
        {
            custString = "First Name: " + this.firstName +  ";" + " Second Name: " + this.lastName 
                    + ";" +" Vehicle Information: " + this.customerVehicle + ";" + " ACcount Balance: " + this.startingBalance + ";" + "Trip Cost: " + makeTrip();
            return custString;
        } 
        catch (InsufficientAccountBalanceException ex) 
        {
            Logger.getLogger(CustomerAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
        return custString;
    }
    
    public static void main (String[] args) throws Exception
    {
        CustomerAccount custAccountTest = new CustomerAccount ("Felica","Oates",new Car("PP56ICC","Ford",5),13000);
        System.out.println (custAccountTest.toString());
        CustomerAccount custAccountTest2 = new CustomerAccount ("Jack","Demonakis",new Car("JD56ICC","Mini",8),1000);
        System.out.println (custAccountTest2.toString());
        CustomerAccount custAccountTest3 = new CustomerAccount ("P","Jay",new Van("PJ56ICC","Ford",200),8000);
        System.out.println (custAccountTest3.toString());
        CustomerAccount custAccountTest4 = new CustomerAccount ("Matt","Wether",new Van("MW56ICC","Ford",700),12000);
        System.out.println (custAccountTest4.toString());
        CustomerAccount custAccountTest5 = new CustomerAccount ("Dan","Gee",new Van("DG56ICC","Ford",2000),18000);
        System.out.println (custAccountTest5.toString());
        CustomerAccount custAccountTest6 = new CustomerAccount ("George","Shortman",new Truck("GS56ICC","Leyland",1),20000);
        System.out.println (custAccountTest6.toString());
        CustomerAccount custAccountTest7 = new CustomerAccount ("Taylor","Rutt",new Truck("TR56ICC","Leyland",3),9000);
        System.out.println (custAccountTest7.toString());
        //Testing successful
    }
      
}
