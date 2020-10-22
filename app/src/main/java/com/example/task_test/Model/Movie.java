package com.example.task_test.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Movie {
    @SerializedName("title")
    private String title;
    @SerializedName("image")
    private String image;
    @SerializedName("rating")
    private String rating;
    @SerializedName("releaseYear")
    private String releaseYear;
    @SerializedName("genre")
    private List<String> genre;

    public Movie(String title, String image, String rating, String releaseYear, List<String> genre) {
        this.title = title;
        this.image = image;
        this.rating = rating;
        this.releaseYear = releaseYear;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }

    public List<String> getGenre() {
        return genre;
    }

    public void setGenre(List<String> genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", image='" + image + '\'' +
                ", rating='" + rating + '\'' +
                ", releaseYear=" + releaseYear +
                ", genre=" + genre +
                '}';

    }
}
