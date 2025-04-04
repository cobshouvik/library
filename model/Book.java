package model;

import java.util.*;

public class Book {
    final String id;
    final String copyId;
    final String title;
    final Set<String> authors;
    final Set<String> publishers;
    boolean borrowed = false;
    String borrowedByUserId = null;
    String dueDate = null;

    public Book(String id, String copyId, String title, Set<String> authors, Set<String> publishers){
        this.id = id;
        this.copyId = copyId;
        this.title = title;
        this.authors = authors;
        this.publishers = publishers;
    }

    public void setBorrowedByUserId(String borrowedByUserId) {
        this.borrowedByUserId = borrowedByUserId;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public void setBorrowed(boolean value) {
        this.borrowed = value;
    }

    public boolean isBorrowed() {
        return this.borrowed;
    }

    public String getId() {
        return this.id;
    }

    public String getCopyId() {
        return this.copyId;
    }

    public String getTitle() {
        return this.title;
    }

    public Set<String> getAuthors() {
        return this.authors;
    }

    public Set<String> getPublishers() {
        return this.publishers;
    }

    public String getBorrowedByUserId() {
        return this.borrowedByUserId;
    }

    public String getDueDate() {
        return this.dueDate;
    }
}
