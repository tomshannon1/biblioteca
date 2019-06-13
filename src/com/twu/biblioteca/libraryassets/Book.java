package com.twu.biblioteca;


public class Book extends LibraryAsset
{
    private String title;
    private String author;
    private Integer year;

    public Book(String bookTitle, String authorName, Integer yearPublished)
    {
        super();
        this.title = bookTitle;
        this.author = authorName;
        this.year = yearPublished;
    }

    @Override
    public String getTitle()
    {
        return this.title;
    }

    public String getAuthor()
    {
        return this.author;
    }   

    public Integer getYear()
    {
        return this.year;
    }

    public String getInfo()
    {
        return "Title: " + this.title + "\nAuthor: " + this.author + "\nYear: " + year.toString() + "\n";
    }
}