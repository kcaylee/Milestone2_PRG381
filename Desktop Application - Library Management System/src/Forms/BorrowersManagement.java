package Forms;


import db.LibraryDB;
import models.Borrower;
import models.BorrowBook;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import models.Book;



public class BorrowersManagement extends javax.swing.JFrame {
    private DefaultTableModel borrowerTableModel;
    private DefaultTableModel borrowedBooksTableModel;
    private LibraryDB libraryDB;
    
    public BorrowersManagement() {
         initComponents();
        try {
            libraryDB = new LibraryDB(); 
            System.out.println("Database connection established in BorrowersManagement.");
            displayAllBorrowers();
            initializeBorrowersTableSelectionListener();
            populateBooksComboBox();
        } catch (SQLException e) {
            System.err.println("Error during database connection or initialization: " + e.getMessage());
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error connecting to the database. Please check your database configuration.", "Database Error", JOptionPane.ERROR_MESSAGE);
            this.dispose(); 
        }
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        borrowtbl = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        borrowedbookstbl = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        borrwernametxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        contacttxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        emailtxt = new javax.swing.JTextField();
        addborrowerbtn = new javax.swing.JButton();
        updateborrowerbtn = new javax.swing.JButton();
        displayborrowwes = new javax.swing.JButton();
        deleteborrowwers = new javax.swing.JButton();
        back = new javax.swing.JButton();
        searchborrower = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        booksavailabe = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        borrowbookborrowerID = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        borrowdatetxt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        returnDatetxt = new javax.swing.JTextField();
        borrowbookbtn = new javax.swing.JButton();
        returnbookbtn = new javax.swing.JButton();
        clearbtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        borrowtbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Borrower ID", "Name", "Contact", "Email"
            }
        ));
        jScrollPane1.setViewportView(borrowtbl);

        borrowedbookstbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book ID", "Title", "Author", "Borrow Date", "Return Date"
            }
        ));
        jScrollPane2.setViewportView(borrowedbookstbl);

        jLabel1.setText("Borrower Name");

        borrwernametxt.setText("Please Enter Name");

        jLabel2.setText("Contact");

        contacttxt.setText("Please Enter contact");

        jLabel3.setText("Email");

        emailtxt.setText("Please Enter Email");

        addborrowerbtn.setText("ADD");
        addborrowerbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addborrowerbtnActionPerformed(evt);
            }
        });

        updateborrowerbtn.setText("UPDATE");
        updateborrowerbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateborrowerbtnActionPerformed(evt);
            }
        });

        displayborrowwes.setText("DISPLAY");
        displayborrowwes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayborrowwesActionPerformed(evt);
            }
        });

        deleteborrowwers.setText("DELETE");
        deleteborrowwers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteborrowwersActionPerformed(evt);
            }
        });

        back.setText("BACK");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        searchborrower.setText("SEARCH");
        searchborrower.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchborrowerActionPerformed(evt);
            }
        });

        jLabel4.setText("Borrow a book ");

        booksavailabe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setText("Select book");
        jLabel5.setToolTipText("");

        jLabel6.setText("Enter Borrower ID");

        borrowbookborrowerID.setText("Please enter borrower ID");

        jLabel7.setText("Borrow Date");

        borrowdatetxt.setText("Please Enter Date");

        jLabel8.setText("Return Date");

        returnDatetxt.setText("Please enter return date");

        borrowbookbtn.setText("BORROW");
        borrowbookbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrowbookbtnActionPerformed(evt);
            }
        });

        returnbookbtn.setText("RETURN BOOK");
        returnbookbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnbookbtnActionPerformed(evt);
            }
        });

        clearbtn.setText("CLEAR");
        clearbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(borrowdatetxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(back)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(addborrowerbtn))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(borrwernametxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2)
                                    .addComponent(contacttxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)
                                    .addComponent(emailtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(updateborrowerbtn, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(displayborrowwes, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(deleteborrowwers, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(booksavailabe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)
                                    .addComponent(borrowbookborrowerID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 215, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(returnbookbtn)
                                    .addComponent(borrowbookbtn)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(searchborrower)
                                .addGap(18, 18, 18)
                                .addComponent(clearbtn)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(60, 60, 60))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(returnDatetxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(back)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(borrwernametxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(contacttxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(emailtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(addborrowerbtn)
                                .addGap(18, 18, 18)
                                .addComponent(updateborrowerbtn)
                                .addGap(18, 18, 18)
                                .addComponent(displayborrowwes)
                                .addGap(18, 18, 18)
                                .addComponent(deleteborrowwers))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(199, 199, 199))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(searchborrower)
                            .addComponent(clearbtn))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(borrowbookbtn))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(returnbookbtn))
                        .addGap(18, 18, 18)
                        .addComponent(booksavailabe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(borrowbookborrowerID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(borrowdatetxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(returnDatetxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addborrowerbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addborrowerbtnActionPerformed
        try {
            String name = borrwernametxt.getText();
            String contact = contacttxt.getText();
            String email = emailtxt.getText();

            Borrower newBorrower = new Borrower(0, name, contact, email);
            libraryDB.addBorrower(newBorrower);
            displayAllBorrowers();
            clearFields();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error adding the borrower. Please check the input data.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_addborrowerbtnActionPerformed

    private void updateborrowerbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateborrowerbtnActionPerformed
         int selectedRow = borrowtbl.getSelectedRow();
        if (selectedRow >= 0) {
            int borrowerID = (int) borrowtbl.getValueAt(selectedRow, 0);
            try {
                Borrower borrower = libraryDB.getBorrowerById(borrowerID);
                if (borrower != null) {
                    String name = borrwernametxt.getText();
                    String contact = contacttxt.getText();
                    String email = emailtxt.getText();

                    borrower.setName(name);
                    borrower.setContact(contact);
                    borrower.setEmail(email);

                    libraryDB.updateBorrower(borrower);
                    displayAllBorrowers();
                    clearFields();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error updating the borrower.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a borrower to update.");
        }
    }//GEN-LAST:event_updateborrowerbtnActionPerformed

    private void displayborrowwesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayborrowwesActionPerformed
        displayAllBorrowers();
    }//GEN-LAST:event_displayborrowwesActionPerformed

    private void deleteborrowwersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteborrowwersActionPerformed
         int selectedRow = borrowtbl.getSelectedRow();
        if (selectedRow >= 0) {
            int borrowerID = (int) borrowtbl.getValueAt(selectedRow, 0);
            try {
                libraryDB.deleteBorrower(borrowerID);
                displayAllBorrowers();
                clearFields();
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error deleting the borrower.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a borrower to delete.");
        }
    }//GEN-LAST:event_deleteborrowwersActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        new MainFrame().setVisible(true);
        dispose();
    }//GEN-LAST:event_backActionPerformed

    private void searchborrowerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchborrowerActionPerformed
        String name1 = borrwernametxt.getText();
        try {
            List<Borrower> borrowers = libraryDB.getAllBorrowers();
            borrowerTableModel.setRowCount(0); // Clear existing rows

            boolean borrowerFound = false;

            for (Borrower borrower : borrowers) {
                if (borrower.getName().equalsIgnoreCase(name1)) {
                    Object[] rowData = {
                        borrower.getBorrowerID(),
                        borrower.getName(),
                        borrower.getContact(),
                        borrower.getEmail()
                    };
                    borrowerTableModel.addRow(rowData);

                    if (!borrowerFound) {
                        contacttxt.setText(borrower.getContact());
                        emailtxt.setText(borrower.getEmail());
                        borrowerFound = true;
                    }
                }
            }

            if (!borrowerFound) {
                JOptionPane.showMessageDialog(this, "No borrower found with the name: " + name1, "No Match", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error searching for the borrower.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_searchborrowerActionPerformed

    private void borrowbookbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrowbookbtnActionPerformed
         try {
        String selectedBookTitle = (String) booksavailabe.getSelectedItem();
        if (selectedBookTitle == null || selectedBookTitle.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please select a book to borrow.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int borrowerID = Integer.parseInt(borrowbookborrowerID.getText());
        Date borrowDate = java.sql.Date.valueOf(borrowdatetxt.getText()); // You may need to format the date properly
        Date returnDate = java.sql.Date.valueOf(returnDatetxt.getText()); // Same here

        // Find the Book ID by its title
        Book book = libraryDB.getBookByTitle(selectedBookTitle);
        if (book == null) {
            JOptionPane.showMessageDialog(this, "Selected book not found in the database.", "Database Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        
        java.sql.Date sqlBorrowDate = new java.sql.Date(borrowDate.getTime());
        java.sql.Date sqlReturnDate = new java.sql.Date(returnDate.getTime());

        libraryDB.borrowBook(borrowerID, book.getBookID(), sqlBorrowDate, sqlReturnDate);

        // Decrease the available copies of the book
        book.setAvailableCopies(book.getAvailableCopies() - 1);
        libraryDB.updateBook(book);

        // Refresh the combo box and tables
        populateBooksComboBox();
        displayBorrowedBooks(borrowerID);

        JOptionPane.showMessageDialog(this, "Book borrowed successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);

    } catch (SQLException | NumberFormatException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error borrowing the book. Please check the input data.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_borrowbookbtnActionPerformed

    private void returnbookbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnbookbtnActionPerformed
         try {
        int borrowerID = Integer.parseInt(borrowbookborrowerID.getText());
        int selectedRow = borrowedbookstbl.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a borrowed book to return.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int bookID = (int) borrowedbookstbl.getValueAt(selectedRow, 0);

        // Remove the entry from the BorrowedBooks table
        libraryDB.returnBook(borrowerID, bookID);

        // Increase the available copies of the book
        Book book = libraryDB.getBookById(bookID);
        if (book != null) {
            book.setAvailableCopies(book.getAvailableCopies() + 1);
            libraryDB.updateBook(book);
        }

        // Refresh the combo box and tables
        populateBooksComboBox();
        displayBorrowedBooks(borrowerID);

        JOptionPane.showMessageDialog(this, "Book returned successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);

    } catch (SQLException | NumberFormatException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error returning the book. Please check the input data.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_returnbookbtnActionPerformed

    private void clearbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearbtnActionPerformed
        clearFields();
    }//GEN-LAST:event_clearbtnActionPerformed

    
    
     private void initializeBorrowersTableSelectionListener() {
        borrowtbl.getSelectionModel().addListSelectionListener(event -> {
            if (!event.getValueIsAdjusting() && borrowtbl.getSelectedRow() != -1) {
                int selectedRow = borrowtbl.getSelectedRow();
                int borrowerID = (int) borrowtbl.getValueAt(selectedRow, 0);
                displayBorrowedBooks(borrowerID);
                populateBorrowerDetails(borrowerID);
            }
        });
    }
    
     private void displayAllBorrowers() {
        try {
            List<Borrower> borrowers = libraryDB.getAllBorrowers();
            borrowerTableModel = (DefaultTableModel) borrowtbl.getModel();
            borrowerTableModel.setRowCount(0); // Clear existing rows
            for (Borrower borrower : borrowers) {
                Object[] rowData = {
                    borrower.getBorrowerID(),
                    borrower.getName(),
                    borrower.getContact(),
                    borrower.getEmail()
                };
                borrowerTableModel.addRow(rowData);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading borrowers from the database.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
      private void displayBorrowedBooks(int borrowerID){
        try {
            List<BorrowBook> borrowBooks = libraryDB.getBorrowedBooksByBorrowerID(borrowerID);
            borrowedBooksTableModel = (DefaultTableModel) borrowedbookstbl.getModel();
            borrowedBooksTableModel.setRowCount(0); // Clear existing rows
            for (BorrowBook borrowedBook : borrowBooks) {
                Object[] rowData = {
                    borrowedBook.getBookID(),
                    borrowedBook.getTitle(),
                    borrowedBook.getAuthor(),
                    borrowedBook.getBorrowDate(),
                    borrowedBook.getReturnDate()
                };
                borrowedBooksTableModel.addRow(rowData);
            }
        } catch (SQLException e) {
              e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading borrowed books from the database.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    
    private void populateBorrowerDetails(int borrowerID){
    try{
        Borrower borrower = libraryDB.getBorrowerById(borrowerID);
        if (borrower != null) {
            borrwernametxt.setText(borrower.getName());
            contacttxt.setText(borrower.getContact());
            emailtxt.setText(borrower.getEmail());
        }
    }catch(SQLException e){
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error loading borrower details.", "Database Error", JOptionPane.ERROR_MESSAGE);
    }
    }

    private void populateBooksComboBox(){
    try{
        List<Book> books = libraryDB.getAllBooks();
        booksavailabe.removeAllItems(); 
        for (Book book : books) {
            if (book.getAvailableCopies() > 0) { 
                booksavailabe.addItem(book.getTitle());
            }
        }
    }catch(SQLException e){
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error loading books from the database.", "Database Error", JOptionPane.ERROR_MESSAGE);
    }
    }
    
    
     private void clearFields(){
        borrwernametxt.setText("");
        contacttxt.setText("");
        emailtxt.setText("");
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BorrowersManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BorrowersManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BorrowersManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BorrowersManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BorrowersManagement().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addborrowerbtn;
    private javax.swing.JButton back;
    private javax.swing.JComboBox<String> booksavailabe;
    private javax.swing.JTextField borrowbookborrowerID;
    private javax.swing.JButton borrowbookbtn;
    private javax.swing.JTextField borrowdatetxt;
    private javax.swing.JTable borrowedbookstbl;
    private javax.swing.JTable borrowtbl;
    private javax.swing.JTextField borrwernametxt;
    private javax.swing.JButton clearbtn;
    private javax.swing.JTextField contacttxt;
    private javax.swing.JButton deleteborrowwers;
    private javax.swing.JButton displayborrowwes;
    private javax.swing.JTextField emailtxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField returnDatetxt;
    private javax.swing.JButton returnbookbtn;
    private javax.swing.JButton searchborrower;
    private javax.swing.JButton updateborrowerbtn;
    // End of variables declaration//GEN-END:variables
}
