package com.texoit.goldenraspberryawards.indicadosvencedores.service;

import com.opencsv.CSVReader;
import com.texoit.goldenraspberryawards.indicadosvencedores.model.Movie;
import com.texoit.goldenraspberryawards.indicadosvencedores.repository.MovieRepository;
import java.io.FileReader;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MovieCsvReader {

    @Autowired
    private MovieRepository movieRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void readCsvFile() {
        log.info("Iniciando a leitura do arquivo de filmes");
        try {
            try (CSVReader csvReader = new CSVReader(new FileReader("movielist.csv"))) {
                csvReader.skip(1);
                String[] values;
                while ((values = csvReader.readNext()) != null) {
                    Movie movieDB = parseMovie(values);
                    if (movieDB != null) {
                        movieRepository.save(movieDB);
                    }
                }
            }
            log.info("Finalizada leitura do arquivo de filmes");
        } catch (IOException e) {
            log.error("Erro ao ler o arquivo de filmes", e);
        }
    }

    private Movie parseMovie(String[] movies) {

        try {
            if(movies.length == 0){
                return null;
            }

            String[] movieSplited = StringUtils.join(movies,",")
                .split(";");

            if (movieSplited.length > 0 && movieSplited.length <= 5) {

                return Movie.builder()
                    .year(Integer.parseInt(movieSplited[0]))
                    .title(movieSplited[1])
                    .studios(movieSplited[2])
                    .producers(movieSplited[3])
                    .winner(movieSplited.length > 4 && movieSplited[4].equalsIgnoreCase("yes"))
                    .build();
            }
        } catch (Exception e) {
            log.error("Erro ao realizar o parse do filme {}", movies, e);
        }
        log.error("Erro ao realizar o parse do filme {}", movies);
        return null;
    }
}
