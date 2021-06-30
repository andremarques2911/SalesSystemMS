package com.projearq.sistemavendas.adaptadores.repositorios.interfaces;

import com.projearq.sistemavendas.negocio.entidades.Produto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepositoryCustom extends CrudRepository<ProductEntity, Long> {

    List<ProductEntity> findAll();

    ProductEntity findByCode(Long code);

}