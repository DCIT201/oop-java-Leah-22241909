package com.vehicleRental;

// Abstract Class: Vehicle
public abstract class Vehicle {
    private String vehicleId;
    private String model;
    private double baseRentalRate;
    private boolean isAvailable;

    // Constructor with validation
    public Vehicle(String vehicleId, String model, double baseRentalRate, boolean isAvailable) {
        if (vehicleId == null || vehicleId.isEmpty() || model == null || model.isEmpty() || baseRentalRate <= 0) {
            throw new IllegalArgumentException("Invalid input for vehicle initialization.");
        }
        this.vehicleId = vehicleId;
        this.model = model;
        this.baseRentalRate = baseRentalRate;
        this.isAvailable = isAvailable;
    }

    // Getters and Setters with validation
    public String getVehicleId() {
        return vehicleId;
    }

    public String getModel() {
        return model;
    }

    public double getBaseRentalRate() {
        return baseRentalRate;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    // Abstract Methods
    public abstract double calculateRentalCost(int days);

    public abstract boolean isAvailableForRental();

    @Override
    public String toString() {
        return "Vehicle [ID=" + vehicleId + ", Model=" + model + ", Base Rate=" + baseRentalRate + ", Available=" + isAvailable + "]";
    }
}