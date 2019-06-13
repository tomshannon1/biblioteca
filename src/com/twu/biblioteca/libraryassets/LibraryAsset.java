package com.twu.biblioteca;

public abstract class LibraryAsset
{
    private boolean checkedOut = false;
    private String title;

    public void checkOut()
    {
        this.checkedOut = true;
    }

    public void checkIn()
    {
        this.checkedOut = false;
    }

    public String getTitle()
    {
        return this.title;
    }
    public boolean isCheckedOut()
    {
        return this.checkedOut;
    }

    public abstract String getInfo();
}