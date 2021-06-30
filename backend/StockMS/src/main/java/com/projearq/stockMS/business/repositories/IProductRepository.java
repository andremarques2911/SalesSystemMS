package com.projearq.sistemavendas.negocio.repositorios;

import com.projearq.sistemavendas.negocio.entidades.Produto;

import java.util.List;

public interface IProductRepository {

	List<ProductEntity> getProdutcs();

	ProductEntity searchProduct(Long code);

	ProductEntity addProduct(ProductEntity product);

}