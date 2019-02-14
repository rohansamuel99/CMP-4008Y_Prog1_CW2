package cw2_toll_road;

    /**
    * Date Created: 12-Feb-2019
    * Date last updated: 12-Feb-2019
    * @author rohansamuelh
    */

public class Van extends Vehicle 
{
    
    private int payload;
    
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
    
    
    public Van(String plates, String manufacturer, int payload)
    {
        super(plates, manufacturer);
        this.payload = payload;
        
    }
    
    
    
}
