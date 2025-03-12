package service;

import model.ParkingLot;
import model.Vehicle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author cocat
 * @created 12-03-2025 - 09:22 am
 * @package-name service
 * @project Smart-Parking-System
 */
public class ParkingLotService {
	private List<ParkingLot> slots; // List of slots in a Parking lot
	private Queue<Vehicle> waitlist; // Waitlist Queue to server the waiting customers in FCFS basis

	/*
	* Constructors
	* */
	public ParkingLotService () {}

	public ParkingLotService (int capacity) {
		slots = new ArrayList<>();
		waitlist = new LinkedList<>();
		for ( int i = 1; i <= capacity; i++ ) {
			slots.add(new ParkingLot(i));
		}
	}

	/*
	* Method to add a Vehicle in the slot
	* */
	public void addVehicle( Vehicle vehicle ) {
		for ( ParkingLot slot : slots ) {
			if ( slot.isAvailable() ) {
				slot.setVehicle(vehicle);
				System.out.println("Vehicle parked to slot " + slot.getSlotNumber());
				return;
			}
		}
		System.out.println("No slots available, adding Vehicle to waitlist");
		waitlist.add(vehicle); // adding vehicle to waitlist, if the slot isnt available
	}

	/*
	* Method to remove Vehicle from the slot
	* */
	public void removeVehicle( int slotNumber ) {
		for ( ParkingLot slot : slots ) {
			if ( slot.getSlotNumber() == slotNumber ) {
				slot.removeVehicle();
				System.out.println("Slot " +slotNumber+ " is now free.");

				// adding the first waiting vehicle from the waitlist Queue
				if ( !waitlist.isEmpty() ) {
					Vehicle waitingVehicle = waitlist.poll();
					slot.parkVehicle(waitingVehicle);
					System.out.println("Vehicle " + waitingVehicle.getVehicleNumber() + " from waitlist is now parked at slot " + slot.getSlotNumber());
				}

				return;
			}
		}
		System.out.println("Invalid slot number");
	}

	/*
	* Method to check slot availability
	* */
	public void checkAvailability() {
		for ( ParkingLot slot : slots ) {
			if ( slot.isAvailable() ) {
				System.out.println("Available slot: " + slot.getSlotNumber());
			}
		}
		System.out.println("No slots available, You will be added to waitlist");
	}
}
