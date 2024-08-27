package main;

import db.LibraryDB;
import models.Book;
import models.Borrower;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class LibraryGUI extends JFrame {
    private LibraryDB libraryDB;

    private JPanel mainPanel;
    private JButton booksButton;
    private JButton borrowersButton;

    public LibraryGUI() {
        // Initialize database
        try {
            libraryDB = new LibraryDB();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error connecting to database!", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }

        // Initialize main panel
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(2, 1));

        booksButton = new JButton("Manage Books");
        borrowersButton = new JButton("Manage Borrowers");

        booksButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showBooksPanel();
            }
        });

        borrowersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showBorrowersPanel();
            }
        });

        mainPanel.add(booksButton);
        mainPanel.add(borrowersButton);

        this.add(mainPanel);
        this.setTitle("Library Management System");
        this.setSize(400, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void showBooksPanel() {
        JPanel booksPanel = new JPanel(new BorderLayout());

        JTable booksTable = new JTable();
        try {
            List<Book> books = libraryDB.getAllBooks();
            String[] columnNames = {"BookID", "Title", "Author", "Year", "AvailableCopies"};
            Object[][] data = new Object[books.size()][5];
            for (int i = 0; i < books.size(); i++) {
                data[i][0] = books.get(i).getBookID();
                data[i][1] = books.get(i).getTitle();
                data[i][2] = books.get(i).getAuthor();
                data[i][3] = books.get(i).getYear();
                data[i][4] = books.get(i).getAvailableCopies();
            }
            booksTable.setModel(new javax.swing.table.DefaultTableModel(data, columnNames));
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error fetching books!", "Error", JOptionPane.ERROR_MESSAGE);
        }

        JButton addButton = new JButton("Add Book");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Code to add a new book
            }
        });

        JButton updateButton = new JButton("Update Book");
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Code to update selected book
            }
        });

        JButton deleteButton = new JButton("Delete Book");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Code to delete selected book
            }
        });

        JPanel buttonPanel = new JPanel(new GridLayout(1, 3));
        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);

        booksPanel.add(new JScrollPane(booksTable), BorderLayout.CENTER);
        booksPanel.add(buttonPanel, BorderLayout.SOUTH);

        this.setContentPane(booksPanel);
        this.revalidate();
        this.repaint();
    }

    private void showBorrowersPanel() {
        JPanel borrowersPanel = new JPanel(new BorderLayout());

        JTable borrowersTable = new JTable();
        try {
            List<Borrower> borrowers = libraryDB.getAllBorrowers();
            String[] columnNames = {"BorrowerID", "Name", "Contact", "Email"};
            Object[][] data = new Object[borrowers.size()][4];
            for (int i = 0; i < borrowers.size(); i++) {
                data[i][0] = borrowers.get(i).getBorrowerID();
                data[i][1] = borrowers.get(i).getName();
                data[i][2] = borrowers.get(i).getContact();
                data[i][3] = borrowers.get(i).getEmail();
            }
            borrowersTable.setModel(new javax.swing.table.DefaultTableModel(data, columnNames));
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error fetching borrowers!", "Error", JOptionPane.ERROR_MESSAGE);
        }

        JButton addButton = new JButton("Add Borrower");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Code to add a new borrower
            }
        });

        JButton updateButton = new JButton("Update Borrower");
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Code to update selected borrower
            }
        });

        JButton deleteButton = new JButton("Delete Borrower");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Code to delete selected borrower
            }
        });

        JPanel buttonPanel = new JPanel(new GridLayout(1, 3));
        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);

        borrowersPanel.add(new JScrollPane(borrowersTable), BorderLayout.CENTER);
        borrowersPanel.add(buttonPanel, BorderLayout.SOUTH);

        this.setContentPane(borrowersPanel);
        this.revalidate();
        this.repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LibraryGUI().setVisible(true);
            }
        });
    }
}

