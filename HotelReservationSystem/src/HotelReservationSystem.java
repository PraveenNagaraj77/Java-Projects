// Hotel Reservation System
import java.util.*;

// Class to represent a Room
class Room {
    private int roomNumber;
    private String roomType; // Single, Double, Suite
    private double price;
    private boolean isAvailable;

    public Room(int roomNumber, String roomType, double price) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.price = price;
        this.isAvailable = true; // By default, rooms are available
    }

    // Getters and Setters
    public int getRoomNumber() {
        return roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "Room Number: " + roomNumber + ", Type: " + roomType + ", Price: $" + price + ", Available: " + isAvailable;
    }
}

// Class to represent a Customer
class Customer {
    private String name;
    private String phoneNumber;
    private String email;

    public Customer(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer: " + name + ", Phone: " + phoneNumber + ", Email: " + email;
    }
}

// Class to represent a Booking
class Booking {
    private Customer customer;
    private Room room;

    public Booking(Customer customer, Room room) {
        this.customer = customer;
        this.room = room;
    }

    @Override
    public String toString() {
        return customer.toString() + "\n" + room.toString();
    }
}

// Main class to manage the hotel system
public class HotelReservationSystem {
    private List<Room> rooms;
    private List<Booking> bookings;

    public HotelReservationSystem() {
        rooms = new ArrayList<>();
        bookings = new ArrayList<>();
    }

    // Add a room to the hotel
    public void addRoom(int roomNumber, String roomType, double price) {
        rooms.add(new Room(roomNumber, roomType, price));
    }

    // Display available rooms
    public void displayAvailableRooms() {
        System.out.println("\nAvailable Rooms:");
        for (Room room : rooms) {
            if (room.isAvailable()) {
                System.out.println(room);
            }
        }
    }

    // Book a room
    public void bookRoom(int roomNumber, String customerName, String phoneNumber, String email) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                if (room.isAvailable()) {
                    Customer customer = new Customer(customerName, phoneNumber, email);
                    Booking booking = new Booking(customer, room);
                    bookings.add(booking);
                    room.setAvailable(false); // Mark room as booked
                    System.out.println("\nRoom booked successfully!\n" + booking);
                } else {
                    System.out.println("\nRoom is already booked.");
                }
                return;
            }
        }
        System.out.println("\nRoom not found.");
    }

    // Cancel a booking
    public void cancelBooking(int roomNumber) {
        Iterator<Booking> iterator = bookings.iterator();
        while (iterator.hasNext()) {
            Booking booking = iterator.next();
            if (booking.toString().contains("Room Number: " + roomNumber)) {
                iterator.remove();
                for (Room room : rooms) {
                    if (room.getRoomNumber() == roomNumber) {
                        room.setAvailable(true); // Mark room as available
                        System.out.println("\nBooking cancelled for Room Number: " + roomNumber);
                        return;
                    }
                }
            }
        }
        System.out.println("\nBooking not found for Room Number: " + roomNumber);
    }

    // Display all bookings
    public void displayBookings() {
        System.out.println("\nAll Bookings:");
        for (Booking booking : bookings) {
            System.out.println(booking);
        }
    }

    // Main method to interact with the system
    public static void main(String[] args) {
        HotelReservationSystem hotel = new HotelReservationSystem();

        // Pre-add rooms to the hotel
        hotel.addRoom(101, "Single", 100.0);
        hotel.addRoom(102, "Double", 150.0);
        hotel.addRoom(103, "Suite", 250.0);

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nHotel Reservation System");
            System.out.println("1. Display Available Rooms");
            System.out.println("2. Book a Room");
            System.out.println("3. Cancel Booking");
            System.out.println("4. Display All Bookings");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    hotel.displayAvailableRooms();
                    break;
                case 2:
                    System.out.print("Enter Room Number to Book: ");
                    int roomNumber = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Customer Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Customer Phone: ");
                    String phone = scanner.nextLine();
                    System.out.print("Enter Customer Email: ");
                    String email = scanner.nextLine();
                    hotel.bookRoom(roomNumber, name, phone, email);
                    break;
                case 3:
                    System.out.print("Enter Room Number to Cancel Booking: ");
                    int cancelRoomNumber = scanner.nextInt();
                    hotel.cancelBooking(cancelRoomNumber);
                    break;
                case 4:
                    hotel.displayBookings();
                    break;
                case 5:
                    System.out.println("Exiting system. Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
