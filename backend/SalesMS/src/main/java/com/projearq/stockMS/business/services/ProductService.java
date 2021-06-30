package com.projearq.sistemavendas.negocio.servicos;

import com.projearq.sistemavendas.aplicacao.dtos.ProductDTO;
import com.projearq.sistemavendas.negocio.entidades.Estoque;
import com.projearq.sistemavendas.negocio.entidades.Product;
import com.projearq.sistemavendas.negocio.repositorios.IProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductService {

	private IProductsRepository productRepository;
	private StockService stockService;

	@Autowired
	public ServicoDeProduto(IProdutosRepository productRepository, StockService stockService) {
		this.productRepository = productRepository;
		this.stockService = stockService;
	}

	public List<ProductDTO> searchProducts() {
		List<ProductDTO> amountProducts = new ArrayList<>();
		List<Product> products = this.productRepository.searchProducts();
		for (Produto product : products) {
			Estoque stock = this.stockService.searchItemStock(product.getCode());
			amountProducts.add(new ProductDTO(product.getCode(), product.getDescription(), product.getUnitPrice(), stock.getAvaliableQuantity()));
		}
		return amountProducts;
	}

	public Product searchProduct(Long code) {
		return this.productRepository.searchProduct(code);
	}

	public Product addProduct(Product product) {
		return this.productRepository.addProduct(product);
	}

}
