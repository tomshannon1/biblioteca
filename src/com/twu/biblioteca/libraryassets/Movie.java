package com.twu.biblioteca;

public class Movie extends LibraryAsset
{
    private String movieName;
    private String directorName;
    private Integer movieRating;

    public Movie(String name, String director, Integer rating)
    {
        super();
        this.movieName = name;
        this.directorName = director;
        this.movieRating = rating;
    }

    public String getMovieName()
    {
        return this.movieName;
    }

    public String getDirectorName()
    {
        return this.directorName;
    }

    public Integer getMovieRating()
    {
        return this.movieRating;
    }

    public String getMovieInformation()
    {
        return "Movie name: " + this.movieName + "\nDirector: " + this.directorName + "\nMovie rating: " + this.movieRating + "\n";
    }
}