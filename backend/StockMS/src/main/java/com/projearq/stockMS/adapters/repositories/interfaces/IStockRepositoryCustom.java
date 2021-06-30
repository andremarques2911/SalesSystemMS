package com.projearq.sistemavendas.adaptadores.repositorios.interfaces;

import com.projearq.sistemavendas.negocio.entidades.Estoque;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStockRepositoryCustom extends CrudRepository<StockEntity, Long> {

    StockEntity findByProduct_code(Long code);

}