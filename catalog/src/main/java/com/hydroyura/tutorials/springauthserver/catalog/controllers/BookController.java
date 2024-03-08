package com.hydroyura.tutorials.springauthserver.catalog.controllers;

import com.hydroyura.tutorials.springauthserver.catalog.models.Book;
import com.hydroyura.tutorials.springauthserver.catalog.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Role;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/books", produces = MediaType.APPLICATION_JSON_VALUE)
public class BookController {

    @Autowired
    private BookService bookService;


    @GetMapping
    @PreAuthorize("hasAuthority('SCOPE_read.only')")
    public ResponseEntity<?> findAllWithLimit(JwtAuthenticationToken principal, @RequestParam(defaultValue = "10") Integer limit) {
        return new ResponseEntity<>(bookService.findAllWithLimit(limit), HttpStatus.OK);
    }


}
