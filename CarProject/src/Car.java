
/**
	 * Simulates a car
	 * @author Tony Yang
	 * @version 9.27.17
	 */
public class Car {

	    private String myCarModel;
	    private String myCarType;
	    private double myFuel;
	    private double myFuelEfficiency;
	    private double myMaxFuel;
	    private double myDistance;
	    private double myFuelCost;
	    final static double GAS_PRICE = 2.56;

	    /**
	     * Creates a new car given car type, car model, fuel, max,   
	     * fuel efficiency
	     * @param carModel The model of the car
	     * @param carType The type of car
	     * @param fuel The initial amount of fuel
	     * @param max The maximum amount of fuel
	     * @param efficiency The fuel efficiency of car
	     */
	    public Car(String carModel, String carType, double fuel, 
	    	  double max, double efficiency)
	    {
	        myCarModel = carModel;
	        myCarType = carType;
	        myFuel = fuel;
	        myMaxFuel = max;
	        myFuelEfficiency = efficiency;
	        myDistance = 0;
	        myFuelCost = 0;
	    }
	   
	    /**
	     * Returns the model of car
	     * @return The model of car
	     */
	    public String getCarModel()
	    {
	        return myCarModel;
	    }
	    
	    /**
	     * Returns the type of car
	     * @return The type of car
	     */
	    public String getCarType()
	    {
	        return myCarType;
	    }
	    
	    /**
	     * Returns the current fuel amount 
	     * @return current fuel amount
	     */
	    public String getFuel()
	    {
	        return String.format("%.2f", myFuel);
	    }
	    
	    /** 
	     * Returns the maximum fuel amount
	     * @return The maximum fuel amount
	     */
	    public double getMax()
	    {
	        return myMaxFuel;
	    }
	    
	    /**
	     * Returns the fuel efficiency
	     * @return The car fuel efficiency
	     */
	    public double getFuelEfficiency()
	    {
	        return myFuelEfficiency;
	    }
	    
	    /**
	     * Returns distance car has driven
	     * @return The distance car has driven
	     */
	    public double getDistance()
	    {
	        return myDistance;
	    }
	    
	    /**
	     * Returns cost of the fuel added to the car
	     * @return The cost of the fuel added to the car
	     */
	    public double getFuelCost()
	    {
	        return myFuelCost;
	    }
	    
	    /**
	     * Allows the car to drive a certain distance in miles
	     * @param distance The distance the car drives
	     */
	    public void driveCar(double distance)
	    {
	        if(myFuel - (distance / myFuelEfficiency) <= 0)
	        {
	            System.out.println("Your car's fuel tank is empty, you"  + " can not drive anymore");
	            myFuel = 0;
	            myDistance = distance;
	            return;
	        }
	        else
	        {
	            myFuel -= (distance / myFuelEfficiency);
	            myDistance = distance;
	        }
	    }
	    
	    /**
	     * Refills your car with fuel
	     * @param refill The amount of fuel you refill your car in gallons
	     */
	    public void incFuel(double refill)
	    {
		   double fuelDifference = myMaxFuel - myFuel;
	        if (refill > fuelDifference)
	        {
	            System.out.println("Your car's fuel tank is full,"
	    + " cannot give more fuel to the car");
	            refill = fuelDifference;
	        }
	        else if (refill < 0)
	        {
	            throw new IllegalArgumentException("You Can Not Give Your   		 	Car Negative Amount of Fuel!!");
	        }
	        myFuel += refill;
	        myFuelCost += refill * GAS_PRICE;
	    }
	    
	    /**
	     * Fills the car to the max fuel amount
	     */
	    public void totalFill()
	    {
	        double difference = myMaxFuel - myFuel;
	        myFuelCost += difference * GAS_PRICE;
	        myFuel = myMaxFuel;
	    }
	    
	    /**
	     * Convert myCarModel, myCarType, myFuel, 
	     * myMaxFuel, myDistance, myFuelEfficiency into a string
	     */
	    public String toString() 
	    {
		    return String.format("Car Specifications:\nCar Model: %s\nCar  Type: %s\nCurrent Fuel: %s gallons\n Maximum Fuel: %s gallons\nDistance Driven: %s miles\nFuel Efficiency %s mpg\n", myCarModel, myCarType, myFuel, myMaxFuel, myDistance, myFuelEfficiency);
	    }
	}

