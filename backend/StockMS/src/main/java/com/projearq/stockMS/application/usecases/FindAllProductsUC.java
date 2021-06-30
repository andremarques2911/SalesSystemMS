package com.projearq.stockMS.application.usecases;

import com.projearq.stockMS.business.entities.ProductEntity;
import com.projearq.stockMS.business.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FindAllProductsUC {

    private final ProductService service;

    @Autowired
    public FindAllProductsUC(ProductService service) {
        this.service = service;
    }

    public List<ProductEntity> run() {
        return this.service.findAllProducts();
    }

}
