package com.projearq.stockMS.adapters.controllers;

import com.projearq.stockMS.business.entities.SaleEntity;
import com.projearq.stockMS.business.repositories.ISaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("sales")
public class SaleController {

    private final ISaleRepository repository;

    @Autowired
    public SaleController(ISaleRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    @CrossOrigin(origins = "*")
    public List<SaleEntity> findAll() {
        return repository.findAll();
    }

}
