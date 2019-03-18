package cw2_toll_road;

    /**
    * Date Created: 12-Feb-2019
    * Date last updated: 13-Feb-2019
    * @author rohansamuelh
    */

/*
Truck.java is a subclass of Vehicle.java
Stores int numTrailers,
    To store the number of trailer fitted to the truck
*/

public class Truck extends Vehicle
{
    
    private int numTrailers;
    
     /*
    Override calculateBasicTripCost
    Returns 1250 if the truck has no trailer or a single trailer
    Returns 1500 if the truck has two or more trailers
    */
    
    @Override
    public int calculateBasicTripCost()
    {
        
        if(numTrailers <= 1)
        {
            return 1250;
        } 
        
        else
        {
            return 1500;
        }
        
    }
    
    /*
    Create a constructor for Van 
        To set all the fields
    */
    
    public Truck(String plates, String manufacturer, int numTrailers)
    {
        
        super(plates, manufacturer);
        this.numTrailers = numTrailers;
        
    }
    
    public static void main (String[] args)
    {
        Truck truckTest = new Truck("OD14STV","Leyland",3);
        System.out.println(truckTest.calculateBasicTripCost());
        Truck truckTest2 = new Truck("OD14STV","Leyland",1);
        System.out.println(truckTest2.calculateBasicTripCost());
        //Testing successful
    }
    
    
}
