package com.twu.biblioteca;

public class LibraryManagement
{
    public LibraryManagement()
    {
        System.out.println("Welcome to the Biblioteca Library Management System!");
        viewMenuOptions();
    }

    public void viewMenuOptions()
    {
        System.out.println("Choose an option below to get started.\n");
        System.out.println("1. View list of books");
        System.out.println("2. Check out a book");
        System.out.println("3. Return a book");
        System.out.println("4. Quit the application");
    }
}