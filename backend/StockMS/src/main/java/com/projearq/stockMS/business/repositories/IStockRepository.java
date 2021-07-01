package com.projearq.stockMS.business.repositories;

import com.projearq.stockMS.business.entities.StockEntity;

public interface IStockRepository {

	StockEntity searchStockProduct(Long code);

	StockEntity save(StockEntity stock);

	StockEntity storeProductStock(StockEntity stock);

}
