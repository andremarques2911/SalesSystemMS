package com.projearq.stockMS.application.services.taxcalculation;

import com.projearq.stockMS.application.dtos.ProductDTO;
import com.projearq.stockMS.business.strategy.ITaxCalculationStrategy;

import java.util.List;

public class ArgentinaTaxCalculation implements ITaxCalculationStrategy {

    private final double IVA_TAX_VALUE = 0.1;

    private final double IVA_TAX_PRODUCT_10 = 0.25;

    private final double IVA_TAX_PRODUCT_30 = 0.15;

    @Override
    public Double calculateTaxAmount(List<ProductDTO> items, double subtotal) {
        double tax = 0;

        for (ProductDTO product : items) {

            if (product.getCode().equals(10L)) {
                tax += product.getPrice() * IVA_TAX_PRODUCT_10;
            } else if (product.getCode().equals(30L)) {
                tax += product.getPrice() * IVA_TAX_PRODUCT_30;
            } else {
                tax += product.getPrice() * IVA_TAX_VALUE;
            }
        }

        return tax;
    }

}
