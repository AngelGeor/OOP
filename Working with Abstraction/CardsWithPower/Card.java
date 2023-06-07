package WorkingWithAbstraction_Ex.CardsWithPower;



public class Card {
    private CardSuit03 cardSuit;
    private CardRanks03 cardRank;
    private int power;

    public Card(CardSuit03 cardSuit, CardRanks03 cardRank) {
        this.cardSuit = cardSuit;
        this.cardRank = cardRank;


    }

    public CardSuit03 getCardSuit() {
        return cardSuit;
    }

    public void setCardSuit(CardSuit03 cardSuit) {
        this.cardSuit = cardSuit;
    }

    public CardRanks03 getCardRank() {
        return cardRank;
    }

    public void setCardRank(CardRanks03 cardRank) {
        this.cardRank = cardRank;
    }

    public int getPower() {
        return this.cardSuit.getSuitPower() + this.cardRank.getPowerRank();
    }

    public void setPower(int power) {
        this.power = power;
    }


}
