package WorkingWithAbstraction_Ex.CardsWithPower;

public enum CardSuit03 {
    CLUBS(0),
    DIAMONDS(13),
    HEARTS(26),
    SPADES(39);

    private int suitPower;

    CardSuit03(int suitPower) {
        this.suitPower = suitPower;
    }

    public int getSuitPower() {
        return this.suitPower;
    }
}
