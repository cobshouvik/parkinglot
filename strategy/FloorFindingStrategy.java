package strategy;

import java.util.*;

import model.*;

public interface FloorFindingStrategy {
    Optional<String> findFreeSlot(List<Floor> floors, VehicleType type, String parkingLotId);
}
