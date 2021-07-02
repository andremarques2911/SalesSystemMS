package com.projearq.salesMS.adapters.configurations;
import com.projearq.salesMS.application.dtos.ProductDTO;
import com.projearq.salesMS.application.usecases.ConfirmSaleUC;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class Receiver {

    private final ConfirmSaleUC confirmSaleUC;

    @Autowired
    public Receiver(ConfirmSaleUC confirmSaleUC) {
        this.confirmSaleUC = confirmSaleUC;
    }

    public void receive(List<ProductDTO> products) {
        log.info("Received > " + products);
        this.confirmSaleUC.run(products);
    }
}