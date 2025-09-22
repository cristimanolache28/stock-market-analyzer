package com.l2c.stock_market_analyzer.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "stocks")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ticker", nullable = false)
    private String ticker;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "dividend_yield")
    private double dividendYield;

    @Column(name = "trade_volume", nullable = false)
    private double tradeVolume;

}
