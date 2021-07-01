package com.projearq.stockMS.business.services;

import com.projearq.stockMS.application.dtos.ProductDTO;
import com.projearq.stockMS.business.entities.ProductEntity;
import com.projearq.stockMS.business.entities.StockEntity;
import com.projearq.stockMS.business.repositories.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductService {

    private final IProductRepository repository;
    private final StockService stockService;

    @Autowired
    public ProductService(IProductRepository repository, StockService stockService) {
        this.repository = repository;
        this.stockService = stockService;
    }

    public List<ProductDTO> findAllProducts() {
        List<ProductDTO> products = new ArrayList<>();
        this.repository.findAllProducts().stream().forEach(product -> {
            StockEntity stock = this.stockService.searchStockProduct(product.getCode());
            products.add(ProductDTO.builder()
                    .code(product.getCode())
                    .description(product.getDescription())
                    .price(product.getUnitPrice())
                    .ammount(stock.getAvailableAmmount())
                    .build());
        });
        return products;
    }

    public ProductEntity addProduct(ProductEntity product) {
        return this.repository.addProduct(product);
    }

}
