package WorkingWithAbstraction_Ex.CardsWithPower;

public enum CardRanks03 {
    ACE(14),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(11),
    QUEEN(12),
    KING(13);

    private int powerRank;

    CardRanks03(int powerRank){
        this.powerRank = powerRank;
    }
    public int getPowerRank(){
        return this.powerRank;
    }
}
