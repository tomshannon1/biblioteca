package com.twu.biblioteca;

import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.io.FileInputStream;

public abstract class Repository
{
    private ArrayList<Object> repository;

    public LibraryAssetRepository()
    {
        repository = new ArrayList<Object>();

        addPreDefinedData();
    }

    public ArrayList<Object> getRepositoryData()
    {
        return this.repository;
    }

    public void appepndToRepo(Object object)
    {
        repository.add(obeject);
    }

    public abstract addPreDefinedData();
}