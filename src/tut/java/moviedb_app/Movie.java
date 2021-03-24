package tut.java.moviedb_app;

import java.util.List;

public class Movie {
    private String title;
    private String moreInfoLink;
    private String runtime;
    private List<String> genres;
    private String releaseDate;
    private String synopsis;

    public Movie(String title, String moreInfoLink){
        this.title = title;
        this.moreInfoLink = moreInfoLink;
    }

    public Movie(
            String title,
            String moreInfoLink,
            String runtime,
            List<String> genres,
            String releaseDate,
            String synopsis) {
        this.title = title;
        this.moreInfoLink = moreInfoLink;
        this.runtime = runtime;
        this.genres = genres;
        this.releaseDate = releaseDate;
        this.synopsis = synopsis;
    }

    // Getter and Setters
    public void setRuntime(String runtime) { this.runtime = runtime; }
    public void setGenres(List<String> genres) { this.genres = genres; }
    public void setReleaseDate(String releaseDate) { this.releaseDate = releaseDate; }
    public void setSynopsis(String synopsis) { this.synopsis = synopsis; }

    public String getTitle() { return title; }
    public String getMoreInfoLink() { return moreInfoLink; }
    public String getRuntime() { return runtime; }
    public List<String> getGenres() { return genres; }
    public String getReleaseDate() { return releaseDate; }
    public String getSynopsis() { return synopsis; }
}
