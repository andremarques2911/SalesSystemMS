package com.projearq.stockMS.adapters.controllers;

import com.projearq.stockMS.business.entities.SaleEntity;
import com.projearq.stockMS.business.repositories.ISaleRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("stock")
public class StockController {

    private final ISaleRepository repository;
    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public StockController(ISaleRepository repository, RabbitTemplate rabbitTemplate) {
        this.repository = repository;
        this.rabbitTemplate = rabbitTemplate;
    }

    @GetMapping
    @CrossOrigin(origins = "*")
    public List<SaleEntity> findAll() {
        return repository.findAll();
    }

    @GetMapping("/teste")
    @CrossOrigin(origins = "*")
    public void novaCotacao(@RequestParam final String de, @RequestParam final String para, @RequestParam final double valor) {
        String msg = de+","+para+","+valor;
        System.out.println("Sending message: "+msg);
        rabbitTemplate.convertAndSend("sales-exchange", "sales.nova", msg);
    }

}
