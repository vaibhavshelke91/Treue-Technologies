import java.util.ArrayList;
import java.util.List;

public class Book {
    private int id;
    private String name;
    private String author;
    private String category;
    private boolean isAvailable;
    private String ownedBy;
    private double price;

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public String getOwnedBy() {
        return ownedBy;
    }
    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
    public void setOwnedBy(String ownedBy) {
        this.ownedBy = ownedBy;
    }
    public boolean isAvailable() {
        return isAvailable;
    }

    public Book() {
    }
    
    public Book(int id, String name, String author, String category, boolean isAvailable, String ownedBy,double price) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.category = category;
        this.isAvailable = isAvailable;
        this.ownedBy = ownedBy;
        this.price=price;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


    public static List<Book> getBookList(){

        List<Book> books=new ArrayList<>();
        books.add(new Book(0, "Comic book1", "new author", "Comics", true, null,130));
        books.add(new Book(1, "Algebra", "general", "Mathematics", true, null,546));
        books.add(new Book(2, "Botony", "bio lab", "Biology", true, null,15));
        books.add(new Book(3, "Java Programming", "old school", "Computer Science", true, null,145));
        books.add(new Book(4, "Advance Java", "old school", "Computer Science", true, null,654));
        books.add(new Book(5, "Python", "py lab", "Computer Science", true, null,123));
        return books;
    }
    
}
