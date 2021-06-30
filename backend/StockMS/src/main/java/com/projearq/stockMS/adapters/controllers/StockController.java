package com.projearq.stockMS.adapters.controllers;

import com.projearq.stockMS.application.usecases.FindAllProductsUC;
import com.projearq.stockMS.application.usecases.SearchStockItemUC;
import com.projearq.stockMS.business.entities.ProductEntity;
import com.projearq.stockMS.business.entities.StockEntity;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("stocks")
public class StockController {

    private final SearchStockItemUC searchStockItemUC;
    private final FindAllProductsUC findAllProductsUC;
    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public StockController(SearchStockItemUC searchStockItemUC, FindAllProductsUC findAllProductsUC, RabbitTemplate rabbitTemplate) {
        this.searchStockItemUC = searchStockItemUC;
        this.findAllProductsUC = findAllProductsUC;
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
        return this.searchStockItemUC.run(code);
    }

    @GetMapping("/teste")
    @CrossOrigin(origins = "*")
    public void novaCotacao(@RequestParam final String de, @RequestParam final String para, @RequestParam final double valor) {
        String msg = de+","+para+","+valor;
        System.out.println("Sending message: "+msg);
        rabbitTemplate.convertAndSend("sales-exchange", "sales.nova", msg);
    }

}
