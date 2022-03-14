package com.texoit.goldenraspberryawards.indicadosvencedores.service;

import com.texoit.goldenraspberryawards.indicadosvencedores.dto.MinMaxWinnerInterval;
import com.texoit.goldenraspberryawards.indicadosvencedores.dto.MinMaxWinnerIntervalsDTO;
import com.texoit.goldenraspberryawards.indicadosvencedores.model.Movie;
import com.texoit.goldenraspberryawards.indicadosvencedores.repository.MovieRepository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WinnerMixMaxIntervalsService {

    @Autowired
    private MovieRepository movieRepository;

    public MinMaxWinnerIntervalsDTO calculateWinnerMinMaxIntervals() {

        List<Movie> winners = movieRepository.findByWinnerTrueOrderByProducersAscYearAsc();

        Map<String, List<Movie>> moviesByProducers = createMapWinnerMoviesByProducers(winners);

        return calculateIntervals(moviesByProducers);
    }

    private MinMaxWinnerIntervalsDTO calculateIntervals(Map<String, List<Movie>> moviesByProducers) {

        List<MinMaxWinnerInterval> min = new ArrayList<>();
        List<MinMaxWinnerInterval> max = new ArrayList<>();

        moviesByProducers.keySet()
            .forEach(key -> {
                List<Movie> movies = moviesByProducers.get(key);

                if (movies.size() < 2) {
                    return;
                }

                calculateIntervals(min, max, key, movies);

            });

        return MinMaxWinnerIntervalsDTO.builder()
            .min(min)
            .max(max)
            .build();
    }

    private void calculateIntervals(List<MinMaxWinnerInterval> min, List<MinMaxWinnerInterval> max, String producer,
        List<Movie> movies) {

        int minInterval = Integer.MAX_VALUE;
        int maxInterval = Integer.MIN_VALUE;

        MinMaxWinnerInterval minAward = null;
        MinMaxWinnerInterval maxAward = null;

        int lastYear = 0;

        for (Movie movie : movies) {
            if (lastYear == 0) {
                lastYear = movie.getYear();
                continue;
            }

            if (movie.getYear() - lastYear < minInterval) {
                minInterval = Math.abs(movie.getYear() - lastYear);
                minAward = MinMaxWinnerInterval.builder()
                    .producer(producer)
                    .interval(Math.abs(movie.getYear() - lastYear))
                    .previousWin(lastYear)
                    .followingWin(movie.getYear())
                    .build();
            } else

            if (movie.getYear() - lastYear > maxInterval) {
                maxInterval = Math.abs(movie.getYear() - lastYear);
                maxAward = MinMaxWinnerInterval.builder()
                    .producer(producer)
                    .interval(Math.abs(movie.getYear() - lastYear))
                    .previousWin(lastYear)
                    .followingWin(movie.getYear())
                    .build();
            }

            lastYear = movie.getYear();
        }

        if (minAward != null) {
            min.add(minAward);
        }

        if (maxAward != null) {
            max.add(maxAward);
        }
    }

    private Map<String, List<Movie>> createMapWinnerMoviesByProducers(List<Movie> winners) {

        Map<String, List<Movie>> moviesByProducers = new HashMap<>();
        winners.forEach(winner -> {

            String[] producers = winner.getProducers()
                .split(", |and");

            for (String producer : producers) {

                String producerTrimmed = producer.trim();

                if (StringUtils.isNotBlank(producerTrimmed)) {

                    moviesByProducers.computeIfAbsent(producerTrimmed, k -> new ArrayList<>());

                    List<Movie> movies = moviesByProducers.get(producerTrimmed);
                    movies.add(winner);
                }
            }
        });
        return moviesByProducers;
    }

}
