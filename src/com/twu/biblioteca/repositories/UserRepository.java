package com.twu.biblioteca;

import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.io.FileInputStream;

public class UserRepository extends Repository
{
    public UserRepository()
    {
        super();
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

                User newUser = new User(name, libraryID, password, email, phoneNumber);

                appepndToRepo(newUser);
            }
            fileContent.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }
}