package com.projearq.stockMS.application.usecases;

import com.projearq.stockMS.business.entities.SaleEntity;
import com.projearq.stockMS.business.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SalesSearchUC {

    private final SaleService saleService;

    @Autowired
    public SalesSearchUC(SaleService saleService) {
        this.saleService = saleService;
    }

    public List<SaleEntity> run() {
        return this.saleService.search();
    }

}
