package com.projearq.stockMS.application.usecases;

import com.projearq.stockMS.application.dtos.StockDTO;
import com.projearq.stockMS.business.entities.StockEntity;
import com.projearq.stockMS.business.services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SearchStockProductUC {

    private final StockService service;

    @Autowired
    public SearchStockProductUC(StockService service) {
        this.service = service;
    }

    public StockDTO run(Long code) {
        StockEntity stock = this.service.searchStockProduct(code);
        return StockDTO.builder()
                .codProd(code)
                .availableAmmount(stock.getAvailableAmmount())
                .build();
    }

}
