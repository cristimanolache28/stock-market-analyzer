package com.l2c.stock_market_analyzer.controller;

import com.l2c.stock_market_analyzer.entity.CompanyProfile;
import com.l2c.stock_market_analyzer.service.impl.AlphaVantageImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping(value = "/api/v1")
public class CompanyController {
    private final AlphaVantageImpl alphaVantageImpl;

    public CompanyController(AlphaVantageImpl alphaVantageImpl) {
        this.alphaVantageImpl = alphaVantageImpl;
    }

    @GetMapping("/standard-company-profile/{symbol}")
    public String getCompleteCompanyProfile(@PathVariable String symbol) throws IOException {
        return alphaVantageImpl.getCompleteCompanyProfile(symbol);
    }

    @GetMapping("/custom-company-profile/{symbol}")
    public ResponseEntity<CompanyProfile> getCompanyProfile(@PathVariable String symbol) throws IOException {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(alphaVantageImpl.getCompanyProfile(symbol));
    }

}

