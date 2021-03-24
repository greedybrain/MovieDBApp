package tut.java.moviedb_app;

import java.io.IOException;
import java.util.List;

public class Listings {
    public static List<Movie> movies;

    static {
        try {
            movies = Scraper.getMovies();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void listingHeader() {
        System.out.println("\n=============================================================================================");
        System.out.println("\t\t\t\t\t\t\t\tTop Rated Movies of All Time");
        System.out.println("=============================================================================================");
    }

    public static void showAll() {
        listingHeader();

        for (int i = 0; i < movies.size(); i++) {

            String title = movies.get(i).getTitle();
            String moreInfoLink = movies.get(i).getMoreInfoLink();

            System.out.printf("%d. %s (%s)%n", i + 1, title, moreInfoLink);

        }

    }
}
