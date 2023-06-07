package WorkingWithAbstraction_Lab.Rectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] coordinatesOfRectangle = Arrays.stream(scanner.nextLine().split("\\s+")).
                mapToInt(Integer::parseInt).toArray();

        int xBottomLeft = coordinatesOfRectangle[0];
        int yBottomLeft = coordinatesOfRectangle[1];

        Point bottomLeft = new Point(xBottomLeft,yBottomLeft);

        int xTopLeft = coordinatesOfRectangle[2];
        int yTopLeft = coordinatesOfRectangle[3];

        Point topRight = new Point(xTopLeft,yTopLeft);

        Rectangle rectangle = new Rectangle(bottomLeft,topRight);

        int count = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < count; i++) {
            int[] pointOfCoordinates = Arrays.stream(scanner.nextLine().split("\\s+")).
                    mapToInt(Integer::parseInt).toArray();
            Point currentPoint = new Point(pointOfCoordinates[0],pointOfCoordinates[1]);
            System.out.println(rectangle.contains(currentPoint));
        }
    }
}
