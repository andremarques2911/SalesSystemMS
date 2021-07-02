package com.projearq.stockMS.adapters.configurations.rollbackstockqueue;
import com.projearq.stockMS.application.dtos.RollbackStockDTO;
import com.projearq.stockMS.application.usecases.RollbackStockProductsUC;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class RollbackStockReceiver {

    private final RollbackStockProductsUC rollbackStockProductsUC;

    @Autowired
    public RollbackStockReceiver(RollbackStockProductsUC rollbackStockProductsUC) {
        this.rollbackStockProductsUC = rollbackStockProductsUC;
    }

    public void receive(List<RollbackStockDTO> products) {
        log.info("Received > " + products);
        this.rollbackStockProductsUC.run(products);
    }

}