package com.projearq.stockMS.application.usecases;

import com.projearq.stockMS.application.dtos.ProductDTO;
import com.projearq.stockMS.business.entities.ProductEntity;
import com.projearq.stockMS.business.entities.StockEntity;
import com.projearq.stockMS.business.services.ProductService;
import com.projearq.stockMS.business.services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
        StockEntity stock = this.stockService.searchStockProduct(product.getCode());
        if (stock == null) {
            ProductEntity productEntity = this.productService.addProduct(ProductEntity.builder()
                    .code(product.getCode())
                    .description(product.getDescription())
                    .unitPrice(product.getPrice())
                    .build());
            stock = this.stockService.save(StockEntity.builder()
                    .availableAmmount(product.getAmmount())
                    .product(productEntity)
                    .build());
        } else {
            stock.setAvailableAmmount(stock.getAvailableAmmount() + product.getAmmount());
            this.stockService.save(stock);
        }
        return stock;
    }

}
