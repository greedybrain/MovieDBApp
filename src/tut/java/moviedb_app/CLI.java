package tut.java.moviedb_app;

import java.util.Scanner;

public class CLI {

    public int getUserChoice() throws Exception {
        Scanner scanner = new Scanner(System.in);

        Listings.showAll();
        while(true) {
            System.out.print("\nWhich movie do you want to see more details about? (Choose choice number): ");
            var userChoice = scanner.nextInt();
            if(userChoice < 1 || userChoice > 250) {
                System.out.println("Please choose a number from 1 to 10");
                continue;
            }
            else {
                return userChoice;
            }
        }
    }

    public static void run() throws Exception {
        Listings.showMovieInfo();
    }

}
