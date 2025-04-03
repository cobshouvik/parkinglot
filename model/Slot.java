package model;

public class Slot {
    final VehicleType type;
    boolean occupied;

    public Slot(VehicleType type) {
        this.type = type;
        this.occupied = false;
    }

    public boolean isOccupied() {
        return this.occupied;
    }

    public void setOccupied(boolean value) {
        this.occupied = value;
    }

    public VehicleType getVehicleType() {
        return this.type;
    }
}
