package tut.java.moviedb_app;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ScraperTest {

    @org.junit.jupiter.api.Test
    void getMovies() throws IOException {
        var movies = Scraper.getMovies();
        var moviesLength = movies.size();

        assertEquals(250, moviesLength);
    }

    @org.junit.jupiter.api.Test
    void getMovie() throws IOException {
        var _movie = new Movie("Lorem Ipsum", "https://google.com");
        var movie = Scraper.getMovie(_movie);
        Boolean hasValidSynopsis = movie.getSynopsis() != null;

        assertEquals(true, hasValidSynopsis);
    }
}