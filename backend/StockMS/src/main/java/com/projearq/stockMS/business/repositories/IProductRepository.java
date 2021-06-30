package com.projearq.stockMS.business.repositories;

import com.projearq.stockMS.business.entities.ProductEntity;

import java.util.List;

public interface IProductRepository {

	List<ProductEntity> findAllProducts();

	ProductEntity searchProduct(Long code);

	ProductEntity addProduct(ProductEntity product);

}