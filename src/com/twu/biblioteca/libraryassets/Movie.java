package com.twu.biblioteca;

public class Movie extends LibraryAsset
{
    private String movieName;
    private Integer movieYear;
    private String directorName;
    private String movieRating;

    public Movie(String name, Integer year, String director, String rating)
    {
        super();
        this.movieName = name;
        this.movieYear = year;
        this.directorName = director;
        this.movieRating = rating;
    }

    @Override
    public String getTitle()
    {
        return this.movieName;
    }

    public Integer getMovieYear()
    {
        return this.movieYear;
    }

    public String getDirectorName()
    {
        return this.directorName;
    }

    public String getMovieRating()
    {
        return this.movieRating;
    }

    public String getInfo()
    {
        return "Movie name: " + this.movieName + "\nMovie year: " + Integer.toString(this.movieYear) + "\nDirector: " + this.directorName + "\nMovie rating: " + this.movieRating + "\n";
    }
}