package com.projearq.stockMS.adapters.configurations.addproductqueue;
import com.projearq.stockMS.application.dtos.ProductDTO;
import com.projearq.stockMS.application.usecases.AddProductUC;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AddProductReceiver {

    private final AddProductUC addProductUC;

    @Autowired
    public AddProductReceiver(AddProductUC addProductUC) {
        this.addProductUC = addProductUC;
    }

    public void receive(ProductDTO product) {
        log.info("Received message > " + product);
        this.addProductUC.run(product);
    }

}