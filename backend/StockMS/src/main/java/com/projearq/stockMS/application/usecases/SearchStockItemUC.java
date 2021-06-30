package com.projearq.stockMS.application.usecases;

import com.projearq.stockMS.business.entities.StockEntity;
import com.projearq.stockMS.business.services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SearchStockItemUC {

    private final StockService service;

    @Autowired
    public SearchStockItemUC(StockService service) {
        this.service = service;
    }

    public StockEntity run(Long code) {
        return this.service.searchStockItem(code);
    }

}
