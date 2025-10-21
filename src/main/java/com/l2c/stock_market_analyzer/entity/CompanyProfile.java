package com.l2c.stock_market_analyzer.entity;

import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class CompanyProfile {
    private String name;
    private String symbol;
    private String description;
    private String exchange;
    private String sector;
    private String industry;
    private double marketCapitalization;
    private long ebitda;
    private double peRatio;
    private double pegRatio;
    private double bookValue;
    private double dividendPerShare;
    private double dividendYield;
    private double eps;
    private double revenuePerShareTTM;
    private double profitMargin;
    private double operatingMarginTTM;
    private double returnOnAssetsTTM;
    private double returnOnEquityTTM;
    private double revenueTTM;
    private double grossProfitTTM;
    private double dilutedEPSTTM;
    private double analystTargetPrice;
    private double trailingPE;
    private double forwardPE;
    private double priceToSalesRatioTTM;
    private double priceToBookRatio;
    private double evToRevenue;
    private double evToEBITDA;
    private double beta;
    private double weekHigh52;
    private double weekLow52;
    private double dayMovingAverage50;
    private double dayMovingAverage200;
    private double sharesOutstanding;
    private double sharesFloat;
    private double percentInsiders;
    private double percentInstitutions;
    private String dividendDate;
    private String exDividendDate;

}

