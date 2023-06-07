package aquarium.entities.fish;

public class SaltwaterFish extends BaseFish{
    private static final int SALT_SIZE = 5;
    public SaltwaterFish(String name, String species, double price) {
        super(name, species, price);
        super.setSize(SALT_SIZE);
    }

    @Override
    public void eat() {
        super.setSize(super.getSize() + 2);
    }
}
