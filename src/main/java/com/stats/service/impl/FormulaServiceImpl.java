package com.stats.service.impl;

import com.stats.service.FormulaService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class FormulaServiceImpl implements FormulaService {
    @Override
    public double calculateNextBet(Map<String,Double> params) {
        double coeff = params.get("coeff");
        double moneyLost = params.get("moneyLost");
        double profit = params.get("profit") + moneyLost;
        double x = coeff - 1;
        return profit / x;
    }
}
