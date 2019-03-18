package cw2_toll_road;

    /**
    * Date Created: 12-Feb-2019
    * Date last updated: 12-Feb-2019
    * @author rohansamuelh
    */

/*
Van.java is a subclass of Vehicle.java
Stores int payload,
    To store the amount of cargo(in kilograms)
*/

public class Van extends Vehicle 
{
    
    private int payload;
    
    /*
    Override calculateBasicTripCost
    Returns 500 if the payload is leass than or equal to 600kg
    Returns 750 if the payload is leass than or equal to 800kg,
        But greater than 600kg
    Returns 1000 if the payload is greater than 800kg
    */
    
    @Override
    public int calculateBasicTripCost()
    {
        
        if(payload <= 600)
        {
            return 500;
        } 
        
        else if(payload <= 800)
        {
            return 750;
        }
        
        else
        {
            return 1000;
        }    
        
    }
    
    /*
    Create a constructor for Van 
        To set all the fields
    */
    
    public Van(String plates, String manufacturer, int payload)
    {
        super(plates, manufacturer);
        this.payload = payload;
        
    }
    
    public static void main (String[] args)
    {
        Van vanTest = new Van("OX164GH","Volkswagen",1500);
        System.out.println(vanTest.calculateBasicTripCost());
        //Testing successful
    }
    
    
    
}
