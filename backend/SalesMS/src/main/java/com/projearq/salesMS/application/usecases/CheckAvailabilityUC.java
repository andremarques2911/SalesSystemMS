package com.projearq.salesMS.application.usecases;

import com.projearq.salesMS.business.services.SaleService;
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
