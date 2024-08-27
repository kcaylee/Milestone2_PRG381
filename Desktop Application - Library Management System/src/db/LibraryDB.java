package db;

import models.Book;
import models.Borrower;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LibraryDB {
    private Connection conn;

    public LibraryDB() throws SQLException {
        conn = DriverManager.getConnection("jdbc:derby:LibraryDB;create=true");
        setupDatabase();
    }

    private void setupDatabase() throws SQLException {
        Statement stmt = conn.createStatement();

        // Create Books Table
        stmt.executeUpdate("CREATE TABLE Books (" +
                "BookID INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY, " +
                "Title VARCHAR(255), " +
                "Author VARCHAR(255), " +
                "Year INT, " +
                "AvailableCopies INT)");

        // Create Borrowers Table
        stmt.executeUpdate("CREATE TABLE Borrowers (" +
                "BorrowerID INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY, " +
                "Name VARCHAR(255), " +
                "Contact VARCHAR(255), " +
                "Email VARCHAR(255))");
    }

    public void addBook(Book book) throws SQLException {
        String query = "INSERT INTO Books (Title, Author, Year, AvailableCopies) VALUES (?, ?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, book.getTitle());
        pstmt.setString(2, book.getAuthor());
        pstmt.setInt(3, book.getYear());
        pstmt.setInt(4, book.getAvailableCopies());
        pstmt.executeUpdate();
    }

    public void addBorrower(Borrower borrower) throws SQLException {
        String query = "INSERT INTO Borrowers (Name, Contact, Email) VALUES (?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, borrower.getName());
        pstmt.setString(2, borrower.getContact());
        pstmt.setString(3, borrower.getEmail());
        pstmt.executeUpdate();
    }

    public List<Book> getAllBooks() throws SQLException {
        String query = "SELECT * FROM Books";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        List<Book> books = new ArrayList<>();
        while (rs.next()) {
            Book book = new Book(
                    rs.getInt("BookID"),
                    rs.getString("Title"),
                    rs.getString("Author"),
                    rs.getInt("Year"),
                    rs.getInt("AvailableCopies")
            );
            books.add(book);
        }
        return books;
    }

    public List<Borrower> getAllBorrowers() throws SQLException {
        String query = "SELECT * FROM Borrowers";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        List<Borrower> borrowers = new ArrayList<>();
        while (rs.next()) {
            Borrower borrower = new Borrower(
                    rs.getInt("BorrowerID"),
                    rs.getString("Name"),
                    rs.getString("Contact"),
                    rs.getString("Email")
            );
            borrowers.add(borrower);
        }
        return borrowers;
    }

    public void updateBook(Book book) throws SQLException {
        String query = "UPDATE Books SET Title=?, Author=?, Year=?, AvailableCopies=? WHERE BookID=?";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, book.getTitle());
        pstmt.setString(2, book.getAuthor());
        pstmt.setInt(3, book.getYear());
        pstmt.setInt(4, book.getAvailableCopies());
        pstmt.setInt(5, book.getBookID());
        pstmt.executeUpdate();
    }

    public void updateBorrower(Borrower borrower) throws SQLException {
        String query = "UPDATE Borrowers SET Name=?, Contact=?, Email=? WHERE BorrowerID=?";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, borrower.getName());
        pstmt.setString(2, borrower.getContact());
        pstmt.setString(3, borrower.getEmail());
        pstmt.setInt(4, borrower.getBorrowerID());
        pstmt.executeUpdate();
    }

    public void deleteBook(int bookID) throws SQLException {
        String query = "DELETE FROM Books WHERE BookID=?";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setInt(1, bookID);
        pstmt.executeUpdate();
    }

    public void deleteBorrower(int borrowerID) throws SQLException {
        String query = "DELETE FROM Borrowers WHERE BorrowerID=?";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setInt(1, borrowerID);
        pstmt.executeUpdate();
    }
}


