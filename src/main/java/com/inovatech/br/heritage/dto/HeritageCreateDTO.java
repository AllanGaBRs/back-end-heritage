package com.inovatech.br.heritage.dto;

import com.inovatech.br.heritage.model.enums.HeritageStatus;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record HeritageCreateDTO(

    String name,
    String code,
    String description,
    Byte[] image,
    String category,
    BigDecimal heritageValue,
    LocalDate dateOfPurchase,
    String location,
    HeritageStatus status

){}
