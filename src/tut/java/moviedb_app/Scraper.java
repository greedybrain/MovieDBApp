package tut.java.moviedb_app;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Scraper {
    private static final String URL = "https://www.imdb.com/chart/top/?ref_=nv_mv_250";

    private static Document fromMainHtmlData() throws IOException {
        return Jsoup.connect(URL).get();
    }

    private static Elements getMovieListRows() throws IOException {
        return fromMainHtmlData().select(".lister-list tr");
    }

    public static List<Movie> getMovies() throws IOException {
        List<Movie> movies = new ArrayList<>();

        for (Element movie : getMovieListRows()) {

            String title = movie.select("a").text();
            String link = String.format("https://www.imdb.com%s", movie.select("a").attr("href"));

            movies.add(new Movie(title, link));
        }
        return movies;
    }

    private static Document getSingleMovieHtmlData(Movie movie) throws IOException {
        return Jsoup.connect(movie.getMoreInfoLink()).get();
    }

    public static Movie getMovie(Movie movie) throws IOException {
        List<String> genres = new ArrayList<>();

        var currentMovie = getSingleMovieHtmlData(movie);
        var runtime = currentMovie.select("time").text();
        var synopsis = currentMovie.select("div.summary_text").text();

        var aTags = currentMovie.select("div.subtext a");

        for (Element aTag : aTags) {

            if (aTag.attr("href").contains("genres")) {
                var genre = aTag.select("a").text();
                genres.add(genre);
            } else if (aTag.attr("href").contains("releaseinfo")) {
                var releaseDate = aTag.select("a").text();
                movie.setReleaseDate(releaseDate);
            }

        }

        movie.setRuntime(runtime);
        movie.setGenres(genres);
        movie.setSynopsis(synopsis);

        return movie;
    }

}
