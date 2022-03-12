package com.texoit.goldenraspberryawards.indicadosvencedores.rest;

import com.texoit.goldenraspberryawards.indicadosvencedores.dto.MinMaxWinnerIntervalsDTO;
import com.texoit.goldenraspberryawards.indicadosvencedores.service.WinnerMixMaxIntervalsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Alfredo Janke on 09/03/2022
 */

@RestController
public class WinnerMinMaxIntervalsRest {

    @Autowired
    private WinnerMixMaxIntervalsService winnerMixMaxIntervalsService;

    @GetMapping("/calculate-winner-min-max-intervals")
    public ResponseEntity<MinMaxWinnerIntervalsDTO> calculateWinnerMinMaxIntervals(){

        MinMaxWinnerIntervalsDTO minMaxWinnerIntervalsDTO = winnerMixMaxIntervalsService.calculateWinnerMinMaxIntervals();

        return ResponseEntity.ok(minMaxWinnerIntervalsDTO);
    }

}
