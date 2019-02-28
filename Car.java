package cw2_toll_road;

    /**
    * Date Created: 12-Feb-2019
    * Date last updated: 12-Feb-2019
    * @author rohansamuelh
    */

public class Car extends Vehicle
{
   
    private int numberofSeats;  

    @Override
    public int calculateBasicTripCost() 
    {
        
        if(numberofSeats <= 5)
        {
            return 500;
        }
        
        else 
        {
            return 600;
        }
              
    }
       
    public Car(String plates, String manufacturer, int seats)
    {
        super(plates, manufacturer);
        numberofSeats = seats;
        
    }
}
