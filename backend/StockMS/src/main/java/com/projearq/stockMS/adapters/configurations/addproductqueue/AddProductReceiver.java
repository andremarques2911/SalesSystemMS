package com.projearq.stockMS.adapters.configurations.addproductqueue;
import com.projearq.stockMS.application.dtos.ProductDTO;
import com.projearq.stockMS.application.usecases.AddProductUC;
import com.projearq.stockMS.application.utils.JSONUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
public class AddProductReceiver {

    private final AddProductUC addProductUC;

    @Autowired
    public AddProductReceiver(AddProductUC addProductUC) {
        this.addProductUC = addProductUC;
    }

    public void receive(String productSerialized) {
        log.info("Received message > " + productSerialized);
        try {
            ProductDTO product = JSONUtils.covertFromJsonToObject(productSerialized, ProductDTO.class);
            log.info("Parse complete > " + product);
            this.addProductUC.run(product);
        } catch (IOException ex) {
            log.error(ex.getMessage());
        }
    }

}