package com.example.LibraryManagementSystem.Controller;

import com.example.LibraryManagementSystem.Service.BookService;
import com.example.LibraryManagementSystem.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/book")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        Book AddedBook = bookService.addBook(book);
        if (AddedBook != null) {
            return ResponseEntity.ok().body(AddedBook);

        } else {
            return ResponseEntity.internalServerError().build();
        }

    }

    @GetMapping("/book")
    public ResponseEntity<List<Book>> getAllBook() {
        List<Book> book = bookService.getAllBooks();
        if (book.isEmpty()) {
            return ResponseEntity.notFound().build();

        } else {

            return ResponseEntity.ok(book);
        }
    }

    @PutMapping("/book/{id}")
    public ResponseEntity<Book> updateBook(@RequestBody Book book, @PathVariable("id") int bookId) {
        Book updatedBook = bookService.update(book, bookId);
        if (updatedBook == null) {
            return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.ok().body(updatedBook);
        }
    }

    @GetMapping("/book/available")
    public ResponseEntity<List<Book>> OnlyAvailable() {
        List<Book> books = bookService.availableBook();
        if (books.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(books);
        }
    }

    @DeleteMapping("/book/{id}")
    public ResponseEntity<String> deletedBook(@PathVariable("id") int bookId) {

        boolean deletedBook = bookService.deleteBook(bookId);
        if (deletedBook) {
            return ResponseEntity.ok("Successfully deleted");
        } else {
            return ResponseEntity.notFound().build();
        }

    }
}
