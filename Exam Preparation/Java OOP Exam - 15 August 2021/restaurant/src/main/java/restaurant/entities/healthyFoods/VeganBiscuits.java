package restaurant.entities.healthyFoods;

import restaurant.entities.healthyFoods.interfaces.HealthyFood;

public class VeganBiscuits extends Food implements HealthyFood {
    private static final double BISCUIT_PORTION = 205;
    public VeganBiscuits(String name, double price) {
        super(name, BISCUIT_PORTION, price);
    }
}
