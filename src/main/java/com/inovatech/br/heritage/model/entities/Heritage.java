package com.inovatech.br.heritage.model.entities;

import com.inovatech.br.heritage.model.enums.HeritageStatus;
import com.inovatech.br.heritage.model.enums.HeritageStatus;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_heritage")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Heritage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String code;

    @Column
    private String description;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column
    private Byte[] image;

    @Column(nullable = false, unique = true)
    private String category;

    @Column
    private BigDecimal heritageValue;

    @Column
    private LocalDate dateOfPurchase;

    @Column
    private String location;

    @Enumerated(EnumType.STRING)
    @Column
    private HeritageStatus status;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User createBy;

    @Column
    private String modifiedBy;

    @Column
    private LocalDateTime lastModified;
}
