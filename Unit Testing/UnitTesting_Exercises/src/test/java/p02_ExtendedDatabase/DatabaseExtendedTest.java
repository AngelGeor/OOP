package p02_ExtendedDatabase;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseExtendedTest {

    private DatabaseExtended database; //Suzdavame purvo edin obekt
    private static final Person[] PEOPLE = {new Person(1,"Boris"),new Person(2,"Petar"),
    new Person(3,"George")};

    @Before
    public void prepareDatabase() throws OperationNotSupportedException {
        database = new DatabaseExtended(PEOPLE);
    }

    //Testvame:
    //1. Konstructor
    //1.1 Suzdava li konstruktora pravelen obekt:
    @Test
    public void testConstructorCreatesAValidObject() {
        //1. Proverka na elementite -> dali elementite sa sushtite kato zadadenite v nachaloto
        Person[] elements = database.getElements();
        //Proverka na broqt na elementite:
        Assert.assertArrayEquals("Arrays are not the same", elements, PEOPLE);
    }

    //1.2 Kakvo se sluchva ako imame poveche 16 elementa i kakvo se sluchva ako sa pod 1;
    @Test(expected = OperationNotSupportedException.class)
    public void TestConstructorThrowsExceptionIfMoreThanSixteenElements() throws OperationNotSupportedException {
        Person[] people = new Person[17];
        new DatabaseExtended(people);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void TestConstructorThrowWhenLessThanOneElement() throws OperationNotSupportedException {
        Person[] people = new Person[0];
        new DatabaseExtended(people);
    }

    //2. Add method
    //2.1. Uspeshno dobavqme element
    @Test
    public void testAddMethodIfAddsElement() throws OperationNotSupportedException {
        database.add(new Person(4,"Desi"));
        Person[] people = database.getElements();
        Assert.assertEquals("Invalid add operation!", people.length, PEOPLE.length + 1);
        Assert.assertEquals(Integer.valueOf(people[people.length - 1].getId()), Integer.valueOf(4));
        Assert.assertEquals(people[people.length - 1].getUsername(), "Desi");
    }

    //2.2 Neuspesno dobavqme element
    @Test(expected = OperationNotSupportedException.class)
    public void testAddShouldThrowNullParam() throws OperationNotSupportedException {
        database.add(null);
    }


    //3. Remove method
    //3.1 proverka dali pravilno premahva element
    @Test
    public void removeSuccessfullyRemovesLastItem() throws OperationNotSupportedException {
        database.remove();
        Person[] people = database.getElements();
        Assert.assertEquals(people.length, PEOPLE.length - 1);
        Assert.assertEquals(Integer.valueOf(people[people.length - 1].getId()), Integer.valueOf(2));
        Assert.assertEquals(people[people.length - 1].getUsername(), "Petar");
    }

    //3.2 proverka dali hvurlq exception
    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveThrowExceptionIfDatabaseIsEmpty() throws OperationNotSupportedException {
      database = new DatabaseExtended();
      database.remove();
    }
    //4. Test na findByUsername
    //4.1. Ako podavame null da hvurli exception
    @Test (expected = OperationNotSupportedException.class)
    public void testFindByUsernameWithNull() throws OperationNotSupportedException {
        database.findByUsername(null);
    }
    @Test
    public void testFindByUsernameCorrectly() throws OperationNotSupportedException {
      Person person =  database.findByUsername("Petar");
      Assert.assertEquals(2,person.getId());
      Assert.assertEquals("Petar", person.getUsername());
    }
    //4.2 Ako podadem validen Username dali raboti


    //4.3 Ako nqmame hora v bazata danni
    @Test(expected = OperationNotSupportedException.class)
    public void testIfDatabaseIsEmpty() throws OperationNotSupportedException {
        database = new DatabaseExtended();
        database.findByUsername("Desi");
    }
    //4.3 Ako namerim poveche ot 2ma choveka
    @Test (expected = OperationNotSupportedException.class)
    public void testFindByUsernameMoreThanOnePerson() throws OperationNotSupportedException {
        database.add(new Person(4,"George"));
        database.findByUsername("George");
    }
    //4.5 ako nqmame chovek s tova ime
    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUsernameInvalidName() throws OperationNotSupportedException {
        database.findByUsername("Pesho");
    }

    //5.0 FindById
    //5.1 ako podadem validno ID
    @Test
    public void testGetById() throws OperationNotSupportedException {
        Person person = database.findById(1);
        Assert.assertEquals(person.getId(), 1);
        Assert.assertEquals(person.getUsername(), "Boris");

    }

    //5.2 ako namerim poveche ot 1 chovek sus sushtoto ID
    @Test(expected = OperationNotSupportedException.class)
    //new Person(1,"Boris"),new Person(2,"Petar"),
    //    new Person(3,"George")};

    public void findByIdMoreThanOneId() throws OperationNotSupportedException {
        database.add(new Person(2,"Pesho"));
        database.findById(2);
    }
    //5.3 ako vzemem ot praznen database

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByIdEmptyDatabase() throws OperationNotSupportedException {
        database = new DatabaseExtended();
        database.findById(2);
    }
}


