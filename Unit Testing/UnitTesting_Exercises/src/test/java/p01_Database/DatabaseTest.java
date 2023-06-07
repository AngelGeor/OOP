package p01_Database;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {

    private Database database; //Suzdavame purvo edin obekt
    private static final Integer[] NUMBERS = {7, 45, 34, 12, 98, 23}; //Suzdavame statichen masiv nujen za testa

    @Before
    public void prepareDatabase() throws OperationNotSupportedException {
        database = new Database(NUMBERS);
    }

    //Testvame:
    //1. Konstructor
    //1.1 Suzdava li konstruktora pravelen obekt:
    @Test
    public void testConstructorCreatesAValidObject(){
        //1. Proverka na elementite -> dali elementite sa sushtite kato zadadenite v nachaloto
        Integer[] elements = database.getElements();
        //Proverka na broqt na elementite:
        Assert.assertArrayEquals("Arrays are not the same",elements,NUMBERS);
    }

    //1.2 Kakvo se sluchva ako imame poveche 16 elementa i kakvo se sluchva ako sa pod 1;
    @Test (expected = OperationNotSupportedException.class)
    public void TestConstructorThrowsExceptionIfMoreThanSixteenElements() throws OperationNotSupportedException {
        Integer[] numbers = new Integer[17];
        new Database(numbers);
    }
    @Test (expected = OperationNotSupportedException.class)
    public void TestConstructorThrowWhenLessThanOneElement() throws OperationNotSupportedException {
        Integer[] numbers = new Integer[0];
        new Database(numbers);
    }

    //2. Add method
    //2.1. Uspeshno dobavqme element
    @Test
    public void testAddMethodIfAddsElement() throws OperationNotSupportedException {
        database.add(67);
        Integer[] elementsArray = database.getElements();
        Assert.assertEquals("Invalid add operation!",elementsArray.length, NUMBERS.length + 1);
        Assert.assertEquals(elementsArray[elementsArray.length -1],Integer.valueOf(67));
    }

    //2.2 Neuspesno dobavqme element
    @Test (expected = OperationNotSupportedException.class)
    public void testAddShouldThrowNullParam() throws OperationNotSupportedException {
        database.add(null);
    }

    //3. Remove method
    //3.1 proverka dali pravilno premahva element
    @Test
    public void removeSuccessfullyRemovesLastItem() throws OperationNotSupportedException {
        database.remove();
        Integer[] elements = database.getElements();
        Assert.assertEquals(elements.length, NUMBERS.length -1);
        Assert.assertEquals(elements[elements.length - 1], Integer.valueOf(98));
    }

    //3.2 proverka dali hvurlq exception
    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveThrowExceptionIfDatabaseIsEmpty() throws OperationNotSupportedException {
        //1. Premahvame purvo vsichki elementi
        for (int i = 0; i < NUMBERS.length; i++) {
            database.remove();
        }
        database.remove();
    }
}