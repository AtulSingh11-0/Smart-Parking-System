import model.Vehicle;
import service.ParkingLotService;

import java.util.Scanner;

/**
 * @author cocat
 * @created 13-03-2025 - 02:45 am
 * @package-name PACKAGE_NAME
 * @project Smart-Parking-System
 */
public class ParkingSystem {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ParkingLotService parkingService = new ParkingLotService(5);

		while (true) {
			System.out.println("\n===== SMART PARKING SYSTEM =====");
			System.out.println("1. Park a Vehicle");
			System.out.println("2. Remove a Vehicle");
			System.out.println("3. Check Available Slots");
			System.out.println("4. Exit");
			System.out.print("Enter your choice: ");

			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
				case 1:
					System.out.print("Enter vehicle type (2-Wheeler/4-Wheeler): ");
					String type = scanner.nextLine();
					System.out.print("Enter vehicle number: ");
					String number = scanner.nextLine();
					System.out.println("\n");
					parkingService.addVehicle(new Vehicle(type, number));
					break;

				case 2:
					System.out.print("Enter slot number to remove vehicle: ");
					int slotNumber = scanner.nextInt();
					parkingService.removeVehicle(slotNumber);
					break;

				case 3:
					parkingService.checkAvailability();
					break;

				case 4:
					System.out.println("Exiting... Thank you for using Smart Parking System!");
					scanner.close();
					return;

				default:
					System.out.println("Invalid choice! Try again.");
			}
		}
	}
}
