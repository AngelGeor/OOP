package farmville;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class FarmvilleTests {
    Farm farm;

    @Test
    public void testConstructorWorkingFine(){
        List<Animal> animals = new ArrayList<>();
        farm = new Farm("Farm1",10);

    }
    @Test
    public void testGetCapacity(){
        farm = new Farm("Farm1",10);
        Assert.assertEquals(10,farm.getCapacity());
    }
    @Test
    public void testGetCount(){
        farm = new Farm("Farm1",10);
        Animal animal = new Animal("fox", 10);
        Animal animal1 = new Animal("cow", 15);
        farm.add(animal);
        farm.add(animal1);
        Assert.assertEquals(2,farm.getCount());
    }
    @Test
    public void testGetName(){
        farm = new Farm("Farm1",10);
        Assert.assertEquals("Farm1", farm.getName());
    }
    @Test(expected = IllegalArgumentException.class)
    public void testAddAnimalWithNoCapacity(){
        farm = new Farm("Farm1",1);
        Animal animal = new Animal("fox", 10);
        Animal animal1 = new Animal("cow", 15);
        farm.add(animal);
        farm.add(animal1);
    }
   @Test(expected = IllegalArgumentException.class)
    public void testAddIdenticalAnimal(){
       farm = new Farm("Farm1",5);
       Animal animal = new Animal("fox", 10);
       Animal animal1 = new Animal("fox", 10);
       farm.add(animal);
       farm.add(animal1);
   }
   @Test
    public void testRemove(){
       farm = new Farm("Farm1",5);
       Animal animal = new Animal("fox", 10);
       Animal animal1 = new Animal("cow", 140);
       farm.add(animal);
       farm.add(animal1);
       Assert.assertTrue(farm.remove("fox"));
   }
   @Test(expected = IllegalArgumentException.class)
    public void testSetCapacityWithException(){
       farm = new Farm("Farm1",-5);
       Animal animal = new Animal("fox", 10);
   }
   @Test(expected = NullPointerException.class)
    public void testSetNameException(){
       farm = new Farm(" ",5);
   }
}
