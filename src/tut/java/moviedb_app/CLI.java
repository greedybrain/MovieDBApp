package tut.java.moviedb_app;

import java.util.Locale;
import java.util.Scanner;

public class CLI {

    private static int getUserChoice() {
        Scanner scanner = new Scanner(System.in);

        Listings.showAll();
        while(true) {
            System.out.print("\nWhich movie do you want to see more details about? (Choose choice number): ");
            var userChoice = scanner.nextInt();
            if(userChoice < 1 || userChoice > 250) {
                System.out.println("Please choose a number from 1 to 250");
            }
            else {
                return userChoice;
            }
        }
    }

    private static void doesUserWantNewMovieDetails() throws Exception {
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("\nWould you like to check another movie? (y/n): ");
            var decision = scanner.nextLine().toLowerCase(Locale.ROOT);
            if (decision.equals("y")) {
                run();
            } else break;
        }
    }

    public static void run() throws Exception {
        var movies = Listings.movies;

        var userChoice = CLI.getUserChoice();
        var movie = Scraper.getMovie(movies.get(--userChoice));

        System.out.printf("Title: %s%n", movie.getTitle());
        System.out.print("Genres: ");
        if (movie.getGenres().size() > 1) movie.getGenres().forEach(genre -> System.out.printf("%s, ", genre));
        else movie.getGenres().forEach(genre -> System.out.printf("%s", genre));
        System.out.printf("%nRelease Date: %s%n", movie.getReleaseDate());
        System.out.printf("Runtime: %s%n", movie.getRuntime());
        System.out.printf("Synopsis: %s%n", movie.getSynopsis());
        System.out.printf("More Info: %s%n", movie.getMoreInfoLink());

        doesUserWantNewMovieDetails();
    }

}
