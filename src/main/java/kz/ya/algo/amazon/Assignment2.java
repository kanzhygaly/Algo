package kz.ya.algo.amazon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 * @author Yerlan
 */
public class Assignment2 {

    public static void main(String[] args) {
        Movie movie1 = new Movie(1, 1.2f);
        Movie movie2 = new Movie(2, 3.6f);
        Movie movie3 = new Movie(3, 2.4f);
        Movie movie4 = new Movie(4, 4.8f);
        
        movie1.addSimilarMovie(movie2);
        movie1.addSimilarMovie(movie3);
        
        movie2.addSimilarMovie(movie4);
        
        movie3.addSimilarMovie(movie4);
        
//        Set<Movie> recommendations = getMovieRecommendations(movie1, 2);
        Set<Movie> recommendations = getMovieRecommendations2(movie1, 2);
        for (Movie recommendation : recommendations) {
            System.out.print(recommendation.getId() + " ");
        }
        
        System.out.println("");
        
//        recommendations = getMovieRecommendations(movie1, 10);
        recommendations = getMovieRecommendations2(movie1, 10);
        for (Movie recommendation : recommendations) {
            System.out.print(recommendation.getId() + " ");
        }
    }
    
    public static Set<Movie> getMovieRecommendations(Movie movie, int N) {
        Set<Movie> output = new HashSet<>();
        if (N <= 0) {
            return output;
        }

        HashMap<Integer, Movie> movieMap = new HashMap<>();
        fillMap(movie, movieMap);
        movieMap.remove(movie.getId());

        ArrayList<Movie> movies = new ArrayList<>(movieMap.values());
        sort(movies, 0, movies.size() - 1);
        
        // for descending order
        if (N > movies.size()) {
            output.addAll(movies);
        } else {
            output.addAll(movies.subList(0, N));
        }

        // for ascending order
//        ListIterator<Movie> li = movies.listIterator(movies.size());
//        while (N > 0 && li.hasPrevious()) {
//            output.add(li.previous());
//            N--;
//        }

        return output;
    }

    private static void fillMap(Movie movie, HashMap<Integer, Movie> movieMap) {
        movieMap.put(movie.getId(), movie);

        ArrayList<Movie> movies = movie.getSimilarMovies();
        for (int i = 0; i < movies.size(); i++) {
            if (movieMap.get(movies.get(i).getId()) == null) {
                fillMap(movies.get(i), movieMap);
            }
        }
    }

    private static void sort(ArrayList<Movie> list, int from, int to) {
        if (from < to) {
            int pivot = from;
            int left = from + 1;
            int right = to;
            float pivotValue = list.get(pivot).getRating();

            while (left <= right) {
                // descending order
                while (left <= to && pivotValue <= list.get(left).getRating()) {
//                while (left <= to && pivotValue >= list.get(left).getRating()) { ascending order
                    left++;
                }
                // descending order
                while (right > from && pivotValue > list.get(right).getRating()) {
//                while (right > from && pivotValue < list.get(right).getRating()) { ascending order
                    right--;
                }
                if (left < right) {
                    Collections.swap(list, left, right);
                }
            }
            Collections.swap(list, pivot, left - 1);
            sort(list, from, right - 1);
            sort(list, right + 1, to);
        }
    }
    
    public static Set<Movie> getMovieRecommendations2(Movie movie, int N) {
        Set<Movie> output = new HashSet<>();
        if (N <= 0) {
            return output;
        }
        
        TreeMap<Float, Movie> treeMap = new TreeMap<>();
        fillTreeMap(movie, treeMap);
        treeMap.remove(movie.getRating());
        
        Iterator<Movie> iterator = treeMap.descendingMap().values().iterator();
        while (iterator.hasNext() && N > 0) {
            output.add(iterator.next());
            N--;
        }
        
        return output;
    }
    
    private static void fillTreeMap(Movie movie, TreeMap<Float, Movie> movieMap) {
        movieMap.put(movie.getRating(), movie);

        ArrayList<Movie> movies = movie.getSimilarMovies();
        for (int i = 0; i < movies.size(); i++) {
            if (movieMap.get(movies.get(i).getRating()) == null) {
                fillTreeMap(movies.get(i), movieMap);
            }
        }
    }
}

class Movie {

    private final int id;
    private final float rating;
    private final ArrayList<Movie> similarMovies;
    

    public Movie(int id, float rating) {
        this.id = id;
        this.rating = rating;
        similarMovies = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public float getRating() {
        return rating;
    }

    public void addSimilarMovie(Movie movie) {
        similarMovies.add(movie);
    }

    public ArrayList<Movie> getSimilarMovies() {
        return similarMovies;
    }
}
