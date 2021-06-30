package com.projearq.stockMS.adapters.repositories.interfaces;

import com.projearq.stockMS.business.entities.SaleItemEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISaleItemRepositoryCustom extends CrudRepository<SaleItemEntity, Long> {

}
