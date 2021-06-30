package com.projearq.stockMS.application.services.taxcalculation;

import com.projearq.stockMS.application.dtos.ProductDTO;
import com.projearq.stockMS.business.strategy.ITaxCalculationStrategy;

import java.util.List;

public class BrazilTaxCalculation implements ITaxCalculationStrategy {

    private final double IVA_TAX_VALUE = 0.12;

    private final double LIMIT_VALUE_PURCHASE_TAX_IVA = 8000;

    private final double TAX_IVA_VALUE_WITH_EXCEEDING_LIMIT = 0.2;

    @Override
    public Double calculateTaxAmount(List<ProductDTO> items, double subtotal) {
        double tax;

        if (subtotal <= LIMIT_VALUE_PURCHASE_TAX_IVA) {
            tax = subtotal * IVA_TAX_VALUE;
        } else {
            tax = subtotal * TAX_IVA_VALUE_WITH_EXCEEDING_LIMIT;
        }

        return tax;
    }

}
