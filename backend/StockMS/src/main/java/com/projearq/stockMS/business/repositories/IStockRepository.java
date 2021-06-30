package com.projearq.sistemavendas.negocio.repositorios;

import com.projearq.sistemavendas.negocio.entidades.Estoque;

public interface IStockRepository {

	StockEntity searchStockItem(Long code);

	StockEntity storeProductStock(StockEntity stock);

}
