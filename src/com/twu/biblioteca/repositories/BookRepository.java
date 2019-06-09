package com.twu.biblioteca;

import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.io.FileInputStream;

public class BookRepository extends Repository
{
    public BookRepository()
    {
        super();
    }

    public void addPreDefinedData()
    {
        try
        {
            Scanner fileContent = new Scanner(new File("bookdata/books.txt"));

            while(fileContent.hasNextLine())
            {
                String bookInformation [] = fileContent.nextLine().split(", ");
                
                String title = bookInformation[0];
                String author = bookInformation[1];
                Integer year = Integer.parseInt(bookInformation[2]);

                Book newBook = new Book(title, author, year);

                appepndToRepo(newBook);
            }
            fileContent.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }
}