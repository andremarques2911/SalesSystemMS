package com.projearq.salesMS.business.services;

import com.projearq.salesMS.application.dtos.ProductDTO;
import com.projearq.salesMS.application.dtos.RollbackStockDTO;
import com.projearq.salesMS.application.dtos.StockDTO;
import com.projearq.salesMS.application.utils.JSONUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class StockService {

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public StockService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public StockDTO searchStockItem(Long codProd) {
        log.info("Finding stock for product > " + codProd);
        HttpResponse<String> response = null;
        StockDTO stock = null;
        try {
            response = this.send("http://stockms:8080/stock/"+codProd);
            stock = JSONUtils.covertFromJsonToObject(response.body(), StockDTO.class);
            log.info("Parse  > " + stock);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return stock;
    }

    public ProductDTO searchProduct(Long codProd) {
        log.info("Finding product > " + codProd);
        HttpResponse<String> response = null;
        ProductDTO product = null;
        try {
            response = this.send("http://stockms:8080/stock/product/"+codProd);
            product = JSONUtils.covertFromJsonToObject(response.body(), ProductDTO.class);
            log.info("Parse  > " + product);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return product;
    }

    public void decreaseAmmountItemStock(Long codProd, int ammount) {
        log.info("Updating product > " + codProd);
        try {
            this.send("http://stockms:8080/stock/product/"+codProd);
            log.info("Updated");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void rollbackStock(List<ProductDTO> products) {
        List<RollbackStockDTO> productsRollback = new ArrayList<>();
        products.forEach(p -> productsRollback.add(RollbackStockDTO.builder()
                .code(p.getCode())
                .ammount(p.getAmmount())
                .build()));
        log.info("Sending message > " + productsRollback);
        this.rabbitTemplate.convertAndSend("stock-rollback-exchange", "stockRollback.error", productsRollback);
    }

    private HttpResponse<String> send(String url) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        log.info("Call StockMS");
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        log.info("Response  > " + response);
        return response;
    }

}
