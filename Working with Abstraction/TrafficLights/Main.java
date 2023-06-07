package WorkingWithAbstraction_Ex.TrafficLights;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] colours = scanner.nextLine().split("\\s+");
        int numberOfChanges = Integer.parseInt(scanner.nextLine());
        List<Light> trafficLight = new ArrayList<>();

        for(String colour : colours){
            Light light = new Light(LightColour.valueOf(colour));
            trafficLight.add(light);
        }
        for (int i = 0; i < numberOfChanges; i++) {
            for(Light light : trafficLight){
                light.changeColour();
                System.out.print(light.getColour() + " ");
            }
            System.out.println();
        }
        trafficLight.removeIf(light -> light.getColour().equals(LightColour.GREEN));

        System.out.println();
    }
}
