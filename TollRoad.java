package cw2_toll_road;

    /**
    * Date Created: 12-Feb-2019
    * Date last updated: 28-Feb-2019
    * @author rohansamuelh
    */

import java.util.*;
import java.lang.*;

/* 
Create two attributes: one to store a collection of CustomerAccount objects
    And an int moneyMade to keep track of the total money made 
*/
public class TollRoad 
{
    private ArrayList<CustomerAccount> customerAccounts = new ArrayList<>();
    private int moneyMade = 0;
    
    /*
    addCustomer adds a new account to the list of customers associated with this road
    */
    
    public void addCustomer(CustomerAccount acc)
    {
        customerAccounts.add(acc);
    }       
    
    /*
    findCustomer searches through the list of customers associated 
        And return the matching CustomerAccount.
    If no match is found, a CustomerNotFoundException is thrown
    */
    
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
    
    /*
    chargeCustomer searches through all accounts and return the matching CustomerAccount
    If no match exists, a CustomerNotFoundException is thrown
    If a matching account is found, makeTrip() is called on the account
        If successful this is then added to moneyMade 
        Else a InsufficientAccountBalanceException is thrown
    */
    
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
