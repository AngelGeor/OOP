package aquarium.entities.aquariums;

public class SaltwaterAquarium extends BaseAquarium{
    private static final int SALT_CAPACITY = 25;
    public SaltwaterAquarium(String name) {
        super(name, SALT_CAPACITY);
    }
}
