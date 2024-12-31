package com.vehicleRental;

// Car Class
public class Car extends Vehicle implements Rentable {
    private boolean hasGPS;

    public Car(String vehicleId, String model, double baseRentalRate, boolean isAvailable, boolean hasGPS) {
        super(vehicleId, model, baseRentalRate, isAvailable);
        this.hasGPS = hasGPS;
    }

    @Override
    public double calculateRentalCost(int days) {
        double gpsCharge = hasGPS ? 5.0 * days : 0;
        return (getBaseRentalRate() * days) + gpsCharge;
    }

    @Override
    public boolean isAvailableForRental() {
        return isAvailable();
    }

    @Override
    public void rent(Customer customer, int days) {
        if (!isAvailableForRental()) {
            throw new IllegalStateException("Car is not available for rental.");
        }
        setAvailable(false);
        System.out.println("Car rented to " + customer.getName() + " for " + days + " days.");
    }

    @Override
    public void returnVehicle() {
        setAvailable(true);
        System.out.println("Car has been returned.");
    }

    @Override
    public String toString() {
        return super.toString() + " [GPS=" + hasGPS + "]";
    }
}