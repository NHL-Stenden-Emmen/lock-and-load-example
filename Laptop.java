/**
 * @author J. Doornbos
 * @version 1.0
 */
public class Laptop
{
    private String serialNumber;
    private double maxAmpere;
    private double currentAmpere;
    
    // Constructor
    
    public Laptop(String serialNumber, double maxAmpere, double currentAmpere)
    {
        this.serialNumber = serialNumber;
        this.maxAmpere = maxAmpere;
        this.currentAmpere = currentAmpere;
    }
    
    // Getters & Setters
    
    public String getSerialNumber()
    {
        return this.serialNumber;
    }
    
    public void setSerialNumber(String serialNumber)
    {
        this.serialNumber = serialNumber;
    }
    
    public double getMaxAmpere()
    {
        return this.maxAmpere;
    }
    
    public void setMaxAmpere(double maxAmpere)
    {
        this.maxAmpere = maxAmpere;
    }
    
    public double getCurrentAmpere()
    {
        return this.currentAmpere;
    }
    
    public void setCurrentAmpere(double currentAmpere)
    {
        this.currentAmpere = currentAmpere;
    }
    
    // Methods
    
    public double getAmountToCharge()
    {
        return this.maxAmpere - this.currentAmpere;
    }
    
    public double getBatteryPercentage()
    {
        return (this.currentAmpere / this.maxAmpere) * 100.0;
    }
}
