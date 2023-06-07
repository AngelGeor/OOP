package aquarium.entities.fish;

public class FreshwaterFish extends BaseFish{
    private static final int FreshSize = 3;
    public FreshwaterFish(String name, String species, double price) {
        super(name, species, price);
        this.setSize(FreshSize);
    }



    @Override
    public void eat() {
    super.setSize(super.getSize() + 3);
    }
}
