package com.projearq.stockMS.adapters.controllers;

import com.projearq.stockMS.application.dtos.ProductDTO;
import com.projearq.stockMS.application.dtos.RollbackStockDTO;
import com.projearq.stockMS.application.dtos.StockDTO;
import com.projearq.stockMS.application.usecases.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("stock")
public class StockController {

    private final SearchStockProductUC searchStockProductUC;
    private final FindAllProductsUC findAllProductsUC;
    private final SearchProductUC searchProductUC;
    private final DecreaseAmmountItemStockUC decreaseAmmountItemStockUC;
    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public StockController(SearchStockProductUC searchStockProductUC, FindAllProductsUC findAllProductsUC, SearchProductUC searchProductUC, DecreaseAmmountItemStockUC decreaseAmmountItemStockUC, RabbitTemplate rabbitTemplate) {
        this.searchStockProductUC = searchStockProductUC;
        this.findAllProductsUC = findAllProductsUC;
        this.searchProductUC = searchProductUC;
        this.decreaseAmmountItemStockUC = decreaseAmmountItemStockUC;
        this.rabbitTemplate = rabbitTemplate;
    }

    @GetMapping("/products")
//    @CrossOrigin(origins = "*")
    public List<ProductDTO> getProdutcs() {
        return this.findAllProductsUC.run();
    }

    @GetMapping("/product/{code}")
    @CrossOrigin(origins = "*")
    public ProductDTO searchProduct(@PathVariable("code") Long code) {
        return this.searchProductUC.run(code);
    }

    @GetMapping("/{code}")
    @CrossOrigin(origins = "*")
    public StockDTO searchStockproduct(@PathVariable("code") Long code) {
        return this.searchStockProductUC.run(code);
    }

    @PostMapping
    @CrossOrigin(origins = "*")
    public void addProduct(@RequestBody ProductDTO product) {
        log.info("Sending message > " + product);
        this.rabbitTemplate.convertAndSend("stock-exchange", "stock.add", product);
    }

    @PutMapping
    @CrossOrigin(origins = "*")
    public void decreaseAmmountItemStock(@RequestParam Long code, @RequestParam int ammount) {
        this.decreaseAmmountItemStockUC.run(code, ammount);
    }

    @PostMapping("/teste")
    @CrossOrigin(origins = "*")
    public void rollbackStock(@RequestBody List<RollbackStockDTO> products) {
        log.info("Sending message > " + products);
        this.rabbitTemplate.convertAndSend("stock-rollback-exchange", "stockRollback.error", products);
    }

}
