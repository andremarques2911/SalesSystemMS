package com.projearq.stockMS.business.services;

import com.projearq.stockMS.business.entities.SaleItemEntity;
import com.projearq.stockMS.business.repositories.ISaleItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SaleItemService {

    private ISaleItemRepository repository;

    @Autowired
    public SaleItemService(ISaleItemRepository repository) {
        this.repository = repository;
    }

    public void saveAll(List<SaleItemEntity> saleItems) {
        this.repository.saveAll(saleItems);
    }

}
