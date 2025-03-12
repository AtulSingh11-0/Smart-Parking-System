# Smart Parking System

## Overview
This is a **Java-based Smart Parking System** that allows vehicles to check in, check out, and calculate parking fares based on time spent in the parking lot. It also includes a **menu-driven system** for user interaction.

## My Approach 
I designed the system step by step, focusing on **logic building and real-world applicability**. Here’s how I tackled it:

1. **Designed a `Vehicle` class** to store vehicle details like type, number, entry time, and exit time.
2. **Created a `ParkingLot` class** to represent individual parking slots.
3. **Implemented `ParkingLotService`** to manage multiple slots, handle parking and removal, and check availability.
4. **Handled edge cases**, like when a parking lot is full, by introducing a waitlist system.
5. **Implemented pricing logic**:
   - A **base fare** for the first hour.
   - An **hourly rate** for additional time.
   - Different rates for **2-wheelers and 4-wheelers**.
6. **Built a simple menu-driven system** to interact with users via the console.

## Features
- ✅ **Check-in and Check-out system**
- ✅ **Slot availability check**
- ✅ **Waitlist for when parking is full**
- ✅ **Parking fare calculation**
- ✅ **Console-based menu for user interaction**

## Flow of the Program
1. **User selects an option** from the menu:
   - Park a vehicle
   - Remove a vehicle
   - Check available slots
   - Exit
2. If parking is available, the vehicle is assigned a slot.
3. If the lot is full, the vehicle is added to a **waitlist**.
4. When a vehicle is removed, a **fare is calculated**, and the slot is freed.
5. If a waitlisted vehicle exists, it gets assigned the newly freed slot automatically.
