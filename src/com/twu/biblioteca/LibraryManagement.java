package com.twu.biblioteca;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LibraryManagement
{
    private Integer option;

    private static Integer FIRST_OPTION = 1;
    private static Integer LAST_OPTION = 4;

    private BookRepository bookRepository;
    private Scanner optionScanner;

    public LibraryManagement()
    {
        System.out.println("Welcome to Biblioteca. Your one-stop shop for great book titles in Bangalore!");
        
        bookRepository = new BookRepository();
        optionScanner = new Scanner(System.in); 

        viewMenuOptions();
        getUserOption();
        reactToOption();

        optionScanner.close();
    }

    public void viewMenuOptions()
    {
        System.out.println("Choose an option below\n");
        System.out.println("1. View list of books");
        System.out.println("2. Check out a book");
        System.out.println("3. Return a book");
        System.out.println("4. Quit the application");
    }

    public void getUserOption()
    {
        do 
        {
            System.out.print("Enter option: ");

            while(!optionScanner.hasNextInt())
            {
                System.out.print("Please select a valid option! Enter option: ");
                optionScanner.next();
            }

            option = optionScanner.nextInt();
        }
        while (option == null || option < FIRST_OPTION || option > LAST_OPTION);
    }

    public Integer getChoice()
    {
        return option;
    }

    public void reactToOption()
    {
        if(option == 1)
        {
            viewBooks();
        }
    }

    public void viewBooks()
    {
        System.out.println("\nBelow is a list of available books for check out.\n");

        for(Book book : bookRepository.getBooks())
        {
            if(book.isCheckedOut() == false)
            {
                System.out.println(book.getBookInfo());
            }
        }

        viewMenuOptions();
        getUserOption();
        reactToOption();
    }

}