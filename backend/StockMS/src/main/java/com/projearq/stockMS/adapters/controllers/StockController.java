package com.projearq.stockMS.adapters.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.projearq.stockMS.application.dtos.ProductDTO;
import com.projearq.stockMS.application.usecases.AddProductUC;
import com.projearq.stockMS.application.usecases.FindAllProductsUC;
import com.projearq.stockMS.application.usecases.SearchStockProductUC;
import com.projearq.stockMS.application.utils.JSONUtils;
import com.projearq.stockMS.business.entities.ProductEntity;
import com.projearq.stockMS.business.entities.StockEntity;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("stock")
public class StockController {

    private final SearchStockProductUC searchStockProductUC;
    private final FindAllProductsUC findAllProductsUC;
    private final AddProductUC addProductUC;
    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public StockController(SearchStockProductUC searchStockProductUC, FindAllProductsUC findAllProductsUC, AddProductUC addProductUC, RabbitTemplate rabbitTemplate) {
        this.searchStockProductUC = searchStockProductUC;
        this.findAllProductsUC = findAllProductsUC;
        this.addProductUC = addProductUC;
        this.rabbitTemplate = rabbitTemplate;
    }

    @GetMapping
    @CrossOrigin(origins = "*")
    public List<ProductEntity> getProdutcs() {
        return this.findAllProductsUC.run();
    }

    @GetMapping("/{code}")
    @CrossOrigin(origins = "*")
    public StockEntity searchStockItem(@PathVariable("code") Long code) {
        return this.searchStockProductUC.run(code);
    }

    @PostMapping
    @CrossOrigin(origins = "*")
    public void addProduct(ProductDTO productDTO) {
        try {
            rabbitTemplate.convertAndSend("stock-exchange", "stock.add", JSONUtils.covertFromObjectToJson(productDTO));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/teste")
    @CrossOrigin(origins = "*")
    public void novaCotacao(@RequestParam final String de, @RequestParam final String para, @RequestParam final double valor) {
        String msg = de+","+para+","+valor;
        rabbitTemplate.convertAndSend("stock-exchange", "stock.add", msg);
    }

}
