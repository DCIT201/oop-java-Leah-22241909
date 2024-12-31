package com.vehicleRental;

// Customer Class
public class Customer {
    private String name;
    private String licenseNumber;
    private int loyaltyPoints;

    public Customer(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Invalid customer details.");
        }
        this.name = name;
    }

    public Customer(String name, String licenseNumber) {
        if (name == null || name.isEmpty() || licenseNumber == null || licenseNumber.isEmpty()) {
            throw new IllegalArgumentException("Invalid customer details.");
        }
        this.name = name;
        this.licenseNumber = licenseNumber;
        this.loyaltyPoints = 0;
    }

    public String getName() {
        return name;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void addLoyaltyPoints(int points) {
        if (points > 0) {
            loyaltyPoints += points;
        }
    }

    @Override
    public String toString() {
        return "Customer [Name=" + name + ", License=" + licenseNumber + ", Loyalty Points=" + loyaltyPoints + "]";
    }
}
