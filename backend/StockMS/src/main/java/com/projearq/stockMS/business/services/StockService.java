package com.projearq.stockMS.business.services;

import com.projearq.stockMS.business.entities.StockEntity;
import com.projearq.stockMS.business.repositories.IStockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StockService {

    private final IStockRepository repository;

    @Autowired
    public StockService(IStockRepository repository) {
        this.repository = repository;
    }

    public StockEntity searchStockProduct(Long code) {
        return this.repository.searchStockProduct(code);
    }

    public StockEntity save(StockEntity stock) {
        return this.repository.save(stock);
    }

    public void decreaseAmmountItemStock(Long code, int ammount) {
        StockEntity stock = this.searchStockProduct(code);
        stock.setAvailableAmmount(stock.getAvailableAmmount() - ammount);
        this.save(stock);
    }

}
