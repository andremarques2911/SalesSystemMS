package com.projearq.stockMS.application.usecases;

import com.projearq.stockMS.application.dtos.ProductDTO;
import com.projearq.stockMS.business.entities.ProductEntity;
import com.projearq.stockMS.business.entities.StockEntity;
import com.projearq.stockMS.business.services.ProductService;
import com.projearq.stockMS.business.services.StockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AddProductUC {

    private final ProductService productService;
    private final StockService stockService;

    @Autowired
    public AddProductUC(ProductService productService, StockService stockService) {
        this.productService = productService;
        this.stockService = stockService;
    }

    public StockEntity run(ProductDTO product) {
        log.info("Search stock withing product code > " + product.getCode());
        StockEntity stock = this.stockService.searchStockProduct(product.getCode());
        if (stock == null) {
            log.info("Stock not found for product code");
            ProductEntity productEntity = this.productService.addProduct(ProductEntity.builder()
                    .code(product.getCode())
                    .description(product.getDescription())
                    .unitPrice(product.getPrice())
                    .build());
            log.info("New product created > " + productEntity);
            stock = this.stockService.save(StockEntity.builder()
                    .availableAmmount(product.getAmmount())
                    .product(productEntity)
                    .build());
            log.info("New stock created > " + stock);
        } else {
            log.info("Stock founded");
            stock.setAvailableAmmount(stock.getAvailableAmmount() + product.getAmmount());
            this.stockService.save(stock);
            log.info("Stock updated > " + stock);
        }
        return stock;
    }

}
