public class QuantumBookstoreFullTest {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Paper paperBook = new Paper("ISBN-001", "Java Basics", 2015, 100.0, 10);
        EBook eBook = new EBook("ISBN-002", "Quantum Computing", 2020, 50.0, "PDF");
        Showcase showcaseBook = new Showcase("ISBN-003", "Rare Manuscript", 1900, 0.0);
        inventory.addBook(paperBook);
        inventory.addBook(eBook);
        inventory.addBook(showcaseBook);
        var removed = inventory.removeOutdatedBooks(50);
        for (Book b : removed) {
            System.out.println("Removed book: " + b.getTitle());
        }
        try {
            double paid = inventory.buyBook("ISBN-001", 2, "buyer@email.com", "123 Main St");
            System.out.println("Paper book purchase successful. Paid: " + paid);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            double paid = inventory.buyBook("ISBN-002", 1, "buyer@email.com", "");
            System.out.println("EBook purchase successful. Paid: " + paid);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            inventory.buyBook("ISBN-003", 1, "buyer@email.com", "");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}