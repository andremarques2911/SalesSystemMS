package com.projearq.stockMS.adapters.repositories.implementations;

import com.projearq.stockMS.adapters.repositories.interfaces.IStockRepositoryCustom;
import com.projearq.stockMS.business.entities.StockEntity;
import com.projearq.stockMS.business.repositories.IStockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StockRepository implements IStockRepository {

	private final IStockRepositoryCustom stockRepositoryCustom;

	@Autowired
	public StockRepository(IStockRepositoryCustom stockRepositoryCustom) {
		this.stockRepositoryCustom = stockRepositoryCustom;
	}

	@Override
	public StockEntity searchStockProduct(Long code) {
		return this.stockRepositoryCustom.findByProduct_code(code);
	}

	@Override
	public StockEntity save(StockEntity stock) {
		return this.stockRepositoryCustom.save(stock);
	}

	@Override
	public StockEntity storeProductStock(StockEntity stock) {
		return this.stockRepositoryCustom.save(stock);
	}

}