package com.projearq.stockMS.application.usecases;

import com.projearq.stockMS.application.dtos.ProductDTO;
import com.projearq.stockMS.business.entities.ProductEntity;
import com.projearq.stockMS.business.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SearchProductUC {

    private final ProductService productService;

    @Autowired
    public SearchProductUC(ProductService productService) {
        this.productService = productService;
    }

    public ProductDTO run(Long code) {
        ProductEntity product = this.productService.searchProduct(code);
        return ProductDTO.builder()
                .id(product.getId())
                .code(product.getCode())
                .description(product.getDescription())
                .price(product.getUnitPrice())
                .build();
    }

}
