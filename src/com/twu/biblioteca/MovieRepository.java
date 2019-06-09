package com.twu.biblioteca;

import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.io.FileInputStream;

public class MovieRepository extends Repository
{
    public MovieRepository()
    {
        super();
    }

    public void addPreDefinedData()
    {
        try
        {
            Scanner fileContent = new Scanner(new File("data/movies.txt"));

            while(fileContent.hasNextLine())
            {
                String movieInformation [] = fileContent.nextLine().split(", ");
                
                String name = bookInformation[0];
                String director = bookInformation[1];
                Integer rating = Integer.parseInt(bookInformation[2]);

                Movie newMovie = new Movie(name, director, rating);

                appepndToRepo(newMovie);
            }
            fileContent.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }
}