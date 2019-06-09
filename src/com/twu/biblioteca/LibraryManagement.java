package com.twu.biblioteca;
import java.util.Scanner;

public class LibraryManagement
{
    private Integer option;
    private static Integer FIRST_OPTION = 1;
    private static Integer LAST_OPTION = 4;

    public LibraryManagement()
    {
        System.out.println("Welcom to Biblioteca. Your one-stop shop for great book titles in Bangalore!");
        
        viewMenuOptions();
        getUserOption();
    }

    public void viewMenuOptions()
    {
        System.out.println("Choose an option below to get started.\n");
        System.out.println("1. View list of books");
        System.out.println("2. Check out a book");
        System.out.println("3. Return a book");
        System.out.println("4. Quit the application");
    }

    public void getUserOption()
    {
        Scanner scanner = new Scanner(System.in); 
       
        System.out.print("Enter option: ");
        option = scanner.nextInt();
        
        while (option == null || option < FIRST_OPTION || option > LAST_OPTION)
        {
            System.out.print("Please select a valid option! Enter option: ");
            option = scanner.nextInt();
        }

        scanner.close();
    }

    public Integer getChoice()
    {
        return option;
    }

}