package com.hydroyura.tutorials.springauthserver.catalog.controllers;

import com.hydroyura.tutorials.springauthserver.catalog.models.Book;
import com.hydroyura.tutorials.springauthserver.catalog.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/api/books", produces = MediaType.APPLICATION_JSON_VALUE)
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        Optional<Book> book = bookService.findById(id);
        if (book.isPresent()) {
            return new ResponseEntity<>(book.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<?> findAllWithLimit(@RequestParam(defaultValue = "10") Integer limit) {
        return new ResponseEntity<>(bookService.findAllWithLimit(limit), HttpStatus.OK);
    }
}
