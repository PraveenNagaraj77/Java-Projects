import java.util.*;

public class LibraryManagementSystem {
    private static Library library = new Library();
    private static Scanner scanner = new Scanner(System.in);
    private static Map<String, User> users = new HashMap<>();
    private static User currentUser;

    public static void main(String[] args) {
        // Sample Data
        library.addBook(new Book("Java Programming", "John Doe", "123"));
        library.addBook(new Book("Data Structures Algorithms", "Jane Smith", "456"));
        library.addBook(new Book("Computer Networks", "Robert Brown", "789"));

        // Display the menu
        boolean isRunning = true;
        try {
            while (isRunning) {
                System.out.println("\nLibrary Management System");
                System.out.println("1. Login");
                System.out.println("2. Register");
                System.out.println("3. Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        login();
                        break;
                    case 2:
                        register();
                        break;
                    case 3:
                        isRunning = false;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid number.");
            scanner.nextLine(); // Clear invalid input
        }
    }

    // Login or Select a User
    public static void login() {
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();

        if (users.containsKey(username)) {
            currentUser = users.get(username);
            System.out.println("Welcome back, " + currentUser.getName() + "!");
            userMenu();
        } else {
            System.out.println("User not found. Please register first.");
        }
    }

    // Register a new User
    public static void register() {
        System.out.print("Enter a username to register: ");
        String username = scanner.nextLine();

        if (users.containsKey(username)) {
            System.out.println("Username already taken. Try again.");
        } else {
            User newUser = new User(username);
            users.put(username, newUser);
            currentUser = newUser;
            System.out.println("Registration successful! Welcome, " + username + "!");
            userMenu();
        }
    }

    // User-specific menu after login or registration
    public static void userMenu() {
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("\nWelcome, " + currentUser.getName() + "!");
            System.out.println("1. Search Books");
            System.out.println("2. Book List");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. View Borrowed Books");
            System.out.println("6. Logout");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    searchBooks();
                    break;
                case 2:
                    listAllBooks();
                    break;
                case 3:
                    borrowBook(currentUser);
                    break;
                case 4:
                    returnBook(currentUser);
                    break;
                case 5:
                    currentUser.showBorrowedBooks();
                    break;
                case 6:
                    isRunning = false;
                    System.out.println("Logged out successfully.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Search for books
    public static void searchBooks() {
        System.out.print("Enter book title or author to search: ");
        String query = scanner.nextLine();
        try {
            var results = library.searchBooks(query);
            if (results.isEmpty()) {
                System.out.println("No books found.");
            } else {
                results.forEach(System.out::println);
            }
        } catch (Exception e) {
            System.out.println("An error occurred while searching: " + e.getMessage());
        }
    }

    public static void listAllBooks() {
        System.out.println("\nList of all books in the library:");
        List<Book> allBooks = library.getAllBooks();
        if (allBooks.isEmpty()) {
            System.out.println("No books available in the library.");
        } else {
            allBooks.forEach(System.out::println);
        }
    }

    public static void borrowBook(User user) {
        System.out.print("Enter book title or ISBN to borrow: ");
        String query = scanner.nextLine().trim().toLowerCase(); // Case-insensitive search
        try {
            // Search for books by title or ISBN
            List<Book> availableBooks = library.searchBooks(query);

            if (availableBooks.isEmpty()) {
                System.out.println("No books found with the given title or ISBN.");
            } else {
                System.out.println("Available Books:");
                availableBooks.forEach(System.out::println);

                System.out.print("Enter the book ISBN to borrow: ");
                String isbn = scanner.nextLine().trim(); // Take ISBN input for borrowing
                Book selectedBook = null;

                // Find the book with the matching ISBN
                for (Book book : availableBooks) {
                    if (book.getIsbn().equals(isbn)) {
                        selectedBook = book;
                        break;
                    }
                }

                // Check if the book was found
                if (selectedBook != null) {
                    user.borrowBook(selectedBook);
                    System.out.println("Book borrowed successfully.");
                } else {
                    System.out.println("Invalid ISBN. Please try again.");
                }
            }
        } catch (Exception e) {
            System.out.println("Error during borrowing: " + e.getMessage());
        }
    }

    // Return a book
    public static void returnBook(User user) {
        System.out.print("Enter book ISBN to return: ");
        String isbn = scanner.nextLine();
        try {
            boolean found = false;
            for (Book book : user.getBorrowedBooks()) {
                if (book.getIsbn().equals(isbn)) {
                    user.returnBook(book);
                    System.out.println("Book returned successfully.");
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("You have not borrowed this book.");
            }
        } catch (Exception e) {
            System.out.println("Error during return: " + e.getMessage());
        }
    }
}
