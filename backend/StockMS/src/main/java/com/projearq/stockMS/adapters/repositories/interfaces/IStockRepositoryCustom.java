package com.projearq.stockMS.adapters.repositories.interfaces;

import com.projearq.stockMS.business.entities.StockEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStockRepositoryCustom extends CrudRepository<StockEntity, Long> {

    StockEntity findByProduct_code(Long code);
    
}