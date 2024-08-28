package models;

public class Borrower {
    private int borrowerID;
    private String name;
    private String contact;
    private String email;

    public Borrower(int  borrowerID, String name, String contact, String email) {
        this.borrowerID = borrowerID;
        this.name = name;
        this.contact = contact;
        this.email = email;
    }

 

    public int getBorrowerID() {
        return borrowerID;
    }

    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

