package cats;

import org.junit.Assert;
import org.junit.Test;

public class HouseTests {
//1.Suzdavane na kushta
    //1. Nevalidno capacity
    @Test(expected = IllegalArgumentException.class)
    public void voidTestCreateHouseWithInvalidCapacity(){
        new House("House1", -15);
    }

    //1.2 Nevalidno ime (null)
    @Test(expected = NullPointerException.class)
    public void voidTestCreateHouseWithInvalidNameNull(){
        new House(null, 3);
    }
    // Nevalidno ime, koeto e prazno
    @Test(expected = NullPointerException.class)
    public void voidTestCreateHouseWithInvalidNameEmpty(){
        new House("", 3);
    }

    //1.3 Validni stoinosti
    @Test
    public void testCreateHouseCorrectly(){
        House house = new House("House1", 10);
        Assert.assertEquals(house.getName(), "House1");
        Assert.assertEquals(house.getCapacity(),10);
    }

    //2 addCat test
    @Test
    public void testAddCat() {
        House house = new House("House1", 10);
        Cat mike = new Cat("Mike");
        Assert.assertEquals(0, house.getCount());
        house.addCat(mike);
        Assert.assertEquals(1, house.getCount());
    }
    @Test(expected = IllegalArgumentException.class)
    public void testAddCatThrowsException(){
        House house = new House("House1", 1);
        Cat mike = new Cat("Mike");
        house.addCat(mike);
        Assert.assertEquals(1, house.getCount());

        Cat betty = new Cat("Betty");
        house.addCat(betty);
    }
    //3 Remove cat test
    //3.1 Uspeshno premahvane na kotkata
    //3.2 da nqma takova kotka

    //3.1
    @Test
    public void testRemoveCatSuccessfully(){
        House house = new House("House1", 10);
        Cat mike = new Cat("Mike");
        house.addCat(mike);
        Cat betty = new Cat("Betty");
        house.addCat(betty);
        Assert.assertEquals(2, house.getCount());

        house.removeCat("Betty");
        Assert.assertEquals(1, house.getCount());

        house.removeCat("Mike");
        Assert.assertEquals(0, house.getCount());
    }
    //3.2
    @Test(expected = IllegalArgumentException.class)
    public void testNonExistentCat(){
        House house = new House("House1", 10);
        house.removeCat("Gosho");
    }
    //4. CatForSale test
    //4.1 uspeshno da prodadem kotkata -> stavag gladna
    @Test
    public void testCatForSaleWorkingCorrectly(){
        House house = new House("House1", 10);
        Cat mike = new Cat("Mike");
        house.addCat(mike);
        Cat returnedCat = house.catForSale("Mike");
        Assert.assertFalse(returnedCat.isHungry());
    }
    //4.2 nqmame kotka s dadenoto ime
    @Test(expected = IllegalArgumentException.class)
    public void testCatForSaleNonExistentCat(){
        House house = new House("House1", 10);
        house.catForSale("Joro");
    }
    //5. getStatistics

    @Test
    public void testStatistics(){
        House house = new House("House1", 10);
        Cat mike = new Cat("Mike");
        Cat john = new Cat("John");
        Cat carla = new Cat("Carla");
        house.addCat(mike);
        house.addCat(john);
        house.addCat(carla);

        Assert.assertEquals("The cat Mike, John, Carla is in the house House1!",house.statistics());
    }
}
