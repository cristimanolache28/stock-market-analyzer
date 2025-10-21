package com.l2c.stock_market_analyzer.controller;

import com.l2c.stock_market_analyzer.entity.CompanyProfile;
import com.l2c.stock_market_analyzer.service.impl.AlphaVantageImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping(value = "/alpha")
public class CompanyController {
    private final AlphaVantageImpl alphaVantageImpl;

    public CompanyController(AlphaVantageImpl alphaVantageImpl) {
        this.alphaVantageImpl = alphaVantageImpl;
    }

    @GetMapping("/company-profile")
    public String getCompletCompanyProfile(@RequestParam String symbol) throws IOException {
        return alphaVantageImpl.getCompletCompanyProfile(symbol);
    }

    @GetMapping("/company-profile/{symbol}")
    public ResponseEntity<CompanyProfile> getCompanyProfile(@PathVariable String symbol) throws IOException {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(alphaVantageImpl.getCompanyProfile(symbol));
    }

}

