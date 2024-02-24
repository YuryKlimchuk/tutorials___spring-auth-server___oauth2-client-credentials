package com.hydroyura.tutorials.springauthserver.catalog.models;

public class Book {

    private Integer id;
    private String title;
    private String genre;
    private String lang;
    private Integer pages;
    private Author author;


    public Book() {}


    public Integer getId() {
        return id;
    }

    public Book setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Book setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getGenre() {
        return genre;
    }

    public Book setGenre(String genre) {
        this.genre = genre;
        return this;
    }

    public String getLang() {
        return lang;
    }

    public Book setLang(String lang) {
        this.lang = lang;
        return this;
    }

    public Integer getPages() {
        return pages;
    }

    public Book setPages(Integer pages) {
        this.pages = pages;
        return this;
    }

    public Author getAuthor() {
        return author;
    }

    public Book setAuthor(Author author) {
        this.author = author;
        return this;
    }

    @Override
    public String toString() {
        return "Book{" +
                " id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", lang='" + lang + '\'' +
                ", pages=" + pages +
                ", author=" + author +
                '}';
    }
}
