package com.projearq.stockMS.adapters.repositories.interfaces;

import com.projearq.stockMS.business.entities.SaleEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISaleRepositoryCustom extends CrudRepository<SaleEntity, Long> {

    List<SaleEntity> findAll();

}
