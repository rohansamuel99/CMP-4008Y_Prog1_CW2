package cw2_toll_road;

    /**
    * Date Created: 12-Feb-2019
    * Date last updated: 28-Feb-2019
    * @author rohansamuelh
    */

import java.util.*;
import java.lang.*;

public class TollRoad 
{
    ArrayList<CustomerAccount> customerAccounts = new ArrayList<>();
    private int moneyMade = 0;
    
    public void addCustomer(CustomerAccount acc)
    {
        customerAccounts.add(acc);
    }       
    
    public CustomerAccount findCustomer(String regNum) throws CustomerNotFoundException
    {
       for(int i = 0; i < customerAccounts.size(); i++)
       {
           CustomerAccount account = customerAccounts.get(i);
           
           if (account.getCustomerVehicle().getRegistrationPlate().equals(regNum))
           {
               return account;
           }
           
       }
       throw new CustomerNotFoundException();
    }
    
    public void chargeCustomer(String registrationNumber) throws Exception
    {
            CustomerAccount charge = findCustomer(registrationNumber);
            moneyMade += charge.makeTrip();
    }
    
    public int getMoneyMade()
    {
        return moneyMade;
    }
}
