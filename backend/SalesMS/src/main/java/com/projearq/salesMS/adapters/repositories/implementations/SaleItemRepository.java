package com.projearq.salesMS.adapters.repositories.implementations;

import com.projearq.salesMS.adapters.repositories.interfaces.ISaleItemRepositoryCustom;
import com.projearq.salesMS.business.entities.SaleItemEntity;
import com.projearq.salesMS.business.repositories.ISaleItemRepository;
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
