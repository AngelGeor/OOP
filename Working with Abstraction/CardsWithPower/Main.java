package WorkingWithAbstraction_Ex.CardsWithPower;



import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String rank = scanner.nextLine();
        String suit = scanner.nextLine();

        Card card = new Card(CardSuit03.valueOf(suit), CardRanks03.valueOf(rank));

        System.out.printf("Card name: %s of %s; Card power: %d",card.getCardRank(),card.getCardSuit(),
                card.getPower());
    }
}
