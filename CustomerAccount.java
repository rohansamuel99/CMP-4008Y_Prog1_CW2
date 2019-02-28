package cw2_toll_road;

    /**
    * Date Created: 12-Feb-2019
    * Date last updated: 22-Feb-2019
    * @author rohansamuelh
    */

public class CustomerAccount implements Comparable <CustomerAccount>
{
    
    private String firstName;
    
    private String lastName;
    
    private Vehicle customerVehicle;
    
    private int startingBalance;
   /* 
    private String registrationNumber; 
    
    private int amount;
    */
    
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
    
    public void activateStaffDiscount()
    {
        discount = DiscountType.STAFF;    
    }
    
    public void activateFriendsAndFamilyDiscount()
    {
        if(discount != DiscountType.STAFF )
        {
            discount = DiscountType.FRIENDS_AND_FAMILY;
        }   
    }
    
    public void deactivateDiscount()
    {
        discount = DiscountType.NONE;
    }
    
    public void addFunds(int amount)
    {
        startingBalance += amount;   
    }
    
    public int makeTrip() throws InsufficientAccountBalanceException
    {
        
        int cost = customerVehicle.calculateBasicTripCost();
        
        if(discount == DiscountType.STAFF)
        {
            cost = (int) (0.5 * cost);
        }
        else if(discount == DiscountType.FRIENDS_AND_FAMILY) 
        {
            cost = (int) (0.9 * cost);
        }
        
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
      
}
