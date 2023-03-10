/**
 * @author J. Doornbos
 * @version 1.0
 */
public class Locker
{
    private Laptop laptop;
    private int number;
    
    // Constructor
    
    public Locker(int number)
    {
        this.laptop = null;
        this.number = number;
    }
    
    // Getters & Setters
    
    public Laptop getLaptop()
    {
        return this.laptop;
    }
    
    public int getNumber() 
    { 
        return this.number; 
    }
    
    public void setNumber(int number) 
    { 
        this.number = number; 
    }
    
    // Methods

    public void addLaptop(Laptop laptop)
    {
        this.laptop = laptop;
    }

    public boolean isAvailable()
    {
        return this.laptop == null;
    }
}
