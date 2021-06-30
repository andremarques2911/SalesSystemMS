package com.projearq.stockMS.application.usecases;

import com.projearq.stockMS.business.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CheckAvailabilityUC {

    private SaleService service;

    @Autowired
    public CheckAvailabilityUC(SaleService service) {
        this.service = service;
    }

    public boolean run(Long codProd, Integer ammount) {
        return this.service.checkAvailability(codProd, ammount);
    }

}
