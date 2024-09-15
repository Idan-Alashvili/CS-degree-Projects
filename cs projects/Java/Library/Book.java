//Idan Alashvili Id:326117629

package HW1;

public class Book extends Object {
    private String name;
    private String author;
    private int UniqueID;
    private int quantity;

    Book(String name, String author) {
        this.name = name;
        this.author = author;
    }
    Book(int UniqueID){
        this.UniqueID = UniqueID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getUniqueID() {
        return UniqueID;
    }

    public void setUniqueID(int uniqueID) {
        UniqueID = uniqueID;
    }
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    @Override
    public String toString() {
        return "Book name: " + getName() + ".\nAuthor: " + getAuthor() + ".";
    }
}
