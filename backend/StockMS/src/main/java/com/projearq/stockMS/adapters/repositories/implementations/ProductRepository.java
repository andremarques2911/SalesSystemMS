package com.projearq.stockMS.adapters.repositories.implementations;

import com.projearq.stockMS.adapters.repositories.interfaces.IProductRepositoryCustom;
import com.projearq.stockMS.business.entities.ProductEntity;
import com.projearq.stockMS.business.repositories.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductRepository implements IProductRepository {

	private final IProductRepositoryCustom productRepositoryCustom;

	@Autowired
	public ProductRepository(IProductRepositoryCustom productRepositoryCustom) {
		this.productRepositoryCustom = productRepositoryCustom;
	}

	@Override
	public List<ProductEntity> findAllProducts() {
		return this.productRepositoryCustom.findAll();
	}

	@Override
	public ProductEntity searchProduct(Long code) {
		return this.productRepositoryCustom.findByCode(code);
	}

	@Override
	public ProductEntity addProduct(ProductEntity product) {
		return this.productRepositoryCustom.save(product);
	}

}