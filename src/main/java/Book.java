public abstract class Book {
    private String isbn;
    private String title;
    private int year;
    private double price;

    public Book(String isbn, String title, int year, double price) {
        this.isbn = isbn;
        this.title = title;
        this.year = year;
        this.price = price;
    }

    public String getISBN() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }


    public void setPrice(double price) {
        this.price = price;
    }

    public abstract boolean isAvailable();
    public abstract boolean isPurchasable();
    public abstract void deliver(String contactInfo);
}
