package com.vehicleRental;

// Main class
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RentalAgency agency = new RentalAgency();

        // Prepopulate fleet
        agency.addVehicle(new Car("C1", "Toyota Corolla", 50.0, true, true));
        agency.addVehicle(new Motorcycle("M1", "Yamaha R1", 30.0, true, true));
        agency.addVehicle(new Truck("T1", "Volvo FH16", 100.0, true, 50));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Vehicle Rental System ---");
            System.out.println("1. Display Available Vehicles");
            System.out.println("2. Rent a Vehicle");
            System.out.println("3. Return a Vehicle");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    agency.displayAvailableVehicles();
                    break;
                case 2:
                    scanner.nextLine();
                    System.out.print("Enter vehicle model: ");
                    String model = scanner.nextLine();
                    System.out.print("Enter customer name: ");
                    String customerName = scanner.next();
                    System.out.print("Enter rental days: ");
                    int days = scanner.nextInt();
                    agency.processRental(new Customer(customerName), model, days);
                    break;
                case 3:
                    scanner.nextLine();
                    System.out.print("Enter vehicle ID to return: ");
                    String vehicleID = scanner.nextLine();
                    agency.returnVehicle(vehicleID);
                    break;
                case 4:
                    System.out.println("Exiting system. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}