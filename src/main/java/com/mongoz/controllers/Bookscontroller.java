package com.mongoz.controllers;

import com.mongoz.entities.Book;
import com.mongoz.entities.Review;
import com.mongoz.repositories.Booksrepo;
import com.mongoz.repositories.Reviewrepositor;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("book")
public class Bookscontroller {
    @Autowired
    private Booksrepo bookrepo;

    @Autowired
    private Reviewrepositor reviewrepo;

    @GetMapping("get-all")
    public List<Book> getAllBooks()
    {
        return bookrepo.findAll();
    }

    @GetMapping("get/{idbook}")
    public void getBookById(@PathVariable("idbook") Long idbook)
    {
        bookrepo.findById(idbook);
    }


    @PostMapping("add")
    public Book addBook(@RequestBody Book book)
    {
        return bookrepo.save(book);
    }

    @PutMapping("update")
    public Book updateBook(@RequestBody Book book)
    {
        return bookrepo.save(book);
    }

    @DeleteMapping("delete/{idbook}")
    public void deleteBook(@PathVariable("idbook") Long idbook)
    {
        bookrepo.deleteById(idbook);
    }




    @PostMapping("{idbook}/add-review")
    public Book addReviewToBook(@PathVariable("idbook") Long idbook, @RequestBody Review review) {
        Optional<Book> optionalBook = bookrepo.findById(idbook);
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            review.setBookId(idbook);
            book.getReviews().add(review);
            return bookrepo.save(book);
        } else {
            // do internal logger later "Book not found with id: " + idbook
           return null;
        }
    }

    @DeleteMapping("{idbook}/remove-review/{idreview}")
    public Book removeReviewFromBook(@PathVariable("idbook") Long idbook, @PathVariable("idreview") Long idreview) {
        Optional<Book> optionalBook = bookrepo.findById(idbook);
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            book.getReviews().removeIf(review -> review.getId().equals(idreview));
            return bookrepo.save(book);
        } else {
            return null;
        }
    }



}
