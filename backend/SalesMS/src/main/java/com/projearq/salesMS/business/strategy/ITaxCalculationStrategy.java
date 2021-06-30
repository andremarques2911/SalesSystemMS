package com.projearq.salesMS.business.strategy;

import com.projearq.salesMS.application.dtos.ProductDTO;

import java.util.List;

public interface ITaxCalculationStrategy {

    Double calculateTaxAmount(List<ProductDTO> items, double subtotal);

}
