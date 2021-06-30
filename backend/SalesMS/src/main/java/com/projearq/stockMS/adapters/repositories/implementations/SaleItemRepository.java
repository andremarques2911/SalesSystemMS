package com.projearq.stockMS.adapters.repositories.implementations;

import com.projearq.stockMS.adapters.repositories.interfaces.ISaleItemRepositoryCustom;
import com.projearq.stockMS.business.entities.SaleItemEntity;
import com.projearq.stockMS.business.repositories.ISaleItemRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SaleItemRepository implements ISaleItemRepository {

    private final ISaleItemRepositoryCustom repository;

    public SaleItemRepository(ISaleItemRepositoryCustom repository) {
        this.repository = repository;
    }

    @Override
    public void saveAll(List<SaleItemEntity> saleItems) {
        this.repository.saveAll(saleItems);
    }
}
