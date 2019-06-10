package com.twu.biblioteca;

import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.io.FileInputStream;

import com.twu.biblioteca.libraryassets.Book;

public class BookRepository implements Repository<Book>
{

    ArrayList<Book> booksRepo = new ArrayList<Book>();

    public BookRepository()
    {
        addPreDefinedData();
    }

    public void addPreDefinedData()
    {
        try
        {
            Scanner fileContent = new Scanner(new File("data/books.txt"));

            while(fileContent.hasNextLine())
            {
                String bookInformation [] = fileContent.nextLine().split(", ");
                
                String title = bookInformation[0];
                String author = bookInformation[1];
                Integer year = Integer.parseInt(bookInformation[2]);

                Book newBook = new Book(title, author, year);

                appendToRepo(newBook);
            }
            fileContent.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void appendToRepo(Book book)
    {
        this.booksRepo.add(book);
    }

    public ArrayList<Book> getRepositoryData()
    {
        return this.booksRepo;
    }
}