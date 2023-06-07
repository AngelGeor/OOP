package Encapsulation_Lab.SortByNameAge;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner reader = new Scanner(System.in);
        int n = Integer.parseInt(reader.nextLine());
       Team team = new Team("Black eagles");

        for (int i = 0; i < n; i++) {
            String[] input = reader.nextLine().split("\\s+");
            String firstName = input[0];
            String lastName = input[1];
            int age = Integer.parseInt(input[2]);
            double salary = Double.parseDouble(input[3]);
            Person personToAdd = new Person(firstName,lastName,age,salary);
            team.addPlayer(personToAdd);
        }

        System.out.printf("First team have %d players%n",team.getFirstTeam().size());
        System.out.printf("Reserve team have %d players",team.getReserveTeam().size());
    }
}
