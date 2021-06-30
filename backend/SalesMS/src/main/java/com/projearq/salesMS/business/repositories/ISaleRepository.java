package com.projearq.salesMS.business.repositories;

import com.projearq.salesMS.business.entities.SaleEntity;

import java.util.List;

public interface ISaleRepository {

    void save(SaleEntity sale);

    List<SaleEntity> findAll();

}
