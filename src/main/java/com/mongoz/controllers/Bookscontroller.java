package com.mongoz.controllers;

import com.mongoz.entities.Book;
import com.mongoz.repositories.Booksrepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("book")
public class Bookscontroller {
    @Autowired
    private Booksrepo bookrepo;

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


}
