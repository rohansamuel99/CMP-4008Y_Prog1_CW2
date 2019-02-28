package cw2_toll_road;

    /**
    * Date Created: 12-Feb-2019
    * Date last updated: 13-Feb-2019
    * @author rohansamuelh
    */

public class Truck extends Vehicle
{
    
    private int numTrailers;
    
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
    
    public Truck(String plates, String manufacturer, int numTrailers)
    {
        
        super(plates, manufacturer);
        this.numTrailers = numTrailers;
        
    }
    
}
