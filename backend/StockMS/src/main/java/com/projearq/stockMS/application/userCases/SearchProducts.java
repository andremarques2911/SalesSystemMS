package com.projearq.sistemavendas.aplicacao.casosDeUso;

import com.projearq.sistemavendas.aplicacao.dtos.ProdutoDTO;
import com.projearq.sistemavendas.negocio.servicos.ServicoDeProduto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SearchProducts {

	private ProductService productService;

	@Autowired
	public SearchProducts(ProductService productService) {
		this.productService = productService;
	}

	public List<ProdutoDTO> run() {
		return this.productService.searchProducts();
	}

}
