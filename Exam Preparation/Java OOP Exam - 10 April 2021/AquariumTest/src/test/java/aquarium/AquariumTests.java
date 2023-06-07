package aquarium;

import org.junit.Assert;
import org.junit.Test;

public class AquariumTests {
   private Aquarium aquarium;
    @Test
    public void testConstructor(){
        aquarium = new Aquarium("Peter", 10);
    }
    @Test
    public void testGetName(){
        aquarium = new Aquarium("Peter", 10);
        Assert.assertEquals(aquarium.getName(),"Peter");
    }

    @Test (expected = NullPointerException.class)
    public void testSetNameWithExceptionNull(){
        aquarium = new Aquarium(null, 10);
    }
    @Test (expected = NullPointerException.class)
    public void testSetNameWithExceptionEmpty(){
        aquarium = new Aquarium(" ", 10);
    }
    @Test
    public void testGetCapacity(){
        aquarium = new Aquarium("Peter", 10);
        Assert.assertEquals(aquarium.getCapacity(),10);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testSetCapacityException(){
        aquarium = new Aquarium("Peter", - 10);
    }
    @Test
    public void testAddWorkingFine(){

        aquarium = new Aquarium("Peter", 10);
        Fish fish1 = new Fish("Gosho");
        Fish fish2 = new Fish("Kiro");

        aquarium.add(fish1);
        aquarium.add(fish2);
        Assert.assertEquals(aquarium.getCount(),2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddWithException(){
        aquarium = new Aquarium("Peter", 1);
        Fish fish1 = new Fish("Gosho");
        Fish fish2 = new Fish("Kiro");
        aquarium.add(fish1);
        aquarium.add(fish2);
    }
    @Test
    public void testRemoveWorkingFine(){
        aquarium = new Aquarium("Peter", 10);
        Fish fish1 = new Fish("Gosho");
        Fish fish2 = new Fish("Kiro");
        aquarium.add(fish1);
        aquarium.add(fish2);
        Assert.assertEquals(2,aquarium.getCount());
        aquarium.remove("Gosho");
        Assert.assertEquals(1,aquarium.getCount());
    }
    @Test (expected = IllegalArgumentException.class)
    public void testRemoveWithException() {
        aquarium = new Aquarium("Peter", 10);
        Fish fish1 = new Fish("Gosho");
        Fish fish2 = new Fish("Kiro");
        aquarium.add(fish1);
        aquarium.add(fish2);
        aquarium.remove("Tisho");
    }
    @Test
    public void testSellFishWorkingFine(){
        aquarium = new Aquarium("Peter", 10);
        Fish fish1 = new Fish("Gosho");
        Fish fish2 = new Fish("Kiro");
        aquarium.add(fish1);
        aquarium.add(fish2);
        Fish soldFish = aquarium.sellFish("Gosho");
        Assert.assertFalse(soldFish.isAvailable());
    }
    @Test(expected = IllegalArgumentException.class)
    public void testSellFishWithException(){
        aquarium = new Aquarium("Peter", 10);
        Fish fish1 = new Fish("Gosho");
        Fish fish2 = new Fish("Kiro");
        aquarium.add(fish1);
        aquarium.add(fish2);
        Fish soldFish = aquarium.sellFish("Pesho");
    }
    @Test
    public void testReport(){
        aquarium = new Aquarium("Peter", 10);
        Fish fish1 = new Fish("Gosho");
        aquarium.add(fish1);
        String message = "Fish available at Peter: Gosho";
        Assert.assertEquals(message, aquarium.report());
    }

}

