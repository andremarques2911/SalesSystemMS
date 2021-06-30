package com.projearq.salesMS.application.usecases;

import com.projearq.salesMS.application.dtos.ProductDTO;
import com.projearq.salesMS.application.services.restrictions.RestrictionsFactory;
import com.projearq.salesMS.business.services.SaleService;
import com.projearq.salesMS.business.strategy.IRestrictionsStrategy;
import com.projearq.salesMS.business.strategy.ITaxCalculationStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CalculateBasicCostUC {

    private SaleService service;
    private RestrictionsFactory restrictionsFactory;
    private ITaxCalculationStrategy taxCalculationStrategy;

    @Autowired
    public CalculateBasicCostUC(SaleService service, RestrictionsFactory restrictionsFactory, ITaxCalculationStrategy taxCalculationStrategy) {
        this.service = service;
        this.restrictionsFactory = restrictionsFactory;
        this.taxCalculationStrategy = taxCalculationStrategy;
    }

    public Double[] run(List<ProductDTO> items) {
        IRestrictionsStrategy restrictions = this.restrictionsFactory.restrictions();
        double subtotal = 0;
        double tax = 0;
        subtotal = this.service.calculateSubtotal(items, restrictions, subtotal);
        tax = this.taxCalculationStrategy.calculateTaxAmount(items, subtotal);
        final Double[] resp = new Double[3];
        resp[0] = subtotal;
        resp[1] = tax;
        resp[2] = subtotal + tax;
        this.service.validaRestricoesVenda(items.size(), restrictions, resp[2]);
        return resp;
    }

}
