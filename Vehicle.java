package cw2_toll_road;

    /**
    * Date Created: 11-Feb-2019
    * Date last updated: 12-Feb-2019
    * @author rohansamuelh
    */

public abstract class Vehicle 
{
    
    private String registrationPlate;
    private String Manufacturer;
    
    Vehicle (String plates, String manufacturer)
    {
        
        registrationPlate = plates;
        Manufacturer = manufacturer;
        
    }
    
    public Vehicle Plates(String plates)
    {
        
        this.registrationPlate=plates;
        return this;
        
    }
    
    public String getRegistrationPlate()
    {
     
        return registrationPlate;
        
    }
    
    public Vehicle Manufacturers(String manufacturers)
    {
        
        this.Manufacturer=manufacturers;
        return this;
        
    }
    
    public abstract int calculateBasicTripCost(); 
    
}
