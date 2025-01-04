# Hotel Reservation System

## Overview
The **Hotel Reservation System** is a Java-based application designed to manage hotel operations such as room bookings, cancellations, and reservation management. This system uses a menu-driven interface and incorporates Object-Oriented Programming (OOP) principles to provide a modular and efficient solution for managing hotel reservations. The application ensures ease of use for both customers and hotel administrators.

## Features
1. **View Available Rooms**:
   - The system allows users to view a list of rooms that are currently available for booking. It provides details like room number, type (e.g., Single, Double, Suite), and price per night.

2. **Book a Room**:
   - Customers can book a room by entering their details (name, contact, and email), along with the room number and the number of nights they wish to stay. The system calculates the total cost for the stay based on the room's price and the duration of the stay.

3. **Cancel a Reservation**:
   - Customers can cancel their reservation by providing their name. Once canceled, the system updates the room’s availability status, allowing the room to be booked by others.

4. **View Reservations**:
   - Hotel administrators can view all active reservations, including customer details and the total cost of each booking. This helps manage room availability and track reservations.

5. **Room Price Management**:
   - The system supports multiple room types (e.g., Single, Double, Suite) with different pricing. Administrators can adjust the price for each room type as needed.

## Project Structure
The project is designed with a modular approach, using multiple classes to represent key components of the hotel reservation process. Each class is responsible for specific functionality within the system.

### 1. **Room Class**:
   - This class represents an individual room in the hotel. It holds information such as the room number, type (Single, Double, Suite), price per night, and the room's availability status (whether it is booked or available). The room class is essential for managing room details and availability.

### 2. **Customer Class**:
   - The `Customer` class stores the personal information of the customer, such as name, contact number, and email address. It ensures that customer details are properly associated with each booking.

### 3. **Reservation Class**:
   - The `Reservation` class links a customer to a room and tracks booking details, such as the number of nights booked and the total cost for the stay. It calculates the total cost based on the room price and the number of nights the customer intends to stay.

### 4. **HotelManager Class**:
   - The `HotelManager` class is the central class that handles all core operations, including managing room availability, making reservations, canceling bookings, and viewing all reservations. This class also manages interactions between the `Room`, `Customer`, and `Reservation` classes to perform necessary actions based on user input.

### 5. **Main Class**:
   - The `Main` class provides the entry point for the program and presents a menu-driven interface to users. It allows customers and hotel administrators to interact with the system, selecting different options such as viewing available rooms, booking a room, or canceling a reservation.

## OOP Principles Used

1. **Encapsulation**:
   - Encapsulation is used to protect the data within the `Room` and `Customer` classes. This means that the details of the room (e.g., price, availability) and the customer's personal information are hidden from other parts of the system. Access to these details is controlled through public methods, ensuring that the data is securely managed and modified only in appropriate ways.

2. **Inheritance**:
   - The project could use inheritance if different types of rooms were implemented, such as `SingleRoom`, `DoubleRoom`, or `SuiteRoom`. These subclasses would inherit common properties (e.g., room number, price) from the base `Room` class while adding or overriding specific details (e.g., price variations or additional services).

3. **Abstraction**:
   - Abstraction is achieved through the `HotelManager` class, which abstracts the complex operations related to room booking and cancellation. The end user or administrator interacts with simplified methods (e.g., `bookRoom()`, `cancelReservation()`) without needing to understand the underlying complexities of room management or reservation tracking.

4. **Polymorphism**:
   - Polymorphism could be applied in the case of different types of reservations, such as standard bookings and group bookings. A method like `calculateTotalCost()` could behave differently for each type of reservation, offering flexibility in how the system calculates costs based on different criteria (e.g., discounts for groups).

5. **Composition**:
   - Composition is used in the `HotelManager` class, where it contains instances of the `Room` and `Reservation` classes. This means that the `HotelManager` class does not inherit from `Room` or `Reservation`, but instead, it manages and uses these objects to perform the necessary operations. This relationship allows for better flexibility and organization within the code.

## Usage
1. **Compile the Code**:
   - To compile the Java program, you need to run the Java compiler. This will create the necessary class files from the source code:
   ```bash
   javac Main.java
