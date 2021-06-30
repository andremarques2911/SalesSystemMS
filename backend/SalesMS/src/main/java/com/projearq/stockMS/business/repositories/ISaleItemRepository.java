package com.projearq.stockMS.business.repositories;

import com.projearq.stockMS.business.entities.SaleItemEntity;

import java.util.List;

public interface ISaleItemRepository {

    void saveAll(List<SaleItemEntity> saleItems);

}
