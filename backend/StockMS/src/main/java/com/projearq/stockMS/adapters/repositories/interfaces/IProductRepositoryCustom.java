package com.projearq.stockMS.adapters.repositories.interfaces;

import com.projearq.stockMS.business.entities.ProductEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepositoryCustom extends CrudRepository<ProductEntity, Long> {

    List<ProductEntity> findAll();

    ProductEntity findByCode(Long code);

}