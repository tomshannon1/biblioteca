package com.twu.biblioteca;

public class User
{
     private String libraryNumber;
     private String name;
     private String email;
     private String phoneNumber; 
     private String password;

     public User(String userName, String libraryID, String password, String email, String phoneNumber)
     {
         this.name = userName;
         this.libraryNumber = libraryID;
         this.password = password;
         this.email = email;
         this.phoneNumber = phoneNumber;
     }

     public String getLibraryNumber()
     {
        return this.libraryNumber;
     }

     protected String getPassword()
     {
        return this.password;
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