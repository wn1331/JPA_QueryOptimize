package com.example.bigdatas.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BigDatas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private BigDataParents bigDataParents;

    private Integer column1;
    private Integer column2;
    private Integer column3;
    private Integer column4;
    private Character column5;
    private String column6;
    private Double column7;
    private Double column8;
    private Double column9;
    private Double column10;
    private Double column11;
    private Double column12;

    public BigDatas(BigDataParents bigDataParents, Integer column1, Integer column2, Integer column3, Integer column4, Character column5, String column6, Double column7, Double column8, Double column9, Double column10, Double column11, Double column12) {
        this.bigDataParents = bigDataParents;
        this.column1 = column1;
        this.column2 = column2;
        this.column3 = column3;
        this.column4 = column4;
        this.column5 = column5;
        this.column6 = column6;
        this.column7 = column7;
        this.column8 = column8;
        this.column9 = column9;
        this.column10 = column10;
        this.column11 = column11;
        this.column12 = column12;
    }
}
