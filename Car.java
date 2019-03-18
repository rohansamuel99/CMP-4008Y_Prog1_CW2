package cw2_toll_road;

    /**
    * Date Created: 12-Feb-2019
    * Date last updated: 12-Feb-2019
    * @author rohansamuelh
    */

/*
Car.java is a subclass of Vehicle.java
Stores int numberOfSeats
*/
public class Car extends Vehicle
{
   
    private int numberOfSeats;  
    
    /*
    Override calculateBasicTripCost
    Returns 500 if the car has 5 or less seats
    Returns 600 if the car has more than 5 seats
    */
    
    @Override
    public int calculateBasicTripCost() 
    {
        
        if(numberOfSeats <= 5)
        {
            return 500;
        }
        
        else 
        {
            return 600;
        }
              
    }
       
    /*
    Create a constructor for Car 
        And a accessor for the new attribute of this class
    */
    
    public Car(String plates, String manufacturer, int seats)
    {
        super(plates, manufacturer);
        numberOfSeats = seats;
        
    }
    
    public static void main (String[] args)
    {
        Car carTest = new Car("RS56HPP","Mini",6);
        System.out.println(carTest.calculateBasicTripCost());
        Car carTest2 = new Car("RS56HPP","Mini",4);
        System.out.println(carTest2.calculateBasicTripCost());
        //Testing successful
    }
}
