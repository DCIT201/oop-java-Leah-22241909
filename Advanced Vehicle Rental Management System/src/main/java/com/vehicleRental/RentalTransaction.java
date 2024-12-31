package com.vehicleRental;

// RentalTransaction Class
public class RentalTransaction {
    private Customer customer;
    private Vehicle vehicle;
    private int rentalDays;
    private double totalCost;

    public RentalTransaction(Customer customer, Vehicle vehicle, int rentalDays) {
        if (customer == null || vehicle == null || rentalDays <= 0) {
            throw new IllegalArgumentException("Invalid rental transaction details.");
        }
        this.customer = customer;
        this.vehicle = vehicle;
        this.rentalDays = rentalDays;
        this.totalCost = vehicle.calculateRentalCost(rentalDays);
    }

    public Customer getCustomer() {
        return customer;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public int getRentalDays() {
        return rentalDays;
    }

    public double getTotalCost() {
        return totalCost;
    }

    @Override
    public String toString() {
        return "RentalTransaction [Customer=" + customer + ", Vehicle=" + vehicle + ", Rental Days=" + rentalDays + ", Total Cost=" + totalCost + "]";
    }
}
