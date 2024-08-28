
package models;
import java.util.Date;

public class BorrowBook {

    private int borrowerID;
    private int bookID;
    private String title;
    private String author;
    private Date borrowDate;
    private Date returnDate;

    public BorrowBook(int borrowerID, int bookID, String title, String author, Date borrowDate, Date returnDate) {
        this.borrowerID = borrowerID;
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }

    // Getters and Setters
    public int getBorrowerID() {
        return borrowerID;
    }

    public void setBorrowerID(int borrowerID) {
        this.borrowerID = borrowerID;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
}


