package com.projearq.stockMS.business.strategy;

import com.projearq.stockMS.application.dtos.ProductDTO;

import java.util.List;

public interface ITaxCalculationStrategy {

    Double calculateTaxAmount(List<ProductDTO> items, double subtotal);

}
