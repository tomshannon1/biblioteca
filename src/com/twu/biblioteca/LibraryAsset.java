package com.twu.biblioteca;

public abstract class LibraryAsset
{
    private boolean checkedOut = false;

    public void checkOut()
    {
        this.checkedOut = true;
    }

    public void checkIn()
    {
        this.checkedOut = false;
    }

    public boolean isCheckedOut()
    {
        return this.checkedOut;
    }
}