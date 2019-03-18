package cw2_toll_road;

    /**
    * Date Created: 12-Feb-2019
    * Date last updated: 28-Feb-2019
    * @author rohansamuelh
    */

/*
This is the main method class, TollRoadMain
Should have three attributes:
    initialiseTollRoadFromFile()
    simulateFromFile(TollRoad road)
    main
*/


import java.io.*;
import java.util.*;

public class TollRoadMain {

    
    /*
    Creates a new TollRoad
    */
    
    public static TollRoad initialiseTollRoadFromFile() throws Exception
    {
        
        /*
        Reads customerData.txt to populate this road with new CustomerAccount objects
        */
        BufferedReader bufferedReader = new BufferedReader(new FileReader("/Users/rohansamuelh/NetbeansProjects/CW2_TOLL_ROAD/src/cw2_toll_road/customerData.txt"));

        String lineReader = bufferedReader.readLine();
       
        /*
        Splits each customer's information from the hash(#)
        Splits each piece information from the comma(,)
        */
        
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

            int vehicleInf      = Integer.parseInt(customerHelp[5]);

            int startingBalance         = Integer.parseInt(customerHelp[6]);

            String discountType         = customerHelp[7];
            
            Vehicle vehicleInformation             = null;
            
            if(vehicleType.equals("Car"))
            {
                vehicleInformation = new Car(regNum, vehicleMake, vehicleInf);
            }
            else if(vehicleType.equals("Truck"))
            {
                vehicleInformation = new Truck(regNum, vehicleMake, vehicleInf);
            }
            else if(vehicleType.equals("Van"))
            {
                vehicleInformation = new Van(regNum, vehicleMake, vehicleInf);
            }

            CustomerAccount customerAccount = new CustomerAccount(firstName, lastName, vehicleInformation, startingBalance);
           
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
    
    /*
    Reads transactions.txt and carries out the actions listed in the file on the toll road
    Splits each line from the '$' sign
    Splits each piece of information from the comma(,)
    */
    
    public static void simulateFromFile(TollRoad road) throws Exception
    {
        
        BufferedReader buffReader = new BufferedReader(new FileReader("/Users/rohansamuelh/NetbeansProjects/CW2_TOLL_ROAD/src/cw2_toll_road/transactions.txt"));

        String linReader = buffReader.readLine();

        String[] simulateFile = linReader.split("\\$");
        
        for( int i = 0; i < simulateFile.length; i++)
        {
            String[] fileTransactions = simulateFile[i].split(","); 
            String registrationNumber = fileTransactions[1];
            
            /*
            If the instruction is addFunds it will call the appropriate methods to add amount
                To the balance of the account with the registration registrationNumber
            If the operation is unsuccessful it should catch the Exception and print a message
            */
            
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
            
            /*
            If the instruction is makeTrip, a trip is attempted with the account that matched the specific registrationNumber
            If the trip is not successful it shoudl catch the Exception and print a message
            */
            
            else if(fileTransactions[0].equals("makeTrip"))
            {
                
                try
                {
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
         
    /*
    This is the project's main method
    It creates a TollRoad using the initialiseTollRoadFromFile method
         then calls the simulateFromFile method as the argument
    And finally prints the total money made from the toll road during the simulation
    */
    
    public static void main (String[] args) throws IOException
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
