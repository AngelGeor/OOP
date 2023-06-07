package gifts;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class GiftFactoryTests {
GiftFactory giftFactory;
    @Test
            public void testCreateGift(){
        giftFactory = new GiftFactory();
        Gift gift = new Gift("type1", 15);
        giftFactory.createGift(gift);
        Assert.assertEquals(1,giftFactory.getCount());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testCreateGiftWithException(){
        giftFactory = new GiftFactory();
        Gift gift = new Gift("type1", 15);
        giftFactory.createGift(gift);
        giftFactory.createGift(gift);
    }
    @Test
    public void testRemoveGiftWorkingFine(){
        giftFactory = new GiftFactory();
        Gift gift = new Gift("type1", 15);
        giftFactory.createGift(gift);
        Assert.assertTrue(giftFactory.removeGift("type1"));

    }
    @Test(expected = NullPointerException.class)
    public void testRemoveGiftWithException(){
        giftFactory = new GiftFactory();
        Gift gift = new Gift("type1", 15);
        giftFactory.createGift(gift);
        giftFactory.removeGift(" ");
    }
    @Test
    public void testGetPresentWithLeastMagicWorkingFine(){
        giftFactory = new GiftFactory();
        Gift gift = new Gift("type", 15);
        Gift gift1 = new Gift("type1", 7);
        giftFactory.createGift(gift);
        giftFactory.createGift(gift1);

        Gift returnedGift = giftFactory.getPresentWithLeastMagic();
        Assert.assertEquals("type1",returnedGift.getType());
    }
   @Test
    public void testGetPresent(){
       giftFactory = new GiftFactory();
       Gift gift = new Gift("type", 15);
       Gift gift1 = new Gift("type1", 7);
       giftFactory.createGift(gift);
       giftFactory.createGift(gift1);
       Gift returnedGift = giftFactory.getPresent("type1");
       Assert.assertEquals("type1", returnedGift.getType());
   }
   @Test
    public void testGetPresents(){
       giftFactory = new GiftFactory();
       Gift gift = new Gift("type", 15);
       Gift gift1 = new Gift("type1", 7);
       giftFactory.createGift(gift);
       giftFactory.createGift(gift1);
       Assert.assertEquals(2,giftFactory.getPresents().size());
   }
}
