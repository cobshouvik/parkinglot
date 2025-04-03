package strategy;

import java.util.List;
import java.util.Optional;

import model.Floor;
import model.VehicleType;
import model.Slot;

public class NearestFloorFindingStrategy implements FloorFindingStrategy{

    public Optional<String> findFreeSlot(List<Floor> floors, VehicleType type, String parkingLotId) {
        for(int i = 0; i<floors.size(); i++) {
            Floor floor = floors.get(i);
            List<Slot> slots = floor.getSlots();
            for(int j=0; j<slots.size();j++){
                Slot slot = slots.get(j);
                if(!slot.isOccupied() && type.equals(slot.getVehicleType())) {
                    slot.setOccupied(true);
                    return Optional.of(String.format("%s_%s_%s", parkingLotId, i+1, j+1));
                }
            }
        }
        return Optional.empty();
    }
}
