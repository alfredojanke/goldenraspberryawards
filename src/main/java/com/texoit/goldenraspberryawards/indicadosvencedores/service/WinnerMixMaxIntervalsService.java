package com.texoit.goldenraspberryawards.indicadosvencedores.service;

import com.texoit.goldenraspberryawards.indicadosvencedores.dto.MinMaxWinnerInterval;
import com.texoit.goldenraspberryawards.indicadosvencedores.dto.MinMaxWinnerIntervalsDTO;
import com.texoit.goldenraspberryawards.indicadosvencedores.model.Movie;
import com.texoit.goldenraspberryawards.indicadosvencedores.repository.MovieRepository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Alfredo Janke on 09/03/2022
 */

@Service
public class WinnerMixMaxIntervalsService {

    @Autowired
    private MovieRepository movieRepository;

    public MinMaxWinnerIntervalsDTO calculateWinnerMinMaxIntervals() {

        List<MinMaxWinnerInterval> min = new ArrayList<>();
        List<MinMaxWinnerInterval> max = new ArrayList<>();

        List<Movie> winners = movieRepository.findByWinnerTrueOrderByProducersAscYearAsc();

        Map<String, List<Movie>> moviesByProducers = createMapWinnerMoviesByProducers(winners);

        return calculateIntervals(min, max, moviesByProducers);
    }

    private MinMaxWinnerIntervalsDTO calculateIntervals(List<MinMaxWinnerInterval> min, List<MinMaxWinnerInterval> max,
        Map<String, List<Movie>> moviesByProducers) {

        moviesByProducers.keySet()
            .forEach(key -> {
                List<Movie> movies = moviesByProducers.get(key);

                if (movies.size() < 2) {
                    return;
                }
                calculateMinIntervals(min, key, movies);

                calculateMaxIntervals(max, key, movies);
            });

        return MinMaxWinnerIntervalsDTO.builder()
            .min(min)
            .max(max)
            .build();
    }

    private void calculateMaxIntervals(List<MinMaxWinnerInterval> max, String key, List<Movie> movies) {
        int maxInterval = Integer.MIN_VALUE;
        int maxLastYear = 0;
        int maxPreviousWin = 0;
        int maxFollowingWin = 0;

        for (Movie movie : movies) {

            if (maxLastYear != 0 && movie.getYear() - maxLastYear > maxInterval) {
                maxInterval = movie.getYear() - maxLastYear;
                maxPreviousWin = maxLastYear;
                maxFollowingWin = movie.getYear();
                maxLastYear = movie.getYear();
                continue;
            }
            maxLastYear = movie.getYear();
        }

        MinMaxWinnerInterval maxAward = MinMaxWinnerInterval.builder()
            .interval(maxInterval)
            .previousWin(maxPreviousWin)
            .followingWin(maxFollowingWin)
            .producer(key)
            .build();

        max.add(maxAward);
    }

    private void calculateMinIntervals(List<MinMaxWinnerInterval> min, String key, List<Movie> movies) {
        int minInterval = Integer.MAX_VALUE;
        int minLastYear = 0;
        int minPreviousWin = 0;
        int minFollowingWin = 0;

        for (Movie movie : movies) {
            if (minLastYear != 0 && movie.getYear() - minLastYear < minInterval) {
                minInterval = movie.getYear() - minLastYear;
                minPreviousWin = minLastYear;
                minFollowingWin = movie.getYear();
                minLastYear = movie.getYear();
                continue;
            }
            minLastYear = movie.getYear();
        }

        MinMaxWinnerInterval minAward = MinMaxWinnerInterval.builder()
            .interval(minInterval)
            .previousWin(minPreviousWin)
            .followingWin(minFollowingWin)
            .producer(key)
            .build();

        min.add(minAward);
    }

    private Map<String, List<Movie>> createMapWinnerMoviesByProducers(List<Movie> winners) {

        Map<String, List<Movie>> moviesByProducers = new HashMap<>();
        winners.forEach(winner -> {
            moviesByProducers.computeIfAbsent(winner.getProducers(), k -> new ArrayList<>());

            List<Movie> movies = moviesByProducers.get(winner.getProducers());
            movies.add(winner);
        });
        return moviesByProducers;
    }

}
