package com.projearq.stockMS.application.usecases;

import com.projearq.stockMS.application.dtos.ProductDTO;
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

    public List<ProductDTO> run() {
        return this.service.findAllProducts();
    }

}
