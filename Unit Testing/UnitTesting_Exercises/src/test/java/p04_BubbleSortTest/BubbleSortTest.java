package p04_BubbleSortTest;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class BubbleSortTest {
@Test
    public void testBubbleSort(){
    int[] numbers = {3,14,52,64,46};
    Bubble.sort(numbers);
    int [] expected = {3,14,46,52,64};
    Assert.assertArrayEquals(expected,numbers);
}
}