package com.projearq.stockMS.business.repositories;

import com.projearq.stockMS.business.entities.SaleEntity;

import java.util.List;

public interface ISaleRepository {

    List<SaleEntity> findAll();

}
