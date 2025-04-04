package model;

import java.util.*;
import java.util.stream.*;

public class Library {
    int maxBorrowLimit = 5;
    String id;
    List<Rack> racks;
    Map<String, Book> bookCopies;
    Map<String, List<String>> borrowedBookCopies;
    // Map<String, Book> booksById;

    public Library(String id, int noOfRacks) {
        this.racks = new ArrayList<>();
        IntStream.range(0, noOfRacks).forEach(i -> this.racks.add(new Rack()));
        this.bookCopies = new HashMap<>();
        this.borrowedBookCopies = new HashMap<>();
    }

    public int addBook(Book book) {
        int assignedRack = -1;
        for(int i=0;i<racks.size();i++) {
            Rack rack = racks.get(i);
            if(rack.addBook(book)) {
                assignedRack = i+1;
                bookCopies.put(book.getCopyId(), book);
                // bookCopies.put(book.getId(), book);
                break;
            }
        }
        return assignedRack;
    }

    public int removeBookCopy(String bookCopyId) {
        // if(!bookCopies.contains(bookCopyId)) {
        //     return -1;
        // }

        int assignedRack = -1;
        for(int i=0;i<racks.size();i++) {
            Rack rack = racks.get(i);
            Optional<Book> bookOptional = rack.removeBook(bookCopyId);
            if(bookOptional.isPresent()) {
                assignedRack = i+1;
                bookCopies.remove(bookCopyId);
                break;
            }
        }
        return assignedRack;
    }

    public int BorrowBookCopy(String bookCopyId, String userId, String dueDate) {
        // if(!bookCopies.contains(bookCopyId)) {
        //     return -1;
        // }

        int assignedRack = -1;
        for(int i=0;i<racks.size();i++) {
            Rack rack = racks.get(i);
            Optional<Book> bookOptional = rack.removeBook(bookCopyId);
            if(bookOptional.isPresent()) {
                Book book = bookOptional.get();
                handleBookBorrowing(userId, dueDate, book);
                assignedRack = i+1;
                break;
            }
        }
        return assignedRack;
    }

    public int BorrowBook(String bookCopyId, String userId, String dueDate) {
        // if(!bookCopies.contains(bookCopyId)) {
        //     return -1;
        // }

        int assignedRack = -1;
        for(int i=0;i<racks.size();i++) {
            Rack rack = racks.get(i);
            Optional<Book> bookOptional = rack.removeBook(bookCopyId);
            if(bookOptional.isPresent()) {
                Book book = bookOptional.get();
                handleBookBorrowing(userId, dueDate, book);
                assignedRack = i+1;
                break;
            }
        }
        return assignedRack;
    }

    public int BorrowBookById(String bookId, String userId, String dueDate) {
        // if(!bookCopies.contains(bookCopyId)) {
        //     return -1;
        // }

        int assignedRack = -1;
        for(int i=0;i<racks.size();i++) {
            Rack rack = racks.get(i);
            Optional<Book> bookOptional = rack.removeBookById(bookId);
            if(bookOptional.isPresent()) {
                Book book = bookOptional.get();
                book.setBorrowed(true);
                book.setBorrowedByUserId(userId);
                book.setDueDate(dueDate);
                assignedRack = i+1;
                break;
            }
        }
        return assignedRack;
    }

    public int returnBookCopy(String bookCopyId) {
        if(!this.bookCopies.containsKey(bookCopyId))
            return -1;
        Book bookToBeReturned = bookCopies.get(bookCopyId);
        bookToBeReturned.setBorrowed(false);
        bookToBeReturned.setBorrowedByUserId(null);
        bookToBeReturned.setDueDate(null);
        return addBook(bookToBeReturned);
    }

    public List<Book> getBorrowedBooks(String userId) {
        return borrowedBookCopies.get(userId).stream().map(id -> bookCopies.get(id)).collect(Collectors.toList());
    }

    private void handleBookBorrowing(String userId, String dueDate, Book book) {
        book.setBorrowed(true);
        book.setBorrowedByUserId(userId);
        book.setDueDate(dueDate);
        List<String> borrowedCopyIds = borrowedBookCopies.getOrDefault(userId, new ArrayList<>());
        borrowedCopyIds.add(book.getCopyId());
        borrowedBookCopies.put(userId, borrowedCopyIds);
    }
 


}
