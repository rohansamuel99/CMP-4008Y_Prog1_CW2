package cw2_toll_road;

    /**
    * Date Created: 12-Feb-2019
    * Date last updated: 28-Feb-2019
    * @author rohansamuelh
    */

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class TollRoadMain {

    
    
    public static TollRoad initialiseTollRoadFromFile() throws Exception
    {

        BufferedReader bufferedReader = new BufferedReader(new FileReader("/Users/rohansamuelh/NetbeansProjects/CW2_TOLL_ROAD/src/cw2_toll_road/customerData.txt"));

        String lineReader = bufferedReader.readLine();

        String[] individualTransactions = lineReader.split("#");

        TollRoad tollRoad = new TollRoad();

        for(int i = 0; i < individualTransactions.length; i++)
        {
            String[] customerHelp = individualTransactions[i].split(",");

            String vehicleType          = customerHelp[0];

            String regNum               = customerHelp[1];

            String firstName            = customerHelp[2];

            String lastName             = customerHelp[3];

            String vehicleMake          = customerHelp[4];

            int vehicleInformation      = Integer.parseInt(customerHelp[5]);

            int startingBalance         = Integer.parseInt(customerHelp[6]);

            String discountType         = customerHelp[7];
            
            Vehicle vehicle             = null;
            
            if(vehicleType.equals("Car"))
            {
                vehicle = new Car(regNum, vehicleMake, vehicleInformation);
            }
            else if(vehicleType.equals("Truck"))
            {
                vehicle = new Truck(regNum, vehicleMake, vehicleInformation);
            }
            else if(vehicleType.equals("Van"))
            {
                vehicle = new Van(regNum, vehicleMake, vehicleInformation);
            }

            CustomerAccount customerAccount = new CustomerAccount(firstName, lastName, vehicle, startingBalance);
           
            if(discountType.equals("STAFF"))
            {
                customerAccount.activateStaffDiscount();
            }
            else if(discountType.equals("FRIENDS_AND_FAMILY"))
            {
                customerAccount.activateFriendsAndFamilyDiscount();
            }
            
            tollRoad.addCustomer(customerAccount);

        }
        return tollRoad;
    }
    
    public static void simulateFromFile(TollRoad road) throws Exception
    {
        
        BufferedReader buffReader = new BufferedReader(new FileReader("/Users/rohansamuelh/NetbeansProjects/CW2_TOLL_ROAD/src/cw2_toll_road/transactions.txt"));

        String linReader = buffReader.readLine();

        String[] simulateFile = linReader.split("\\$");
        
        for( int i = 0; i < simulateFile.length; i++)
        {
            String[] fileTransactions = simulateFile[i].split(","); 
            String registrationNumber = fileTransactions[1];

            if (fileTransactions[0].equals("addFunds"))
            {
                try
                {
                    CustomerAccount findAccount = road.findCustomer(registrationNumber);
                    int amount = Integer.parseInt(fileTransactions[2]);
                    findAccount.addFunds(amount);
                    System.out.println(registrationNumber + ": " + amount + " added successfully");
                }
                catch(CustomerNotFoundException ex)
                {
                    System.out.println(registrationNumber + ": addFunds failed. CustomerAccount does not exist");
                }
                
            }
            else if(fileTransactions[0].equals("makeTrip"))
            {
                
                try
                {
                    //CustomerAccount findAccount = road.findCustomer(registrationNumber);
                    //findAccount.makeTrip();
                    road.chargeCustomer(registrationNumber);
                    System.out.println(registrationNumber + ": Trip completed successfully");
                }
                catch(CustomerNotFoundException ex)
                {
                    System.out.println(registrationNumber + ": makeTrip failed. CustomerAccount does not exist");
                }
                catch(InsufficientAccountBalanceException ex)
                {
                    System.out.println(registrationNumber + ": makeTrip failed. Insufficient funds");
                }
                
            }
        }
        
    }
            
    public static void main (String[] args)
    {
        try
        {
            TollRoad intializer = initialiseTollRoadFromFile();
            simulateFromFile(intializer);
            System.out.println(intializer.getMoneyMade());
        }
        catch (Exception ex)
        {
           ex.printStackTrace();
        }
       
    }
    
}
