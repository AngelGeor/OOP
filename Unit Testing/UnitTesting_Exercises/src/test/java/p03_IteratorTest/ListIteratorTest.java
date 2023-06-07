package p03_IteratorTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class ListIteratorTest {
   private ListIterator listIterator;
   private static final String[] DATA = {"Desi", "Miroslav", "Boris","Petar"};

   @Before
    public void setup() throws OperationNotSupportedException {
       listIterator = new ListIterator(DATA);

   }

    //1 Constructor test
    //1.1 Constructor s prazen spisuk ot elementi (null)
    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorWhenNull() throws OperationNotSupportedException {
       new ListIterator(null);
    }

    //2 hasNext and move Test
        @Test
    public void testHasNextAndMoveMethods(){
            Assert.assertTrue(listIterator.hasNext());
            Assert.assertTrue(listIterator.move());

            Assert.assertTrue(listIterator.hasNext());
            Assert.assertTrue(listIterator.move());

            Assert.assertTrue(listIterator.hasNext());
            Assert.assertTrue(listIterator.move());

            Assert.assertFalse(listIterator.hasNext());
            Assert.assertFalse(listIterator.move());
        }

    //3 print Test
    //3.1 Ako nqmame elemti v spisaka kak printira
    @Test(expected = IllegalStateException.class)
    public void testPrintEmptyList() throws OperationNotSupportedException {
       listIterator = new ListIterator();
       listIterator.print();
    }
    //3.2 ako ima elementi v spisaka kak printira
    @Test
    public void testPrintCorrectly(){
       //{"Desi", "Miroslav", "Boris","Petar"}
        int index = 0;

        while(listIterator.hasNext()){
            Assert.assertEquals(listIterator.print(),DATA[index]);
            index++;
            listIterator.move();
        }
    }
}