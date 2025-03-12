package model;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * @author cocat
 * @created 12-03-2025 - 09:08 am
 * @package-name model
 * @project Smart-Parking-System
 */
public class Vehicle {
	private String vehicleType;
	private String vehicleNumber;
	private LocalDateTime entryTime;
	private LocalDateTime exitTime;

	/*
	* Constructors
	* */
	public Vehicle () {}

	public Vehicle (String vehicleType, String vehicleNumber) {
		this.vehicleType = vehicleType;
		this.vehicleNumber = vehicleNumber;
		this.entryTime = LocalDateTime.now();
	}

	/*
	* Getters
	* */
	public String getVehicleType() {
		return vehicleType;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public LocalDateTime getEntryTime() {
		return entryTime;
	}

	public LocalDateTime getExitTime() {
		return exitTime;
	}

	/*
	* Setters
	* */
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public void setExitTime () {
		this.exitTime = LocalDateTime.now();
	}

	/*
	* Member methods
	* */
	public long getParkingDuration() {
		return Duration.between(entryTime, exitTime).toMinutes();
	}
}
