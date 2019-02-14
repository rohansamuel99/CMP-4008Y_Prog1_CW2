package cw2_toll_road;

    /**
    * Date Created: 12-Feb-2019
    * Date last updated: 14-Feb-2019
    * @author rohansamuelh
    */

public class CustomerAccount 
{
    
    private String firstName;
    private String secondName;
    private Vehicle customerVehicle;
    private int currentAccountBalance;
    
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
        currentAccountBalance += amount;   
    }
    
    
    
    
}
