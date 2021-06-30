package com.projearq.stockMS.business.repositories;

import com.projearq.stockMS.business.entities.StockEntity;

public interface IStockRepository {

	StockEntity searchStockItem(Long code);

	StockEntity storeProductStock(StockEntity stock);

}
