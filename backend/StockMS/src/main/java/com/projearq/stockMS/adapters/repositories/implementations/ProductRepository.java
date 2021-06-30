package com.projearq.sistemavendas.adaptadores.repositorios;

import com.projearq.sistemavendas.adaptadores.repositorios.interfaces.IproductRepositoryCustom;
import com.projearq.sistemavendas.negocio.entidades.Produto;
import com.projearq.sistemavendas.negocio.repositorios.IProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductRepository implements IProductRepository {

	private IProductRepositoryCustom productRepositoryCustom;

	@Autowired
	public ProductRepository(IProductRepositoryCustom productRepositoryCustom) {
		this.productRepositoryCustom = productRepositoryCustom;
	}

	@Override
	public List<ProductEntity> getProdutcs() {
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