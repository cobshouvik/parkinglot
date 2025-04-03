package model;

import java.util.*;

public class Floor {
    List<Slot> slots;

    public Floor(int slotCount) {
        this.slots = new ArrayList<>(); 
        for(int i=0;i<slotCount;i++) {
            if(i==0) {
                slots.add(new Slot(VehicleType.TRUCK));
            } else if(i<3) {
                slots.add(new Slot(VehicleType.BIKE));
            } else {
                slots.add(new Slot(VehicleType.CAR));
            }
        }
    }

    public List<Slot> getSlots() {
        return this.slots;
    }    

    public int getFreeSlotCount(VehicleType type) {
        int count = 0;
        for(Slot slot : slots) {
            if(!slot.isOccupied() && type.equals(slot.getVehicleType())) {
                count++;
            }
        }
        return count;
    }

    public List<Integer> getOccupiedSlots(VehicleType type) {
        List<Integer> occupiedSlotIds = new ArrayList<>();
        for(int i=0; i<slots.size(); i++) {
            if(slots.get(i).isOccupied() && type.equals(slots.get(i).getVehicleType())) {
                occupiedSlotIds.add(i+1);
            }
        }
        return occupiedSlotIds;
    }

    public List<Integer> getFreeSlots(VehicleType type) {
        List<Integer> freeSlotIds = new ArrayList<>();
        for(int i=0; i<slots.size(); i++) {
            if(!slots.get(i).isOccupied() && type.equals(slots.get(i).getVehicleType())) {
                freeSlotIds.add(i+1);
            }
        }
        return freeSlotIds;
    }
}
