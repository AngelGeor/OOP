package blueOrigin;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.rmi.server.ExportException;

public class SpaceshipTests {
    private Spaceship spaceship;
    private Astronaut first;
    private Astronaut second;
    private Astronaut third;
    @Before
            public void setup(){

        this.first = new Astronaut("pesho", 100);
        this.second = new Astronaut("ivan", 90);
        this.third = new Astronaut("tosho", 80);

    }



    @Test
    public void testConstructor(){
        spaceship = new Spaceship("Space",10);
        Assert.assertEquals("Space", spaceship.getName());
        Assert.assertEquals(0,spaceship.getCount());
        Assert.assertEquals(10,spaceship.getCapacity());
    }
    @Test(expected =IllegalArgumentException.class)
    public void testSetCapacityWithNegativeNumber(){
        spaceship = new Spaceship("Space",-12);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameShouldThrowExceptionWithNull(){
        spaceship = new Spaceship(null, 10);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameWithWhiteSpace(){
        spaceship = new Spaceship("  ", 10);
    }

    @Test(expected =  IllegalArgumentException.class)
    public void testAddShouldFailWithoutCapacity(){
        spaceship = new Spaceship("Space",1);
        spaceship.add(first);
        spaceship.add(second);
    }
    @Test(expected =  IllegalArgumentException.class)
    public void testAddWithTwoIdenticalAstronauts(){
        spaceship = new Spaceship("Space",2);
        spaceship.add(first);
        spaceship.add(first);
    }
    @Test
    public void testAddWorkingProperly(){
        spaceship = new Spaceship("Space",5);
        spaceship.add(first);
        spaceship.add(second);
        spaceship.add(third);
        Assert.assertEquals(3, spaceship.getCount());
    }
    @Test
    public void testRemoveWorkingCorrectly(){
        spaceship = new Spaceship("Space",5);
        spaceship.add(first);
        spaceship.add(second);
        Assert.assertEquals(2,spaceship.getCount());
        spaceship.remove("pesho");
        Assert.assertEquals(1, spaceship.getCount());
    }
    @Test
    public void testRemoveNotWorkingCorrectly(){
        spaceship = new Spaceship("Space",5);
        spaceship.add(first);
        Assert.assertEquals(1,spaceship.getCount());
        spaceship.remove("Gosho");
        Assert.assertEquals(1, spaceship.getCount());
    }
}
