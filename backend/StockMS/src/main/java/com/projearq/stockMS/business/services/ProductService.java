package com.projearq.stockMS.business.services;

import com.projearq.stockMS.business.entities.ProductEntity;
import com.projearq.stockMS.business.repositories.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductService {

    private final IProductRepository repository;

    @Autowired
    public ProductService(IProductRepository repository) {
        this.repository = repository;
    }

    public List<ProductEntity> findAllProducts() {
        return this.repository.findAllProducts();
    }

}
