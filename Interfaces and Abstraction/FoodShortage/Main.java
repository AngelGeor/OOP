package InterfacesAndAbstraction_Ex.FoodShortage;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);
        List<Rebel> rebels = new ArrayList<>();
        List <Citizen> citizens = new ArrayList<>();
        int number = Integer.parseInt(scanner.nextLine());
        int finalFood = 0;

        for (int i = 0; i < number; i++) {
            String[] input = scanner.nextLine().split("\\s+");

            if (input.length == 4){
                Citizen citizen = new Citizen(input[0], Integer.parseInt(input[1]),input[2],input[3]);
                citizens.add(citizen);
            }else if(input.length == 3){
                Rebel rebel = new Rebel(input[0], Integer.parseInt(input[1]),input[2]);
                rebels.add(rebel);
            }
        }

        String name = scanner.nextLine();

        while (!name.equals("End")){
           for(Citizen citizen : citizens){
               if (citizen.getName().equals(name)){
                   citizen.buyFood();
               }
           }
           for (Rebel rebel : rebels){
               if (rebel.getName().equals(name)){
                   rebel.buyFood();
               }
           }
             name = scanner.nextLine();
        }
        for(Citizen citizen : citizens){
            finalFood +=citizen.getFood();
        }
        finalFood += rebels.stream().mapToInt(Rebel::getFood).sum();

        System.out.println(finalFood);
        }
    }
