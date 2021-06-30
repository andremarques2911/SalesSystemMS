package com.projearq.salesMS.business.services;

import com.projearq.salesMS.application.dtos.StockDTO;
import com.projearq.salesMS.application.utils.JSONUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
public class StockService {

    public StockDTO searchStockItem(Long codProd){
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://stockms:8080/stocks?code="+codProd))
                .build();
        HttpResponse<String> response = null;
        StockDTO stock = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            stock = JSONUtils.covertFromJsonToObject(response.body(), StockDTO.class);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return stock;
    }

}
