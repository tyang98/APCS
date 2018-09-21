
public class CarTester {
	public static void main(String[] args)
    {
        Car car1 = new Car("2017 BMW M3", "Sedan" , 6, 15, 30);
        System.out.println(car1);
        System.out.println("Your car will drive now");
        car1.driveCar(15);	//Car drives 15 miles
        System.out.println("Your car has driven: " 
                           + car1.getDistance() + " miles");
        System.out.println("Your car is being refilled to the maximum"  
                           + " amount of fuel");
        car1.totalFill();	//Refill car to max fuel amount
        System.out.println("The cost of filling car to the maximum fuel is: " + car1.getFuelCost() + " dollars");
        System.out.println("Your car's current fuel amount: "
                           + car1.getFuel() + " gallons");
        System.out.println("Your car will drive some more now");
        car1.driveCar(100);	//Car drives 100 miles
        System.out.println("Your car has driven: " 
                           + car1.getDistance() + " miles");
        System.out.println("Your car's fuel amount after the drive: "
                           + car1.getFuel() + " gallons");
        System.out.println("Car will be refilled with more fuel");	  
        car1.incFuel(3);	//Refill car with 3 gallons of fuel
        System.out.println("The total cost of fuel after 2 refills: " + car1.getFuelCost() + " dollars");
        System.out.println("Your car's fuel amount after refill: " +  car1.getFuel() + " gallons");        
    }


}
