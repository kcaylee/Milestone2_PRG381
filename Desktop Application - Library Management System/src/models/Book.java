package models;

public class Book {
    private int bookID;
    private String title;
    private String author;
    private int year;
    private int availableCopies;

    public Book(int bookID, String title, String author, int year, int availableCopies) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.year = year;
        this.availableCopies = availableCopies;
    }

    // Getters and Setters

    public int getBookID() {
        return bookID;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setAvailableCopies(int availableCopies) {
        this.availableCopies = availableCopies;
    }
}
