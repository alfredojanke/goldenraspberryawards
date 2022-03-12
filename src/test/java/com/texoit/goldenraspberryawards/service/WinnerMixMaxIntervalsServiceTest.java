package com.texoit.goldenraspberryawards.service;

import com.texoit.goldenraspberryawards.indicadosvencedores.dto.MinMaxWinnerInterval;
import com.texoit.goldenraspberryawards.indicadosvencedores.dto.MinMaxWinnerIntervalsDTO;
import com.texoit.goldenraspberryawards.indicadosvencedores.model.Movie;
import com.texoit.goldenraspberryawards.indicadosvencedores.repository.MovieRepository;
import com.texoit.goldenraspberryawards.indicadosvencedores.service.WinnerMixMaxIntervalsService;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

class WinnerMixMaxIntervalsServiceTest {

    @Mock
    private MovieRepository movieRepository;

    @InjectMocks
    private WinnerMixMaxIntervalsService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void calculateWinnerMinMaxIntervals(){

        List<Movie> movies = new ArrayList<>();

        movies.add(Movie.builder().year(1980).title("title 1980").producers("Producer A").studios("Studio A").winner(true).build());
        movies.add(Movie.builder().year(1981).title("title 1981").producers("Producer A").studios("Studio A").winner(true).build());
        movies.add(Movie.builder().year(1990).title("title 1990").producers("Producer A").studios("Studio A").winner(true).build());


        movies.add(Movie.builder().year(1990).title("title 1990").producers("Producer B").studios("Studio B").winner(true).build());
        movies.add(Movie.builder().year(1995).title("title 1995").producers("Producer B").studios("Studio B").winner(true).build());
        movies.add(Movie.builder().year(2000).title("title 2000").producers("Producer B").studios("Studio B").winner(true).build());
        movies.add(Movie.builder().year(2010).title("title 2010").producers("Producer B").studios("Studio B").winner(true).build());


        Mockito.when(movieRepository.findByWinnerTrueOrderByProducersAscYearAsc()).thenReturn(movies);

        MinMaxWinnerIntervalsDTO minMaxWinnerIntervalsDTO = service.calculateWinnerMinMaxIntervals();

        MinMaxWinnerInterval minMaxWinnerInterval = minMaxWinnerIntervalsDTO.getMin()
            .get(0);
        assertEquals("Producer A", minMaxWinnerInterval.getProducer());
        assertEquals(1,minMaxWinnerInterval.getInterval());
        assertEquals(1980,minMaxWinnerInterval.getPreviousWin());
        assertEquals(1981, minMaxWinnerInterval.getFollowingWin());


        minMaxWinnerInterval = minMaxWinnerIntervalsDTO.getMin()
            .get(1);
        assertEquals(5,minMaxWinnerInterval.getInterval());

        assertEquals("Producer B", minMaxWinnerInterval.getProducer());
        assertEquals(5,minMaxWinnerInterval.getInterval());
        assertEquals(1990,minMaxWinnerInterval.getPreviousWin());
        assertEquals(1995, minMaxWinnerInterval.getFollowingWin());


        minMaxWinnerInterval = minMaxWinnerIntervalsDTO.getMax()
            .get(0);
        assertEquals("Producer A", minMaxWinnerInterval.getProducer());
        assertEquals(9,minMaxWinnerInterval.getInterval());
        assertEquals(1981,minMaxWinnerInterval.getPreviousWin());
        assertEquals(1990, minMaxWinnerInterval.getFollowingWin());

        minMaxWinnerInterval = minMaxWinnerIntervalsDTO.getMax()
            .get(1);
        assertEquals("Producer B", minMaxWinnerInterval.getProducer());
        assertEquals(10,minMaxWinnerInterval.getInterval());
        assertEquals(2000,minMaxWinnerInterval.getPreviousWin());
        assertEquals(2010, minMaxWinnerInterval.getFollowingWin());




    }
}
