package com.vehicleRental;

// Unit Test Class
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class RentalAgencyTest {

    private RentalAgency agency;
    private Customer customer;
    private Vehicle car;
    private Motorcycle motorcycle;

    @BeforeEach
    public void setup() {
        agency = new RentalAgency();
        customer = new Customer("John Doe", "ABC123");
        car = new Car("C1", "Sedan", 50, true, true);
        motorcycle = new Motorcycle("M1", "Sport", 30, true, false);
        agency.addVehicle(car);
        agency.addVehicle(motorcycle);
    }

    @Test
    public void testAddVehicle() {
        assertEquals(2, agency.getTransactions().size());
    }

    @Test
    public void testProcessRental() {
        agency.processRental(customer, "Sedan", 3);
        assertFalse(car.isAvailable());
        assertEquals(3, customer.getLoyaltyPoints());
        assertEquals(1, agency.getTransactions().size());
    }

    @Test
    public void testFindAvailableVehicle() {
        Vehicle foundVehicle = agency.findAvailableVehicle("Sedan");
        assertNotNull(foundVehicle);
        assertEquals("Sedan", foundVehicle.getModel());
    }

    @Test
    public void testReturnVehicle() {
        agency.processRental(customer, "Sport", 2);
        motorcycle.returnVehicle();
        assertTrue(motorcycle.isAvailable());
    }

    @Test
    public void testInvalidRental() {
        assertThrows(IllegalStateException.class, () -> {
            agency.processRental(customer, "Truck", 1);
        });
    }
}
