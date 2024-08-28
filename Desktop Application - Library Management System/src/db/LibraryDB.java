package db;

import models.Book;
import models.Borrower;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class LibraryDB {
    Connection conn;
    private static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    private static final String DB_URL = "jdbc:derby:LibraryDB;create=true";
    
    public void connect() {
    try {
        
        Class.forName(DRIVER);
        
        this.conn = DriverManager.getConnection(DB_URL);
        
        if (this.conn != null) {
            System.out.println("Connected to the database.");
        }
    } catch (ClassNotFoundException ex) {
        System.err.println("Failed to load Derby JDBC driver.");
        ex.printStackTrace();
    } catch (SQLException ex) {
        System.err.println("Failed to connect to the database.");
        ex.printStackTrace();
    }
}
    public LibraryDB() throws SQLException {
        connect();
        setupDatabase();
    }
   
    private void setupDatabase() throws SQLException {
           try (Statement stmt = conn.createStatement()) {
               // Create Books Table if it doesn't exist
               stmt.executeUpdate("CREATE TABLE Books (" +
                       "BookID INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY, " +
                       "Title VARCHAR(255), " +
                       "Author VARCHAR(255), " +
                       "\"Year\" INT, " +
                       "AvailableCopies INT)");
               System.out.println("Books table created successfully.");

               // Create Borrowers Table if it doesn't exist
               stmt.executeUpdate("CREATE TABLE Borrowers (" +
                       "BorrowerID INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY, " +
                       "Name VARCHAR(255), " +
                       "Contact VARCHAR(255), " +
                       "Email VARCHAR(255))");
               System.out.println("Borrowers table created successfully.");

           } catch (SQLException e) {
               if ("X0Y32".equals(e.getSQLState())) {
                   System.out.println("Tables already exist, no need to create them again.");
               } else {
                   throw e; // Rethrow if it's a different SQL exception
               }
           }
       }

    
    

    public void addBook(Book book) throws SQLException {
    String query = "INSERT INTO Books (Title, Author, \"Year\", AvailableCopies) VALUES (?, ?, ?, ?)";
    try (PreparedStatement pstmt = conn.prepareStatement(query)) {
        pstmt.setString(1, book.getTitle());
        pstmt.setString(2, book.getAuthor());
        pstmt.setInt(3, book.getYear());
        pstmt.setInt(4, book.getAvailableCopies());
        pstmt.executeUpdate();
    }
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
    String query = "UPDATE Books SET Title=?, Author=?, \"Year\"=?, AvailableCopies=? WHERE BookID=?";
    try (PreparedStatement pstmt = conn.prepareStatement(query)) {
        pstmt.setString(1, book.getTitle());
        pstmt.setString(2, book.getAuthor());
        pstmt.setInt(3, book.getYear());
        pstmt.setInt(4, book.getAvailableCopies());
        pstmt.setInt(5, book.getBookID());
        pstmt.executeUpdate();
    }
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
    public Book getBookById(int bookID) throws SQLException {
        String query = "SELECT * FROM Books WHERE BookID = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, bookID);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Book(
                            rs.getInt("BookID"),
                            rs.getString("Title"),
                            rs.getString("Author"),
                            rs.getInt("Year"),
                            rs.getInt("AvailableCopies")
                    );
                }
            }
        }
        return null; // Return null if the book was not found
    }
    
}



