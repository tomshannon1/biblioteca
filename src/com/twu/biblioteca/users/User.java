package com.twu.biblioteca;
import java.util.ArrayList;

public class User
{
     private String libraryNumber;
     private String name;
     private String email;
     private String phoneNumber; 
     private String password;
     private Boolean librarianAccess;

     private ArrayList<LibraryAsset> checkedOut = new ArrayList<LibraryAsset>();

     public User(String userName, String libraryID, String password, String email, String phoneNumber, Boolean librarianAccess)
     {
         this.name = userName;
         this.libraryNumber = libraryID;
         this.password = password;
         this.email = email;
         this.phoneNumber = phoneNumber;
         this.librarianAccess = librarianAccess;
     }

     public String getLibraryNumber()
     {
        return this.libraryNumber;
     }

     public Boolean getLibrarianAccess()
     {
        return this.librarianAccess;
     }

     protected String getPassword()
     {
        return this.password;
     }

     public void checkOut(LibraryAsset asset) 
     {
        this.checkedOut.add(asset);
     }

     public void checkIn(LibraryAsset asset)
     {
         this.checkedOut.remove(asset);
     }

     public String getName()
     {
        return this.name;
     }

     public String getEmail()
     {
        return this.email;
     }

     public String getPhoneNumber()
     {
        return this.phoneNumber;
     }

     public ArrayList<LibraryAsset> getCheckedOutItems()
     {
        return this.checkedOut;
     }

     public String getInformation()
     {
        return this.name + "\n" + this.email + "\n" + this.phoneNumber + "\n";
     }

     public Boolean validateCredentials(String password, String userID)
     {
         return this.password.equals(password) && this.libraryNumber.equals(userID);
     }
}