package cw2_toll_road;

    /**
    * Date Created: 11-Feb-2019
    * Date last updated: 12-Feb-2019
    * @author rohansamuelh
    */

public abstract class Vehicle 
{
    
    private String registrationPlate;
    private String manufacture;
    
    /*
    Create a constructor that has two string arguments
    and has accessor methods for both the attributes.
    */
    
    public Vehicle (String plates, String manufacturer)
    {
        
        registrationPlate = plates;
        manufacture = manufacturer;
        
    }
    
    public Vehicle plates(String plates)
    {
        
        this.registrationPlate=plates;
        return this;
        
    }
    
    public String getRegistrationPlate()
    {
     
        return registrationPlate;
        
    }
    
    public Vehicle manufacturer(String manufacturer)
    {
        
        this.manufacture=manufacturer;
        return this;
        
    }
    
    /*
    Create abstract public method that returns int 
    but doesn't take any arguments
    */
    
    public abstract int calculateBasicTripCost(); 
    
    public static void main (String[] args)
    {
        //Cannot create an instance for an abstract class
    }
}
