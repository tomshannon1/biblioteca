package com.twu.biblioteca;


import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.beans.Transient;

public class ReleaseOneTest 
{
    private LibraryManagement library;
    
    private static int LAST_OPTION = 7;
    private static int FIRST_OPTION = 1;

    @Before
    public void setUp()
    {
        library = new LibraryManagement();
    }

    @Test
    public void checkOutBookTest() 
    {
        assertEquals("You have successfully checked out Huckleberry Finn by Mark Twain.", library.checkOut("Huckleberry Finn"));
        assertEquals("Unfortnately, this book cannot be checked out.", library.checkOut("Le Petit Prince"));
    }

    @Test
    public void returnBookTest()
    {
        assertEquals("You have successfully returned Huckleberry Finn by Mark Twain.", library.checkIn("Huckleberry Finn by Mark Twain"));
        assertEquals("Unfortunately, this book was unsuccessfully returned.", library.checkIn("1984 by George Orwell"));
    }

    @Test
    public void invalidMenuOption()
    {
        assert(library.getChoice() <= LAST_OPTION);
        assert(library.getChoice() >= FIRST_OPTION);
    }
}
