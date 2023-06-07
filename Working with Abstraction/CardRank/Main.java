package WorkingWithAbstraction_Ex.CardRank;

public class Main {
    public static void main(String[] args) {
        CardRanks[] cardRanks = CardRanks.values();
        System.out.println("Card Ranks:");

        for (CardRanks cards : cardRanks){
            System.out.printf("Ordinal value: %d; Name value: %s%n", cards.ordinal(),cards.name());
        }
    }
}
