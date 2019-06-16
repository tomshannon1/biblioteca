package com.twu.biblioteca;

import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.io.FileInputStream;

import com.twu.biblioteca.users.User;

public class UserRepository implements Repository<User>
{
    ArrayList<User> usersRepo = new ArrayList<User>();

    public UserRepository()
    {
        addPreDefinedData();
    }

    public void addPreDefinedData()
    {
        try
        {
            Scanner fileContent = new Scanner(new File("data/users.txt"));

            while(fileContent.hasNextLine())
            {
                String userInformation [] = fileContent.nextLine().split(", ");
                
                String name = userInformation[0];
                String libraryID = userInformation[1];
                String password = userInformation[2];
                String email = userInformation[3];
                String phoneNumber = userInformation[4];
                Boolean librarianAccess = Boolean.parseBoolean(userInformation[5]);

                User newUser = new User(name, libraryID, password, email, phoneNumber, librarianAccess);

                appendToRepo(newUser);
            }
            fileContent.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void appendToRepo(User user)
    {
        this.usersRepo.add(user);
    }

    public ArrayList<User> getRepositoryData()
    {
        return this.usersRepo;
    }

}