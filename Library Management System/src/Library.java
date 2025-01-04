import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;

    public Library(){
        this.books = new ArrayList<>();
    }

    public List<Book> getAllBooks() {
        return new ArrayList<>(books);  // Return a copy of the books list
    }

    //Add a Book to the Library
    public void addBook(Book book){
        books.add(book);
    }

    //Remove a Book from the Library
    public void removeBook(String isbn){
        books.removeIf(book -> book.getIsbn().equals(isbn));
    }

    //Search for books by title or author
    public List<Book> searchBooks(String query) {
        List<Book> foundBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(query) || book.getIsbn().contains(query)) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }


    //Get available books
    public List<Book> getAvailableBooks(){
        List<Book> availableBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.isAvailable()) {
                availableBooks.add(book);
            }
        }
        return availableBooks;
    }

}
