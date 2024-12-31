package com.vehicleRental;

// RentalAgency Class
import java.util.ArrayList;
import java.util.List;

public class RentalAgency {
    private List<Vehicle> vehicles;
    private List<RentalTransaction> transactions;
    private Car car;
    private Truck truck;
    private Motorcycle motorcycle;

    public RentalAgency() {
        this.vehicles = new ArrayList<>();
        this.transactions = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        if (vehicle == null) {
            throw new IllegalArgumentException("Vehicle cannot be null.");
        }
        vehicles.add(vehicle);
    }

    public Vehicle findAvailableVehicle(String model) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getModel().equalsIgnoreCase(model) && vehicle.isAvailable()) {
                return vehicle;
            }
        }
        return null;
    }

    public void processRental(Customer customer, String model, int days) {
        Vehicle vehicle = findAvailableVehicle(model);
        if (vehicle == null) {
            throw new IllegalStateException("No available vehicle of the specified model.");
        }
        if(vehicle.equals(car)) {
            car.rent(customer, days);
        }
        else if(vehicle.equals(truck)) {
            truck.rent(customer, days);
        }
        else if(vehicle.equals(motorcycle)) {
            motorcycle.rent(customer, days);
        }

        RentalTransaction transaction = new RentalTransaction(customer, vehicle, days);
        transactions.add(transaction);
        customer.addLoyaltyPoints(days);
        System.out.println("Rental processed: " + transaction);
    }

    public List<RentalTransaction> getTransactions() {
        return transactions;
    }

    @Override
    public String toString() {
        return "RentalAgency [Vehicles=" + vehicles + ", Transactions=" + transactions + "]";
    }

    public void displayAvailableVehicles() {
        System.out.println(vehicles);
    }

    public void returnVehicle(String vehicleID) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getVehicleId().equalsIgnoreCase(vehicleID) && vehicle.equals(car)) {
                car.returnVehicle();
            } else if (vehicle.getVehicleId().equalsIgnoreCase(vehicleID) && vehicle.equals(truck)) {
                truck.returnVehicle();
            } else if (vehicle.getVehicleId().equalsIgnoreCase(vehicleID) && vehicle.equals(motorcycle)) {
                motorcycle.returnVehicle();
            }
        }
    }
}
