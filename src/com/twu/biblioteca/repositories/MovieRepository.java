package com.twu.biblioteca;

import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.io.FileInputStream;

import com.twu.biblioteca.libraryassets.Movie;

public class MovieRepository implements Repository<Movie>
{

    ArrayList<Movie> moviesRepo = new ArrayList<Movie>();

    public MovieRepository()
    {
        addPreDefinedData();
    }

    public void addPreDefinedData()
    {
        try
        {
            Scanner fileContent = new Scanner(new File("data/movies.txt"));

            while(fileContent.hasNextLine())
            {
                String movieInformation [] = fileContent.nextLine().split(", ");
                
                String name = movieInformation[0];
                Integer year = Integer.parseInt(movieInformation[1]);
                String director = movieInformation[2];
                String rating = movieInformation[3];

                Movie newMovie = new Movie(name, year, director, rating);

                appendToRepo(newMovie);
            }
            fileContent.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }

    public void appendToRepo(Movie movie)
    {
        this.moviesRepo.add(movie);
    }

    public ArrayList<Movie> getRepositoryData()
    {
        return this.moviesRepo;
    }
}