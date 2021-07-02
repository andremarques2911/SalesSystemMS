package com.projearq.stockMS.application.usecases;

import com.projearq.stockMS.business.services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DecreaseAmmountItemStockUC {

    private final StockService stockService;

    @Autowired
    public DecreaseAmmountItemStockUC(StockService stockService) {
        this.stockService = stockService;
    }

    public void run(Long code, int ammount) {
        this.stockService.decreaseAmmountItemStock(code, ammount);
    }

}
