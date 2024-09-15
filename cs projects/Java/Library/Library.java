//Idan Alashvili 

package HW1;

import java.util.ArrayList;
import java.util.List;

public class Library {
    public static int idx = 100000;
    DataStructure<Book> library;

    public Library() {
        this.library = new DataStructure<Book>();
    }

    /**
     * adding a book to the library if there is not the same book in the library, if he is there we rise his quantity by 1.
     * gives an error notification if an error occurs.
     * @param name   - the book's name
     * @param author - the book's author
     */
    public void addBook(String name, String author) {
        if (name == null || author == null) {
            System.out.println("Invalid name or author, please try again.");
            return;
        }
        Book newBook = new Book(name, author);
        boolean bookExists = false;
        for (Book existingBook : library.getDynamicArray()) {
            if (existingBook.getName().equals(name) && existingBook.getAuthor().equals(author)) {
                existingBook.setQuantity(existingBook.getQuantity() + 1);
                bookExists = true;
                break;
            }
        }
        if (!bookExists) {
            newBook.setUniqueID(idx++);
            library.add(newBook, library.size());
            newBook.setQuantity(1);
        }
    }
    /**
     * checking if there is a book with the uniqueID in the library, if so the book(s) will be removed from the library.
     * gives an error notification if an error occurs.
     * @param UniqueID - the book(s) uniqueID.
     */
    public void removeBook(int UniqueID) {
        boolean flag = false;
        for (Book book : this.library.getDynamicArray()) {
            if (book.getUniqueID() == UniqueID){
                this.library.delete(book);
                flag = true;
            }
        }
        if (!flag) System.out.println("Book is not in library...");
    }

    /**
     * Borrows the book with the specified uniqueID.
     * gives an error notification if an error occurs.
     * @param UniqueID - the unique ID of the book to be borrowed.
     * @return An unmodifiable list of books.
     */
    public Book borrowBook(int UniqueID) {
        for (Book book : this.library.getDynamicArray()) {
            if (book.getUniqueID() == UniqueID) {
                if (book.getQuantity() > 0) {
                    book.setQuantity(book.getQuantity() - 1);
                    return book;
                }
            }
        }
        System.out.println("Book is not in library...");
        return null;
    }

    /**
     * Borrows all the books from the same author name.
     * gives an error notification if an error occurs.
     * @param author_name - the book's author name.
     * @return - An unmodifiable list of books.
     */
    public List<Book> borrowAllBooks(String author_name) {
        boolean Flag = false;
        List<Book> outputList = new ArrayList<>();
        for (Book book : this.library.getDynamicArray()) {
            if (book.getAuthor().equals(author_name)) {
                if (book.getQuantity() > 0)
                    book.setQuantity(0);
                Flag = true;
            }
            outputList.add(book);
        }
        if (!Flag)System.out.println("There are no books with this author name...");
        return outputList;
    }

    /**
     *  sorting the dynamic array by the unique id of the books.
     */
    public void sortedByUniqueID() {
        int maxID = 0;
        for (Book book : library.getDynamicArray()) {
            maxID = Math.max(book.getUniqueID(), maxID);
        }

        int[] countArray = new int[maxID + 1];
        for (Book book : library.getDynamicArray()) {
            countArray[book.getUniqueID()]++;
        }

        int index = 0;
        for (int i = 0; i < countArray.length; i++) {
            for (int j = 0; j < countArray[i]; j++) {
                library.getDynamicArray().get(index).setUniqueID(i);
                index++;
            }
        }
    }

    /**
     *  Returns the total number of books in the library.
     *  gives an error notification if an error occurs.
     * @return - the total number of books in the library.
     */
    public int totalBooksInLibrary(){
        int sum = 0;
        for (Book book : this.library.getDynamicArray()) {
            sum += book.getQuantity();
        }
        if (sum <= 0) System.out.println("No books in library.");
        return sum;
    }

    /**
     * Returns the total number of books available for loan in the library.
     * gives an error notification if an error occurs.
     * @return - the total number of books available for loan in the library.
     */
    public int totalAvailableBooks() {
        int sum = 0;
        for (Book book : this.library.getDynamicArray()) {
            if(book.getQuantity() > 0)sum += book.getQuantity();
        }
        if (sum <= 0) System.out.println("No available books.");
        return sum;
    }

    /**
     * returns the total number of books currently on loan in the library.
     * gives an error notification if an error occurs.
     * @return - the number of loaned books in the library.
     */
    public int totalLoanBooks() {
        int sum = 0;
        for (Book book : this.library.getDynamicArray()) {
            if(book.getQuantity() == 0)sum ++;
        }
        if (sum <= 0) System.out.println("No loaned books.");
        return sum;
    }

    /**
     * returns the name of the author who wrote the most books in the library.
     * gives an error notification if an error occurs.
     * @return - the name of the author who wrote the most books in the library.
     */
    public String authorWithMostBooks() {
        String outputName = "";
        int max = 0;
        for (Book book : this.library.getDynamicArray()) {
            int counter = 0;
            String authorName = book.getAuthor();
            for (Book otherBook : this.library.getDynamicArray()) {
                if (authorName.equals(otherBook.getAuthor()))counter++;
            }
            if (max < counter){
                max = counter;
                outputName = authorName;
            }
        }
        if (max == 0) System.out.println("Error, try again later.");
        return outputName;
    }

    /**
     * The function receives an ID of a borrowed book and returns it to the library (makes it available again).
     * gives an error notification if an error occurs.
     * @param UniqueID - the unique ID of the book.
     * @return - true if the book is returned.
     *           false if it isn't.
     */
    public boolean returnBook(int UniqueID) {
        for (Book book : this.library.getDynamicArray()) {
            if (book.getUniqueID() == UniqueID){
                book.setQuantity(book.getQuantity() + 1);
                return true;
            }
        }
        System.out.println("Invalid unique ID.");
        return false;
    }

    /**
     * the function receives an ID of a book and returns if its borrowed.
     * gives an error notification if an error occurs.
     * @param UniqueID - the unique ID of the book.
     * @return
     */
    public boolean isBorrowed(int UniqueID) {
        for (Book book : this.library.getDynamicArray()) {
            if (book.getUniqueID() == UniqueID){
                return book.getQuantity() == 0;
            }
        }
        System.out.println("Invalid unique ID.");
        return false;
    }
}
