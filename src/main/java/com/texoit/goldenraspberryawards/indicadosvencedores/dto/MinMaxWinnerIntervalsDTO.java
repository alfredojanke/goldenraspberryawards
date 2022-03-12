package com.texoit.goldenraspberryawards.indicadosvencedores.dto;

import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MinMaxWinnerIntervalsDTO {

    private List<MinMaxWinnerInterval> min;
    private List<MinMaxWinnerInterval> max;
}
