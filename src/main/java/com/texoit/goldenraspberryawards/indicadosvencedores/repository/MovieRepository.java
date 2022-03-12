package com.texoit.goldenraspberryawards.indicadosvencedores.repository;

import com.texoit.goldenraspberryawards.indicadosvencedores.model.Movie;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Alfredo Janke on 10/03/2022
 */

@Repository
public interface MovieRepository extends JpaRepository<Movie, UUID> {

    List<Movie> findByWinnerTrueOrderByProducersAscYearAsc();
}
