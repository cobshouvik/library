package model;
import java.util.*;

public class Rack {
    List<Book> books;

    public Rack() {
        this.books = new ArrayList<>();
    }

    public boolean addBook(Book book) {
        if(this.books.stream()
                    .map(storedBook -> storedBook.getId())
                    .filter(id -> book.getId().equals(id))
                    .findAny()
                    .isPresent())
            return false;
        books.add(book);
        return true;
    }

    public Optional<Book> removeBook(String bookCopyId) {
        int removedBookIndex = -1;
        for(int i=0; i<this.books.size(); i++) {
            if(this.books.get(i).getCopyId().equals(bookCopyId)) {
                removedBookIndex = i;
                break;
            }
        }
        if(removedBookIndex == -1) {
            return Optional.empty();
        }

        Book removedBook = this.books.remove(removedBookIndex);
        return Optional.of(removedBook);
    }

    public Optional<Book> removeBookById(String bookId) {
        int removedBookIndex = -1;
        for(int i=0; i<this.books.size(); i++) {
            if(this.books.get(i).getId().equals(bookId)) {
                removedBookIndex = i;
                break;
            }
        }
        if(removedBookIndex == -1) {
            return Optional.empty();
        }

        Book removedBook = this.books.remove(removedBookIndex);
        return Optional.of(removedBook);
    }


}
