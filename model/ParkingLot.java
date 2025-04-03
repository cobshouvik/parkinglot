package model;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

import strategy.FloorFindingStrategy;
import strategy.NearestFloorFindingStrategy;

public class ParkingLot {
    List<Floor> floors;
    Map<String, Vehicle> activeParkingTickets;
    String parkingLotId;
    FloorFindingStrategy floorFindingStrategy;

    public ParkingLot(String id, int floorCount, int slotCount) {
        this.floorFindingStrategy = new NearestFloorFindingStrategy();
        this.parkingLotId = id;
        this.activeParkingTickets = new ConcurrentHashMap<>();
        this.floors = new ArrayList<>();
        for(int i=0; i<floorCount; i++) {
            floors.add(new Floor(slotCount));
        }
    }

    public Optional<String> park(VehicleType type, String regNo, String color) {
        //park_vehicle CAR KA-01-DB-1234 black
        Vehicle vehicleToPark = new Vehicle(type, color, regNo);
        Optional<String> optionalTicket = floorFindingStrategy.findFreeSlot(floors, type, parkingLotId);

        optionalTicket.ifPresent(ticket -> {
            activeParkingTickets.put(ticket, vehicleToPark);
        });

        return optionalTicket;
    }

    public Optional<Vehicle> unParkCar(String ticket) {
        if(!activeParkingTickets.containsKey(ticket)) {
            return Optional.empty();
        }
        String[] ticketFragments = ticket.split("_");
        Slot slot = floors.get(Integer.valueOf(ticketFragments[1])-1).getSlots().get(Integer.valueOf(ticketFragments[2]) - 1);
        if(!slot.isOccupied())
            return Optional.empty();
        slot.setOccupied(false);
        Vehicle vehicle = activeParkingTickets.get(ticket);
        activeParkingTickets.remove(ticket);
        return Optional.of(vehicle);
    }

    public List<String> getDisplayString(VehicleType vehicleType, DisplayType displayType) {
        List<String> displayStringList = new ArrayList<>();
        for(int i=0;i<floors.size();i++) {
            Floor floor = floors.get(i);
            String displayText;
            if(displayType.equals(DisplayType.free_count)) {
                displayText = String.format("No. of free slots for %s on Floor %s: %s", 
                    vehicleType.name(), i+1,
                    floor.getFreeSlotCount(vehicleType));
            } else if (displayType.equals(DisplayType.free_slots)) {
                displayText = String.format("Free slots for %s on Floor %s: %s", 
                    vehicleType.name(), i+1,
                        floor.getFreeSlots(vehicleType).stream().map(slotId -> slotId.toString())
                        .collect(Collectors.joining(",")));
            } else if (displayType.equals(DisplayType.occupied_slots)) {
                displayText = String.format("Occupied slots for %s on Floor %s: %s", 
                    vehicleType.name(), i+1,
                        floor.getOccupiedSlots(vehicleType).stream().map(slotId -> slotId.toString())
                        .collect(Collectors.joining(",")));
            } else {
                displayText = "Invalid display type";
            }
            displayStringList.add(displayText);
        }
        return displayStringList;
    }
}
