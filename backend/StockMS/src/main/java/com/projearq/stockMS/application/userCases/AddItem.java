package com.projearq.sistemavendas.aplicacao.casosDeUso;

import com.projearq.stockMS.business.entidades.Product;
import com.projearq.stockMS.business.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddItem {

    ProductService productService;

    @Autowired
    public AddProductUC(ProductService productService) {
        this.productService = ProductService;
    }

    public Product run(Product Product) {
        return this.productService.addProduct(Product);
    }
}
