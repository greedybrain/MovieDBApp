package tut.java.moviedb_app;

import java.io.IOException;

public class Listings {

    public static void listingHeader() {
        System.out.println("\n=============================================================================================");
        System.out.println("\t\t\t\t\t\t\t\tTop Rated Movies of All Time");
        System.out.println("=============================================================================================");
    }

    public static void showAll() throws IOException {
        listingHeader();

        var movies = Scraper.getMovies();

        for (int i = 0; i < movies.size(); i++) {

            String title = movies.get(i).getTitle();
            String moreInfoLink = movies.get(i).getMoreInfoLink();

            System.out.printf("%d. %s (%s)%n", i + 1, title, moreInfoLink);

        }

    }

    public static void showMovieInfo(Movie movie) {
        System.out.printf("Title: %s%n", movie.getTitle());
        System.out.print("Genres: ");
        movie.getGenres().forEach(genre -> System.out.printf("%s", genre));
        System.out.printf("%nRelease Date: %s%n", movie.getReleaseDate());
        System.out.printf("Runtime: %s%n", movie.getRuntime());
        System.out.printf("Synopsis: %s%n", movie.getSynopsis());
        System.out.printf("More Info: %s%n", movie.getMoreInfoLink());
    }
}
