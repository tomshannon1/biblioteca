package com.twu.biblioteca;

import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.io.FileInputStream;

public class BookRepository
{
    private ArrayList<Book> bookRepository;

    public BookRepository()
    {
        bookRepository = new ArrayList<Book>();

        addFakeBookData();
    }

    private void addFakeBookData()
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
                String bookID = bookInformation[3];

                Book newBook = new Book(title, author, year, bookID);

                bookRepository.add(newBook);
            }
            fileContent.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }

    public ArrayList<Book> getBooks()
    {
        return this.bookRepository;
    }
}