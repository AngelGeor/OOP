package Polymorphism_Ex.Vehicle_Extended;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);

      String[] tokens = scanner.nextLine().split("\\s+");
      double carFuelQuantity = Double.parseDouble(tokens[1]);
      double carFuelConsumption = Double.parseDouble(tokens[2]);
      double carTankCapacity = Double.parseDouble(tokens[3]);
      Vehicle car = new Car(carFuelQuantity,carFuelConsumption,carTankCapacity);

      tokens = scanner.nextLine().split("\\s+");
      double truckFuelQuantity = Double.parseDouble(tokens[1]);
      double truckFuelConsumption = Double.parseDouble(tokens[2]);
      double truckTankCapacity = Double.parseDouble(tokens[3]);

        Vehicle truck = new Truck(truckFuelQuantity,truckFuelConsumption,truckTankCapacity);

        tokens = scanner.nextLine().split("\\s+");
        double busFuelQuantity = Double.parseDouble(tokens[1]);
        double busFuelConsumption = Double.parseDouble(tokens[2]);
        double busTankCapacity = Double.parseDouble(tokens[3]);

        Vehicle bus = new Bus(busFuelQuantity,busFuelConsumption,busTankCapacity);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            tokens = scanner.nextLine().split("\\s+");
            String commandName = tokens[0];
            String vehicleType = tokens[1];


            switch (commandName){
                case "Drive":
                 double distance = Double.parseDouble(tokens[2]);
                if(vehicleType.equals("Car")){
                    System.out.println(car.drive(distance));
                } else if(vehicleType.equals("Truck")) {
                    System.out.println(truck.drive(distance));
                }else {
                    bus.setFuelConsumption(bus.getFuelConsumption() + 1.4);
                    System.out.println(bus.drive(distance));
                }
                    break;

                case "Refuel":
                    double fuelAmount = Double.parseDouble(tokens[2]);
                    if(vehicleType.equals("Car")){
                        car.refuel(fuelAmount);
                    }else if (vehicleType.equals("Truck")) {
                        truck.refuel(fuelAmount);
                    }else {
                        bus.refuel(fuelAmount);
                    }
                    break;
                case "DriveEmpty":
                    double driveEmptyDistance = Double.parseDouble(tokens[2]);
                    System.out.println(bus.drive(driveEmptyDistance));
                    break;
            }

        }
        System.out.println(car);
        System.out.println(truck);
        System.out.println(bus);

    }
}
