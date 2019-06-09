package com.twu.biblioteca;

public class User
{
     private String libraryNumber;
     private String name;
     private String email;
     private String phoneNumber;

     public User(String userLibraryNumber, String userName, String userEmail, String userPhoneNumber)
     {
         this.libraryNumber = userLibraryNumber;
         this.name = userName;
         this.email = userEmail;
         this.phoneNumber = userPhoneNumber;
     }

     public String getLibraryNumber()
     {
        return this.libraryNumber;
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
}