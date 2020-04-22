package io.tguduru.ds.lab.problems;

import java.util.Arrays;

/**
 * You are on a flight and wanna watch two movies during this flight.
 * You are given int[] movie_duration which includes all the movie durations.
 * You are also given the duration of the flight which is d in minutes.
 * Now, you need to pick two movies and the total duration of the two movies is less than or equal to (d - 30min).
 * Find the pair of movies with the longest total duration. If multiple found, return the pair with the longest movie.
 *
 * e.g.
 *  Input
 *  movie_duration: [90, 85, 75, 60, 120, 150, 125]
 *
 * d: 250
 *
 * Output : [90, 125]
 * 90min + 125min = 215 is the maximum number within 220 (250min - 30min)
 *
 * @author Guduru, Thirupathi Reddy
 * @modified: 2019-08-13
 */
public class MovieTimeProblem {
    public static void main(String[] args) {
        int[] moviesDurations = {90, 85, 75, 60, 120, 150, 145, 125};
        Arrays.sort(moviesDurations);
        int flightDuration = 250 - 30;
        Tuple tuple = new Tuple();
        for (int i = 0, j = moviesDurations.length - 1; i < moviesDurations.length; ) {
            if (moviesDurations[i] + moviesDurations[j] <= flightDuration) {
                if (tuple.total <= moviesDurations[i] + moviesDurations[j]) {
                    tuple.setMovie1(moviesDurations[i]);
                    tuple.setMovie2(moviesDurations[j]);
                    tuple.setTotal(moviesDurations[i] + moviesDurations[j]);
                }
                i++;
            } else {
                j--;
            }
        }
        System.out.println(tuple);
    }

    static class Tuple {
        int movie1, movie2, total;

        public void setMovie1(int movie1) {
            this.movie1 = movie1;
        }

        public void setMovie2(int movie2) {
            this.movie2 = movie2;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        @Override
        public String toString() {
            return "Tuple{" +
                    "movie1=" + movie1 +
                    ", movie2=" + movie2 +
                    ", total=" + total +
                    '}';
        }
    }
}
