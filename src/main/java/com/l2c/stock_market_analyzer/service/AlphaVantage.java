package com.l2c.stock_market_analyzer.service;


import java.io.IOException;

public interface AlphaVantage {
    String getCompanyProfile(String symbol) throws IOException;
}
