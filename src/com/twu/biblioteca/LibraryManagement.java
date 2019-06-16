package com.twu.biblioteca;
import java.awt.SystemTray;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;
import com.twu.repositories.*;

public class LibraryManagement
{
    private Integer option;

    private static Integer FIRST_OPTION = 1;
    private static Integer LAST_OPTION = 8;

    private BookRepository bookRepository;
    private MovieRepository movieRepository;
    private UserRepository userRepository;

    private HashMap<String, Repository> repositories = new HashMap<String, Repository>();

    private Scanner optionScanner;
    private User loggedInUser;

    public LibraryManagement()
    {
        System.out.println("Welcome to Biblioteca. Your one-stop shop for great book titles in Bangalore!");
        
        bookRepository = new BookRepository();
        movieRepository = new MovieRepository();
        userRepository = new UserRepository();

        repositories.put("book", bookRepository);
        repositories.put("movie", movieRepository);
        repositories.put("users", userRepository);

        optionScanner = new Scanner(System.in); 

        loginPrompt();

        viewMenuOptions();
        getUserOption();
        reactToOption();

        optionScanner.close();
    }


    public void loginPrompt()
    {
        boolean validated = false;
        String userID;
        String password;

        do 
        {   
            System.out.print("Enter library id (XXX-XXXX): ");
            userID = optionScanner.next();

            System.out.print("Enter password: ");

            password = optionScanner.next();

            for(Object obj : repositories.get("users").getRepositoryData())
            {
                User user = (User)obj;
                if(user.validateCredentials(password, userID))
                {
                    validated = true;
                    loggedInUser = user;
                }
            }   

            if(validated == false)
            {
                System.out.println("Sorry, these credentials aren't correct. Try again.");
            }
        }
        while (validated == false);
    }

    public void viewMenuOptions()
    {
        System.out.println("Choose an option below\n");
        System.out.println("1. View list of books");
        System.out.println("2. Check out a book");
        System.out.println("3. Return a book");
        System.out.println("4. View list of movies");
        System.out.println("5. Check out a movie");
        System.out.println("6. Return a movie");

        if(loggedInUser.getLibrarianAccess())
        {
            System.out.println("7. View users checked out materials");
        }
        else
        {
            System.out.println("7. View user information");
        }

        System.out.println("8. Quit the application");
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
            viewAssets("book");
        }
        else if(option == 2)
        {
            promptUserForAssetChoice("Please enter the title of the book you wish to check out: ", "Check Out", "book");
        }
        else if(option == 3)
        {
            promptUserForAssetChoice("Please enter the title of the book you wish to return: ", "Check In", "book");
        }
        else if(option == 4)
        {
            viewAssets("movie");
        }
        else if(option == 5)
        {
            promptUserForAssetChoice("Please enter the title of the movie you wish to check out: ", "Check Out", "movie");
        }
        else if(option == 6)
        {
            promptUserForAssetChoice("Please enter the title of the movie you wish to check out: ", "Check In", "movie");
        }
        else if(option == 8)
        {
            System.exit(0);
        }
        else if(option == 7 && loggedInUser.getLibrarianAccess())
        {
            for(Object obj : repositories.get("users").getRepositoryData())
            {
                User user = (User)obj;
                
                System.out.println("Items checked out by: " + user.getName());

                for(LibraryAsset asset : user.getCheckedOutItems())
                {
                    System.out.println(asset.getInfo());
                }
                System.out.println("\n");
            }
        }
        else if(option == 7 && !loggedInUser.getLibrarianAccess())
        {
            System.out.println(loggedInUser.getInformation());
        }

        viewMenuOptions();
        getUserOption();
        reactToOption();
    }

    private void promptUserForAssetChoice(String prompt, String process, String assetType)
    {
        System.out.print(prompt);
        Scanner titleScanner = new Scanner(System.in);

        if(process.equals("Check Out"))
        {
            checkOut(titleScanner.nextLine(), assetType);
        }
        else if(process.equals("Check In"))
        {
            checkIn(titleScanner.nextLine(), assetType);
        }

        titleScanner.close();
    }

    public void viewAssets(String assetType)
    {
        System.out.println("\nBelow is a list of available " + assetType + "s for check out.");

        for(Object asset : repositories.get(assetType).getRepositoryData())
        {
            LibraryAsset libAsset = (LibraryAsset)asset;

            if(libAsset.isCheckedOut() == false)
            {
                System.out.println(libAsset.getInfo());
            }
        }
    }

    public void checkOut(String assetTitle, String assetType)
    {
        boolean assetFound = false;

        for(Object asset : repositories.get(assetType).getRepositoryData())
        {
            LibraryAsset libAsset = (LibraryAsset)asset;

            if(libAsset.getTitle().equals(assetTitle))
            {
                if(!libAsset.isCheckedOut())
                {
                    libAsset.checkOut();
                    System.out.println("Thank you! Enjoy the " + assetType + ".\n");
                    loggedInUser.checkOut(libAsset);
                }
                else
                {
                    System.out.println("Sorry, that " + assetType + " is not available.\n");
                }
                assetFound = true;
            }
        }

        if(assetFound == false)
        {
            System.out.println("Sorry, that " + assetType + " is not available. Did you spell the title correctly?\n");
        }

        viewMenuOptions();
        getUserOption();
        reactToOption();
    }

    public void checkIn(String assetTitle, String assetType)
    {
        boolean assetFound = false;

        for(Object asset : repositories.get(assetType).getRepositoryData())
        {
            LibraryAsset libAsset = (LibraryAsset)asset;

            if(libAsset.getTitle().equals(assetTitle))
            {
                if(libAsset.isCheckedOut())
                {
                    libAsset.checkIn();
                    System.out.println("Thank you for returning the " + assetType + ".\n");
                    loggedInUser.checkIn(libAsset);
                }
                else
                {
                    System.out.println("That item is not checked out to anyone.");
                }

                assetFound = true;
            }
        }

        if(assetFound == false)
        {
            System.out.println("That is not a valid " + assetType + " to return.\n");
        }

        viewMenuOptions();
        getUserOption();
        reactToOption();
    }

}
