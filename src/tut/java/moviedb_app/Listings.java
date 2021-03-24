package tut.java.moviedb_app;

import java.io.IOException;
import java.util.HashMap;

public class Listings {

    public static void listingHeader() {
        System.out.println("\n=============================================================================================");
        System.out.println("\t\t\t\t\t\t\t\tTop Rated Movies of All Time");
        System.out.println("=============================================================================================");
    }

    public static void showAll() throws IOException {
        listingHeader();
        var hashedMovies = Scraper.hashedMovies();
        for (int i = 0; i < hashedMovies.size(); i++) {
            var movieTitles = hashedMovies.keySet().toArray();
            var movieLinks = hashedMovies.values().toArray();
            System.out.printf("%d. %s (https://www.imdb.com%s)%n", i + 1, movieTitles[i], movieLinks[i]);
        }
    }
}
