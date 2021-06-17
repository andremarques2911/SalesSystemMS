package com.projearq.stockMS.adapters.repositories.implementations;

import com.projearq.stockMS.adapters.repositories.interfaces.ISaleRepositoryCustom;
import com.projearq.stockMS.business.entities.SaleEntity;
import com.projearq.stockMS.business.repositories.ISaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SaleRepository implements ISaleRepository {

    private final ISaleRepositoryCustom saleRepositoryCustom;

    @Autowired
    public SaleRepository(ISaleRepositoryCustom saleRepositoryCustom) {
        this.saleRepositoryCustom = saleRepositoryCustom;
    }

    @Override
    public List<SaleEntity> findAll() {
        return this.saleRepositoryCustom.findAll();
    }

}
