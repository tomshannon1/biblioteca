package com.twu.biblioteca;

public class Book
{
    private String title;
    private String author;
    private Integer year;
    private Boolean checkedOut;

    public Book(String bookTitle, String authorName, Integer yearPublished)
    {
        this.title = bookTitle;
        this.author = authorName;
        this.year = yearPublished;
        this.checkedOut = false;
    }

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

    public Boolean isCheckedOut()
    {
        return this.checkedOut;
    }

    public void checkOut()
    {
        this.checkedOut = true;
    }

    public String getBookInfo()
    {
        return "Title: " + this.title + "\nAuthor: " + this.author + "\nYear: " + year.toString() + "\n";
    }
}