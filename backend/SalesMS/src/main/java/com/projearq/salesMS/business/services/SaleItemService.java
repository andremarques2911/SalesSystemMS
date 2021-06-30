package com.projearq.salesMS.business.services;

import com.projearq.salesMS.business.entities.SaleItemEntity;
import com.projearq.salesMS.business.repositories.ISaleItemRepository;
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
