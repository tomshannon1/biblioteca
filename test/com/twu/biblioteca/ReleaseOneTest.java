package com.twu.biblioteca;


import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.beans.Transient;

public class ReleaseOneTest 
{
    private LibraryManagement library;

    @Before
    public void setUp()
    {
        library = new LibraryManagement();
    }

    @Test
    public void checkOutBookTest() 
    {
        assertEquals("You have successfully checked out Huckleberry Finn by Mark Twain.", library.checkOut("Huckleberry Finn by Mark Twain"));
        assertEquals("Unfortnately, this book cannot be checked out.", library.checkOut("Le Petit Prince by Antoine de Saint-Exupéry"));
    }

    @Test
    public void returnBookTest()
    {
        assertEquals("You have successfully returned Huckleberry Finn by Mark Twain.", library.returnBook("Huckleberry Finn by Mark Twain"));
        assertEquals("Unfortunately, this book was unsuccessfully returned.", library.returnBook("1984 by George Orwell"));
    }

    @Test
    public void invalidMenuOption()
    {
        
    }
}
