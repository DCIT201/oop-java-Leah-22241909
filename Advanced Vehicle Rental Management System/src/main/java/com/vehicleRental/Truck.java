package com.vehicleRental;

// Truck Class
public class Truck extends Vehicle implements Rentable {
    private double cargoCapacity;

    public Truck(String vehicleId, String model, double baseRentalRate, boolean isAvailable, double cargoCapacity) {
        super(vehicleId, model, baseRentalRate, isAvailable);
        if (cargoCapacity <= 0) {
            throw new IllegalArgumentException("Cargo capacity must be greater than zero.");
        }
        this.cargoCapacity = cargoCapacity;
    }

    @Override
    public double calculateRentalCost(int days) {
        return (getBaseRentalRate() * days) + (10.0 * cargoCapacity);
    }

    @Override
    public boolean isAvailableForRental() {
        return isAvailable();
    }

    @Override
    public void rent(Customer customer, int days) {
        if (!isAvailableForRental()) {
            throw new IllegalStateException("Truck is not available for rental.");
        }
        setAvailable(false);
        System.out.println("Truck rented to " + customer.getName() + " for " + days + " days.");
    }

    @Override
    public void returnVehicle() {
        setAvailable(true);
        System.out.println("Truck has been returned.");
    }

    @Override
    public String toString() {
        return super.toString() + " [Cargo Capacity=" + cargoCapacity + " tons]";
    }
}
