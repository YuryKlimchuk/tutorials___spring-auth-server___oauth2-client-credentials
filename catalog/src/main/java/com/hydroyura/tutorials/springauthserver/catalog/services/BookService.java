package com.hydroyura.tutorials.springauthserver.catalog.services;

import com.github.javafaker.Faker;
import com.hydroyura.tutorials.springauthserver.catalog.models.Author;
import com.hydroyura.tutorials.springauthserver.catalog.models.Book;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class BookService {

    @Autowired
    private Faker faker;
    private List<Book> repository;
    private Integer BOOKS_COUNT = 1_000;
    private Integer AUTHORS_COUNT = 25;

    @PostConstruct
    void initBookRepository() {
        Random random = new Random();
        List<Author> AUTHORS = IntStream.range(0, AUTHORS_COUNT)
            .mapToObj(i -> new Author()
                .setFirstname(faker.name().firstName())
                .setLastname(faker.name().lastName())
                .setBirthday(faker.date().birthday(20, 70)
                    .toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDateTime()))
                .collect(Collectors.toCollection(ArrayList::new));
        List<String> LANGS = List.of("en", "ro", "de", "ru", "fr");
        repository = IntStream.range(0, BOOKS_COUNT)
            .mapToObj(i -> new Book()
                .setId(i)
                .setAuthor(AUTHORS.get(random.nextInt(AUTHORS.size())))
                .setPages(random.nextInt(100, 1000))
                .setGenre(faker.book().genre())
                .setLang(LANGS.get(random.nextInt(LANGS.size())))
                .setTitle(faker.book().title()))
            .peek(System.out::println)
            .collect(Collectors.toCollection(ArrayList::new));
    }

    public Optional<Book> findById(Integer id) {
        return Optional.ofNullable(repository.get(id));
    }

    public List<Book> findAllWithLimit(Integer limit) {
        return repository
            .stream()
            .limit(limit)
            .collect(Collectors.toCollection(ArrayList::new));
    }
}
