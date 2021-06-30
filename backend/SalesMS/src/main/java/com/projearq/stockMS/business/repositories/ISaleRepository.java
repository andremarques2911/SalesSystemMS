package com.projearq.stockMS.business.repositories;

import com.projearq.stockMS.business.entities.SaleEntity;

import java.util.List;

public interface ISaleRepository {

    void save(SaleEntity sale);

    List<SaleEntity> findAll();

}
