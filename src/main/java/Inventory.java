import java.time.Year;
import java.util.*;

public class Inventory {
    private Map<String, Book> books = new HashMap<>();

    public void addBook(Book book) {
        books.put(book.getISBN(), book);
    }

    public Book removeBook(String isbn) {
        return books.remove(isbn);
    }

    public List<Book> removeOutdatedBooks(int maxAge) {
        List<Book> removed = new ArrayList<>();
        int currentYear = Year.now().getValue();

        Iterator<Map.Entry<String, Book>> it = books.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Book> entry = it.next();
            Book book = entry.getValue();
            if (currentYear - book.getYear() > maxAge) {
                removed.add(book);
                it.remove();
            }
        }
        return removed;
    }

    public double buyBook(String isbn, int quantity, String email, String address) throws Exception {
        Book book = books.get(isbn);
        if (book == null) {
            throw new IllegalArgumentException("Book not found.");
        }
        if (!book.isPurchasable()) {
            throw new Exception (" Book not for sale.");
        }

        if (!book.isAvailable()) {
            throw new Exception( "Book is not available.");
        }

        else if (book instanceof Paper paperBook) {
            paperBook.decreaseStock(quantity);
            book.deliver(address);
        }
        else if (book instanceof EBook) {
            book.deliver(email);
        }

        double totalPrice = book.getPrice() * quantity;
        System.out.println("Paid " + totalPrice + " for " + book.getTitle() );

        return totalPrice;
    }
}
