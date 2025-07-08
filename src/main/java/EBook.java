public class EBook extends Book {
    private String fileType;

    public EBook(String isbn, String title, int year, double price, String fileType) {
        super(isbn, title, year, price);
        this.fileType = fileType;
    }

    @Override
    public boolean isAvailable() {
        return true;
    }

    @Override
    public boolean isPurchasable() {
        return true;
    }

    @Override
    public void deliver(String email) {
        MailService mail = new MailService() ;
        mail.deliver(email);
    }
}
