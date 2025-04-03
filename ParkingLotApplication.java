import model.*;
import java.util.*;

public class ParkingLotApplication {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot("PR1234", 2, 6);
        printDisplayList(parkingLot.getDisplayString(VehicleType.CAR, DisplayType.free_count));
        printDisplayList(parkingLot.getDisplayString(VehicleType.BIKE, DisplayType.free_count));
        printDisplayList(parkingLot.getDisplayString(VehicleType.TRUCK, DisplayType.free_count));

        printDisplayList(parkingLot.getDisplayString(VehicleType.CAR, DisplayType.free_slots));
        printDisplayList(parkingLot.getDisplayString(VehicleType.BIKE, DisplayType.free_slots));
        printDisplayList(parkingLot.getDisplayString(VehicleType.TRUCK, DisplayType.free_slots));

        printDisplayList(parkingLot.getDisplayString(VehicleType.CAR, DisplayType.occupied_slots));
        printDisplayList(parkingLot.getDisplayString(VehicleType.BIKE, DisplayType.occupied_slots));
        printDisplayList(parkingLot.getDisplayString(VehicleType.TRUCK, DisplayType.occupied_slots));

        System.out.println("Parked vehicle. Ticket ID: " + parkingLot.park(VehicleType.CAR, "KA-01-DB-1234", "black")
            .orElse("Parking Lot Full"));
        System.out.println("Parked vehicle. Ticket ID: " + parkingLot.park(VehicleType.CAR, "KA-02-CB-1334", "red")
            .orElse("Parking Lot Full"));
        System.out.println("Parked vehicle. Ticket ID: " + parkingLot.park(VehicleType.CAR, "KA-01-DB-1133", "black")
            .orElse("Parking Lot Full"));
        System.out.println("Parked vehicle. Ticket ID: " + parkingLot.park(VehicleType.CAR, "KA-05-HJ-8432", "white")
            .orElse("Parking Lot Full"));
        System.out.println("Parked vehicle. Ticket ID: " + parkingLot.park(VehicleType.CAR, "WB-45-HO-9032", "white")
            .orElse("Parking Lot Full"));
        System.out.println("Parked vehicle. Ticket ID: " + parkingLot.park(VehicleType.CAR, "KA-01-DF-8230", "black")
            .orElse("Parking Lot Full"));
        System.out.println("Parked vehicle. Ticket ID: " + parkingLot.park(VehicleType.CAR, "KA-21-HS-2347", "red")
            .orElse("Parking Lot Full"));

        printDisplayList(parkingLot.getDisplayString(VehicleType.CAR, DisplayType.free_count));
        printDisplayList(parkingLot.getDisplayString(VehicleType.BIKE, DisplayType.free_count));
        printDisplayList(parkingLot.getDisplayString(VehicleType.TRUCK, DisplayType.free_count));

        printUnparkDetails(parkingLot.unParkCar("PR1234_2_5"));
        printUnparkDetails(parkingLot.unParkCar("PR1234_2_5"));
        printUnparkDetails(parkingLot.unParkCar("PR1234_2_7"));

        printDisplayList(parkingLot.getDisplayString(VehicleType.CAR, DisplayType.free_count));
        printDisplayList(parkingLot.getDisplayString(VehicleType.BIKE, DisplayType.free_count));
        printDisplayList(parkingLot.getDisplayString(VehicleType.TRUCK, DisplayType.free_count));

        printDisplayList(parkingLot.getDisplayString(VehicleType.CAR, DisplayType.free_slots));
        printDisplayList(parkingLot.getDisplayString(VehicleType.BIKE, DisplayType.free_slots));
        printDisplayList(parkingLot.getDisplayString(VehicleType.TRUCK, DisplayType.free_slots));

        printDisplayList(parkingLot.getDisplayString(VehicleType.CAR, DisplayType.occupied_slots));
        printDisplayList(parkingLot.getDisplayString(VehicleType.BIKE, DisplayType.occupied_slots));
        printDisplayList(parkingLot.getDisplayString(VehicleType.TRUCK, DisplayType.occupied_slots));

        System.out.println("Parked vehicle. Ticket ID: " + parkingLot.park(VehicleType.BIKE, "KA-01-DB-1541", "black")
            .orElse("Parking Lot Full"));
        System.out.println("Parked vehicle. Ticket ID: " + parkingLot.park(VehicleType.TRUCK, "KA-32-SJ-5389", "orange")
            .orElse("Parking Lot Full"));
        System.out.println("Parked vehicle. Ticket ID: " + parkingLot.park(VehicleType.TRUCK, "KL-54-DN-4582", "green")
            .orElse("Parking Lot Full"));
        System.out.println("Parked vehicle. Ticket ID: " + parkingLot.park(VehicleType.TRUCK, "KL-12-HF-4542", "green")
            .orElse("Parking Lot Full"));

        printDisplayList(parkingLot.getDisplayString(VehicleType.CAR, DisplayType.free_count));
        printDisplayList(parkingLot.getDisplayString(VehicleType.BIKE, DisplayType.free_count));
        printDisplayList(parkingLot.getDisplayString(VehicleType.TRUCK, DisplayType.free_count));

        printDisplayList(parkingLot.getDisplayString(VehicleType.CAR, DisplayType.free_slots));
        printDisplayList(parkingLot.getDisplayString(VehicleType.BIKE, DisplayType.free_slots));
        printDisplayList(parkingLot.getDisplayString(VehicleType.TRUCK, DisplayType.free_slots));

        printDisplayList(parkingLot.getDisplayString(VehicleType.CAR, DisplayType.occupied_slots));
        printDisplayList(parkingLot.getDisplayString(VehicleType.BIKE, DisplayType.occupied_slots));
        printDisplayList(parkingLot.getDisplayString(VehicleType.TRUCK, DisplayType.occupied_slots));

    }

    private static void printDisplayList(List<String> displayList){
        displayList.forEach(System.out::println);
    }

    private static void printUnparkDetails(Optional<Vehicle> vehicleOptional) {
        if(vehicleOptional.isPresent()) {
            System.out.println(String.format("Unparked vehicle with Registration Number: %s and Color: %s", vehicleOptional.get().getRegistationNo(), vehicleOptional.get().getColor()));
        } else {
            System.out.println("Invalid Ticket");
        }
    }

    //Unparked vehicle with Registration Number: WB-45-HO-9032 and Color: white
    /*
     * 
     * create_parking_lot PR1234 2 6
display free_count CAR
display free_count BIKE
display free_count TRUCK
display free_slots CAR
display free_slots BIKE
display free_slots TRUCK
display occupied_slots CAR
display occupied_slots BIKE
display occupied_slots TRUCK
park_vehicle CAR KA-01-DB-1234 black
park_vehicle CAR KA-02-CB-1334 red
park_vehicle CAR KA-01-DB-1133 black
park_vehicle CAR KA-05-HJ-8432 white
park_vehicle CAR WB-45-HO-9032 white
park_vehicle CAR KA-01-DF-8230 black
park_vehicle CAR KA-21-HS-2347 red
display free_count CAR
display free_count BIKE
display free_count TRUCK
unpark_vehicle PR1234_2_5
unpark_vehicle PR1234_2_5
unpark_vehicle PR1234_2_7
display free_count CAR
display free_count BIKE
display free_count TRUCK
display free_slots CAR
display free_slots BIKE
display free_slots TRUCK
display occupied_slots CAR
display occupied_slots BIKE
display occupied_slots TRUCK
park_vehicle BIKE KA-01-DB-1541 black
park_vehicle TRUCK KA-32-SJ-5389 orange
park_vehicle TRUCK KL-54-DN-4582 green
park_vehicle TRUCK KL-12-HF-4542 green
display free_count CAR
display free_count BIKE
display free_count TRUCK
display free_slots CAR
display free_slots BIKE
display free_slots TRUCK
display occupied_slots CAR
display occupied_slots BIKE
display occupied_slots TRUCK
     * 
     * 
     */
}
