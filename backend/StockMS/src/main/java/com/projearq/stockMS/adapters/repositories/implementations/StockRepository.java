package com.projearq.sistemavendas.adaptadores.repositorios;

import com.projearq.sistemavendas.adaptadores.repositorios.interfaces.IEstoqueRepositoryCustom;
import com.projearq.sistemavendas.negocio.entidades.Estoque;
import com.projearq.sistemavendas.negocio.repositorios.IEstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StockRepository implements IStockRepository {

	private IStockRepositoryCustom stockRepositoryCustom;

	@Autowired
	public StockRepository(IStockRepositoryCustom stockRepositoryCustom) {
		this.stockRepositoryCustom = stockRepositoryCustom;
	}

	@Override
	public StockEntity searchStockItem(Long code) {
		return this.stockRepositoryCustom.findByProduct_code(code);
	}

	@Override
	public StockEntity storeProductStock(StockEntity stock) {
		return this.stockRepositoryCustom.save(stock);
	}
}