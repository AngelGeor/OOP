package Polymorphism_Ex.Vehicle;

public class Truck extends Vehicle{
    private final static double AC_ADDITIONAL_CONSUMPTION = 1.6;
    private final static double REFUEL_PERCENTAGE = 0.95;
    public Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);
        super.setFuelConsumption(super.getFuelConsumption() + AC_ADDITIONAL_CONSUMPTION);
    }
    @Override
    public void refuel(double liters){
        liters = liters * REFUEL_PERCENTAGE;
        super.refuel(liters);
    }
}
