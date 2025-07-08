public class Paper extends Book {
    private int stock;

    public Paper(String isbn, String title, int year, double price, int stock) {
        super(isbn, title, year, price);
        this.stock = stock;
    }

    @Override
    public boolean isAvailable() {
        return stock > 0;
    }

    @Override
    public boolean isPurchasable() {
        return true;
    }

    @Override
    public void deliver(String address) {
        ShippingService shipping = new ShippingService() ;
        shipping.deliver(address);
    }

    public void decreaseStock(int quantity) {
        this.stock -= quantity;
    }
}
