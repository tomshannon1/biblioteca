package com.twu.biblioteca;

import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.io.FileInputStream;

public interface Repository<T>
{
    public void appendToRepo(T object);

    public addPreDefinedData();

    public ArrayList<T> getRepositoryData();
}