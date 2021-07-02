package com.projearq.stockMS.application.usecases;

import com.projearq.stockMS.application.dtos.RollbackStockDTO;
import com.projearq.stockMS.business.entities.StockEntity;
import com.projearq.stockMS.business.services.ProductService;
import com.projearq.stockMS.business.services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RollbackStockProductsUC {

    private final StockService stockService;

    @Autowired
    public RollbackStockProductsUC(StockService stockService, ProductService productService) {
        this.stockService = stockService;
    }

    public void run(List<RollbackStockDTO> products) {

        products.stream().forEach(product -> {
            StockEntity stock = this.stockService.searchStockProduct(product.getCode());
            if (stock != null) {
                stock.setAvailableAmmount(stock.getAvailableAmmount() + product.getAmmount());
                this.stockService.save(stock);
            }
        });

    }

}
