package com.vehicleRental;

// Motorcycle Class
public class Motorcycle extends Vehicle implements Rentable {
    private boolean hasSidecar;

    public Motorcycle(String vehicleId, String model, double baseRentalRate, boolean isAvailable, boolean hasSidecar) {
        super(vehicleId, model, baseRentalRate, isAvailable);
        this.hasSidecar = hasSidecar;
    }

    @Override
    public double calculateRentalCost(int days) {
        double sidecarCharge = hasSidecar ? 3.0 * days : 0;
        return (getBaseRentalRate() * days) + sidecarCharge;
    }

    @Override
    public boolean isAvailableForRental() {
        return isAvailable();
    }

    @Override
    public void rent(Customer customer, int days) {
        if (!isAvailableForRental()) {
            throw new IllegalStateException("Motorcycle is not available for rental.");
        }
        setAvailable(false);
        System.out.println("Motorcycle rented to " + customer.getName() + " for " + days + " days.");
    }

    @Override
    public void returnVehicle() {
        setAvailable(true);
        System.out.println("Motorcycle has been returned.");
    }

    @Override
    public String toString() {
        return super.toString() + " [Sidecar=" + hasSidecar + "]";
    }
}
