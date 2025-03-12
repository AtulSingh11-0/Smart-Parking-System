package model;

/**
 * @author cocat
 * @created 12-03-2025 - 09:15 am
 * @package-name model
 * @project Smart-Parking-System
 */
public class ParkingLot {
	private int slotNumber;
	private Vehicle vehicle;
	private static final double BASE_FARE = 5.0;
	private static final double HOURLY_RATE_BIKE = 1.5;
	private static final double HOURLY_RATE_CAR = 2.0;

	/*
	* Constructors
	* */
	public ParkingLot() {}

	public ParkingLot(int slotNumber) {
		this.slotNumber = slotNumber;
		this.vehicle = null;
	}

	/*
	* Getters
	* */
	public int getSlotNumber() {
		return slotNumber;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	/*
	* Setters
	* */
	public void setSlotNumber(int slotNumber) {
		this.slotNumber = slotNumber;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	/*
	* Member methods
	* */
	public boolean isAvailable() {
		return vehicle == null;
	}

	public void parkVehicle(Vehicle vehicle) {
		if ( isAvailable() ) {
			setVehicle(vehicle);
		} else {
			System.out.println("Slot already occupied");
		}
	}

	public void removeVehicle() {
		if ( !isAvailable() ) {
			vehicle.setExitTime();
			long duration = vehicle.getParkingDuration();
			double fare = calculateFare(duration, vehicle.getVehicleType());

			System.out.println("Vehicle " +vehicle.getVehicleNumber()+ " stayed for " +duration+ " minutes.");
			System.out.println("Total fare: Rs " + fare);
			vehicle = null;
		}
	}

	public double calculateFare(long duration, String vehicleType) {
		double rate = vehicleType.equalsIgnoreCase("2") ? HOURLY_RATE_BIKE : HOURLY_RATE_CAR;
		long hours = (long)Math.ceil(duration/60.0);
		return (hours > 1) ? (BASE_FARE + ( hours - 1 ) * rate) : BASE_FARE;
	}

}
