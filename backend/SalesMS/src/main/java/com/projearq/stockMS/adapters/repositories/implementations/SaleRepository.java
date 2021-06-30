package com.projearq.stockMS.adapters.repositories.implementations;

import com.projearq.stockMS.adapters.repositories.interfaces.ISaleRepositoryCustom;
import com.projearq.stockMS.business.entities.SaleEntity;
import com.projearq.stockMS.business.repositories.ISaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SaleRepository implements ISaleRepository {

    private ISaleRepositoryCustom repository;

    @Autowired
    public SaleRepository(ISaleRepositoryCustom repository) {
        this.repository = repository;
    }

    @Override
    public void save(SaleEntity sale) {
        this.repository.save(sale);
    }

    @Override
    public List<SaleEntity> findAll() {
        return this.repository.findAll();
    }


}
