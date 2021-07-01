package com.projearq.stockMS.adapters.configurations.rollbackstockqueue;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RollbackStockReceiver {

    public void receive(String message) {
        log.info("Received > " + message);
    }

}