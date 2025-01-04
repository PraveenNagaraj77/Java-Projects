import java.util.ArrayList;
import java.util.Scanner;

// Room class to represent individual rooms
class Room {
    private int roomNumber;
    private String roomType;
    private double pricePerNight;
    private boolean isAvailable;

    public Room(int roomNumber, String roomType, double pricePerNight) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.pricePerNight = pricePerNight;
        this.isAvailable = true;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailability(boolean available) {
        this.isAvailable = available;
    }
}

// Customer class to manage customer details
class Customer {
    private String name;
    private String contact;
    private String email;

    public Customer(String name, String contact, String email) {
        this.name = name;
        this.contact = contact;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }

    public String getEmail() {
        return email;
    }
}

// Reservation class to manage bookings
class Reservation {
    private Customer customer;
    private Room room;
    private int numberOfNights;

    public Reservation(Customer customer, Room room, int numberOfNights) {
        this.customer = customer;
        this.room = room;
        this.numberOfNights = numberOfNights;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Room getRoom() {
        return room;
    }

    public double calculateTotalPrice() {
        return room.getPricePerNight() * numberOfNights;
    }
}

// HotelManager class to handle operations
class HotelManager {
    private ArrayList<Room> rooms;
    private ArrayList<Reservation> reservations;

    public HotelManager() {
        this.rooms = new ArrayList<>();
        this.reservations = new ArrayList<>();
    }

    public void initializeRooms() {
        rooms.add(new Room(101, "Single", 1000));
        rooms.add(new Room(102, "Single", 1000));
        rooms.add(new Room(201, "Double", 2000));
        rooms.add(new Room(202, "Double", 2000));
        rooms.add(new Room(301, "Suite", 5000));
    }

    public void viewAvailableRooms() {
        System.out.println("Available Rooms:");
        for (Room room : rooms) {
            if (room.isAvailable()) {
                System.out.println("Room Number: " + room.getRoomNumber() + ", Type: " + room.getRoomType() + ", Price: " + room.getPricePerNight());
            }
        }
    }

    public void bookRoom(String name, String contact, String email, int roomNumber, int nights) {
        Room selectedRoom = null;
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber && room.isAvailable()) {
                selectedRoom = room;
                break;
            }
        }

        if (selectedRoom != null) {
            Customer customer = new Customer(name, contact, email);
            Reservation reservation = new Reservation(customer, selectedRoom, nights);
            reservations.add(reservation);
            selectedRoom.setAvailability(false);
            System.out.println("Room booked successfully for " + nights + " nights. Total Price: " + reservation.calculateTotalPrice());
        } else {
            System.out.println("Room not available or invalid room number.");
        }
    }

    public void cancelReservation(String name) {
        Reservation reservationToCancel = null;
        for (Reservation reservation : reservations) {
            if (reservation.getCustomer().getName().equalsIgnoreCase(name)) {
                reservationToCancel = reservation;
                break;
            }
        }

        if (reservationToCancel != null) {
            reservationToCancel.getRoom().setAvailability(true);
            reservations.remove(reservationToCancel);
            System.out.println("Reservation cancelled successfully!");
        } else {
            System.out.println("No reservation found for the given name.");
        }
    }

    public void viewReservations() {
        if (reservations.isEmpty()) {
            System.out.println("No reservations found.");
        } else {
            for (Reservation reservation : reservations) {
                System.out.println("Customer: " + reservation.getCustomer().getName() + ", Contact: " + reservation.getCustomer().getContact() + ", Email: " + reservation.getCustomer().getEmail() + ", Room: " + reservation.getRoom().getRoomNumber() + ", Total Price: " + reservation.calculateTotalPrice());
            }
        }
    }
}

// Main class for user interaction
public class HotelReservationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HotelManager hotelManager = new HotelManager();
        hotelManager.initializeRooms();

        while (true) {
            System.out.println("\nHotel Reservation System");
            System.out.println("1. View Available Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. Cancel Reservation");
            System.out.println("4. View Reservations");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    hotelManager.viewAvailableRooms();
                    break;
                case 2:
                    System.out.print("Enter your name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter your contact: ");
                    String contact = scanner.nextLine();
                    System.out.print("Enter your email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter room number to book: ");
                    int roomNumber = scanner.nextInt();
                    System.out.print("Enter number of nights: ");
                    int nights = scanner.nextInt();
                    scanner.nextLine();
                    hotelManager.bookRoom(name, contact, email, roomNumber, nights);
                    break;
                case 3:
                    System.out.print("Enter your name: ");
                    String cancelName = scanner.nextLine();
                    hotelManager.cancelReservation(cancelName);
                    break;
                case 4:
                    hotelManager.viewReservations();
                    break;
                case 5:
                    System.out.println("Thank you for using the Hotel Reservation System.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
