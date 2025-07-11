package com.example.LibraryManagementSystem.Service;

import com.example.LibraryManagementSystem.Repository.BookRepo;
import com.example.LibraryManagementSystem.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    BookRepo repo;

    public Book addBook(Book book) {
        return repo.save(book);
    }

    public List<Book> getAllBooks() {
        return repo.findAll();
    }

    public Book update(Book book, int bookId) {
        if (repo.existsById(bookId)) {
            book.setBookId(bookId);
            return repo.save(book);

        } else {
            return null;
        }
    }

    public List<Book> availableBook() {
        return repo.findByAvailableCopiesGreaterThan(0);
    }

    public boolean deleteBook(int bookId) {

        Optional<Book> bookToDelete = repo.findById(bookId);
        if (bookToDelete.isPresent()) {
            repo.deleteById(bookId);
            return true;
        } else {
            return false;
        }

    }
}
