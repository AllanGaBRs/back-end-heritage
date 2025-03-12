package com.inovatech.br.patrimonio.model.entities;

import com.inovatech.br.patrimonio.model.enums.Category;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "tb_heritage")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
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
    private byte[] image;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Category category;

    @Column
    private BigDecimal value;

    @Column
    private LocalDate dateOfPurchase;

    @Column
    private String location;

}
