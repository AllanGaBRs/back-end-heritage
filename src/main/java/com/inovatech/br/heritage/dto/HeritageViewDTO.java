package com.inovatech.br.heritage.dto;

import com.inovatech.br.heritage.model.enums.HeritageStatus;

public record HeritageViewDTO(

        String name,
        String code,
        String description,
        String category,
        HeritageStatus status

) {
}
