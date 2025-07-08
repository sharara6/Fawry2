public class Showcase extends Book {

    public Showcase(String isbn, String title, int year, double price) {
        super(isbn, title, year, price);
    }

    @Override
    public boolean isAvailable() {
        return false;
    }

    @Override
    public boolean isPurchasable() {
        return false;
    }

    @Override
    public void deliver(String contact) {
        System.out.println("Not Applicalbe");
    }
}
