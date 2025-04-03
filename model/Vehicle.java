package model;

public class Vehicle {
    VehicleType type;
    String color;
    String registrationNo;

    public Vehicle(VehicleType type, String color, String regNo) {
        this.type = type;
        this.color = color;
        this.registrationNo = regNo;
    }

    public VehicleType getVehicleType() {
        return this.type;
    }

    public String getColor() {
        return this.color;
    }

    public String getRegistationNo() {
        return this.registrationNo;
    }
}
