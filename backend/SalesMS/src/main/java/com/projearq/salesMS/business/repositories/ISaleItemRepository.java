package com.projearq.salesMS.business.repositories;

import com.projearq.salesMS.business.entities.SaleItemEntity;

import java.util.List;

public interface ISaleItemRepository {

    void saveAll(List<SaleItemEntity> saleItems);

}
