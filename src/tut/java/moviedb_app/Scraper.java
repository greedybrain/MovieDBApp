package tut.java.moviedb_app;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashMap;

public class Scraper {
    private static final String URL = "https://www.imdb.com/chart/top/?ref_=nv_mv_250";

    private static Document fromHtmlData() throws IOException {
        return Jsoup.connect(URL).get();
    }

    private static Elements getMovieListRows() throws IOException {
        return fromHtmlData().select(".lister-list tr");
    }

    public static HashMap<String, String> hashedMovies() throws IOException {
        HashMap<String, String> movies = new HashMap<>();
        for (Element movie : getMovieListRows()) {
            String title = movie.select("a").text();
            String link = movie.select("a").attr("href");
            movies.put(title, link);
        }
        return movies;
    }

}
