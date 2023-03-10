import java.util.ArrayList;

/**
 * @author J. Doornbos
 * @version 1.0
 */
public class LockerBlock
{    
    private ArrayList<Locker> lockers;
    
    // Constructor
    
    public LockerBlock()
    {
        this.lockers = new ArrayList<Locker>();
    }
    
    // Getters & Setters
    
    public ArrayList<Locker> getLockers()
    {
        return this.lockers;
    }
    
    // Methods
    
    public void addLocker(Locker locker)
    {
        this.lockers.add(locker);
    }
    
    public boolean addLaptop(Laptop laptop, int lockerNumber)
    {
        Locker foundLocker = null;
        
        for (Locker locker : this.lockers)
        {
            if (locker.getNumber() == lockerNumber)
            {
                foundLocker = locker;
            }
        }
        
        if (foundLocker != null && foundLocker.isAvailable())
        {
            foundLocker.addLaptop(laptop);
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public ArrayList<Locker> getAvailableLockers()
    {
        ArrayList<Locker> availableLockers = new ArrayList<Locker>();
        
        for (Locker locker : this.lockers)
        {
            if (locker.isAvailable())
            {
                availableLockers.add(locker);
            }
        }
        
        return availableLockers;
    }

    private Locker getFirstEmptyLocker()
    {
        for (Locker locker : this.lockers)
        {
            if (locker.isAvailable())
            {
                return locker;
            }
        }

        return null;
    }
    
    public Locker getFirstAvailableLocker()
    {
        if (this.getFirstEmptyLocker() != null)
        {
            return this.getFirstEmptyLocker();
        }

        Locker foundLocker = null;
        
        // There are no empty locker, so iterate all
        for (Locker locker : this.lockers)
        {
            if (foundLocker == null)
            {
                foundLocker = locker;
            }
            
            Laptop laptop = locker.getLaptop();
            Laptop foundLaptop = foundLocker.getLaptop();
            
            if (laptop.getBatteryPercentage() == foundLaptop.getBatteryPercentage())
            {
                if (laptop.getCurrentAmpere() > foundLaptop.getCurrentAmpere())
                {
                    foundLocker = locker;
                }
            } 
            else if (laptop.getBatteryPercentage() > foundLaptop.getBatteryPercentage())
            {
                foundLocker = locker;
            }
        }
        
        return foundLocker;
    }
    
    private double getTotalAmpereToCharge()
    {
        double totalAmpereToCharge = 0.0;
        
        for (Locker locker : this.lockers)
        {
            totalAmpereToCharge += locker.getLaptop().getAmountToCharge();
        }
        
        return totalAmpereToCharge;
    }
    
    public double getTotalHoursToCharge()
    {
        double chargerSpeed = 522.0; // mAh
        return this.getTotalAmpereToCharge() / chargerSpeed;
    }
}
