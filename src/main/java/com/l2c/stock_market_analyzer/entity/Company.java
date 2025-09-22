package com.l2c.stock_market_analyzer.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "companies")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "ticker", nullable = false)
    private String ticker;

    @Column(name = "exchange", nullable = false)
    private String exchange;

    @Column(name = "market_cap", nullable = false)
    private int marketCap;

    @Column(name = "number_of_shares", nullable = false)
    private int numberOfSharesOutstanding;

}
