package com.l2c.stock_market_analyzer.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.l2c.stock_market_analyzer.entity.CompanyProfile;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;

@Service
public class AlphaVantageImpl {
    private String name;

    private final String API_KEY = "SZJNNO79DHBPDF1T";
    private final String BASE_URL = "https://www.alphavantage.co/query?function=OVERVIEW";
    private final String BASE_URL_QUOTE_ENDPOINT = "https://www.alphavantage.co/query?function=GLOBAL_QUOTE";
    private final RestTemplate restTemplate = new RestTemplate();

    public String getCompletCompanyProfile(String symbol) throws JsonProcessingException {
        String url = BASE_URL + "&symbol=" + symbol + "&apikey=" + API_KEY;
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        JsonNode node = new ObjectMapper().readTree(response.getBody());

        return response.getBody();
    }

    public CompanyProfile getCompanyProfile(String ticker) throws JsonProcessingException {
        String url = BASE_URL + "&symbol=" + ticker + "&apikey=" + API_KEY;
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        JsonNode node = new ObjectMapper().readTree(response.getBody());

        CompanyProfile companyProfile = new CompanyProfile();
        companyProfile.setName(node.path("Name").asText());
        companyProfile.setSymbol(node.path("Symbol").asText());
        companyProfile.setDescription(node.path("Description").asText());
        companyProfile.setExchange(node.path("Exchange").asText());
        companyProfile.setSector(node.path("Sector").asText());
        companyProfile.setIndustry(node.path("Industry").asText());
        companyProfile.setMarketCapitalization(node.path("MarketCapitalization").asDouble());
        companyProfile.setEbitda(node.path("EBITDA").asLong());
        companyProfile.setPeRatio(node.path("PERatio").asDouble());
        companyProfile.setPegRatio(node.path("PEGRatio").asDouble());
        companyProfile.setBookValue(node.path("BookValue").asDouble());
        companyProfile.setDividendPerShare(node.path("DividendPerShare").asDouble());
        companyProfile.setDividendYield(node.path("DividendYield").asDouble());
        companyProfile.setEps(node.path("EPS").asDouble());
        companyProfile.setRevenuePerShareTTM(node.path("RevenuePerShareTTM").asDouble());
        companyProfile.setProfitMargin(node.path("ProfitMargin").asDouble());
        companyProfile.setOperatingMarginTTM(node.path("OperatingMarginTTM").asDouble());
        companyProfile.setReturnOnAssetsTTM(node.path("ReturnOnAssetsTTM").asDouble());
        companyProfile.setReturnOnEquityTTM(node.path("ReturnOnEquityTTM").asDouble());
        companyProfile.setRevenueTTM(node.path("RevenueTTM").asDouble());
        companyProfile.setGrossProfitTTM(node.path("GrossProfitTTM").asDouble());
        companyProfile.setDilutedEPSTTM(node.path("DilutedEPSTTM").asDouble());
        companyProfile.setAnalystTargetPrice(node.path("AnalystTargetPrice").asDouble());
        companyProfile.setTrailingPE(node.path("TrailingPE").asDouble());
        companyProfile.setForwardPE(node.path("ForwardPE").asDouble());
        companyProfile.setPriceToSalesRatioTTM(node.path("PriceToSalesRatioTTM").asDouble());
        companyProfile.setPriceToBookRatio(node.path("PriceToBookRatio").asDouble());
        companyProfile.setEvToRevenue(node.path("EVToRevenue").asDouble());
        companyProfile.setEvToEBITDA(node.path("EVToEBITDA").asDouble());
        companyProfile.setBeta(node.path("Beta").asDouble());
        companyProfile.setWeekHigh52(node.path("52WeekHigh").asDouble());
        companyProfile.setWeekLow52(node.path("52WeekLow").asDouble());
        companyProfile.setDayMovingAverage50(node.path("50DayMovingAverage").asDouble());
        companyProfile.setDayMovingAverage200(node.path("200DayMovingAverage").asDouble());
        companyProfile.setSharesOutstanding(node.path("SharesOutstanding").asDouble());
        companyProfile.setSharesFloat(node.path("SharesFloat").asDouble());
        companyProfile.setPercentInsiders(node.path("PercentInsiders").asDouble());
        companyProfile.setPercentInstitutions(node.path("PercentInstitutions").asDouble());
        companyProfile.setDividendDate(node.path("DividendDate").asText());
        companyProfile.setExDividendDate(node.path("ExDividendDate").asText());

        return companyProfile;
    }


}

