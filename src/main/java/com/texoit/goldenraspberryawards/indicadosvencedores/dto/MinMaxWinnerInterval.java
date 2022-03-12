package com.texoit.goldenraspberryawards.indicadosvencedores.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MinMaxWinnerInterval {
    private String producer;
    private Integer interval;
    private Integer previousWin;
    private Integer followingWin;
}
