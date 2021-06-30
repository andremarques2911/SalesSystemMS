package com.projearq.salesMS.adapters.controllers;

import com.projearq.salesMS.application.dtos.ProductDTO;
import com.projearq.salesMS.application.usecases.CalculateBasicCostUC;
import com.projearq.salesMS.application.usecases.CheckAvailabilityUC;
import com.projearq.salesMS.application.usecases.ConfirmSaleUC;
import com.projearq.salesMS.application.usecases.SalesSearchUC;
import com.projearq.salesMS.business.entities.SaleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("sales")
public class SaleController {

    private SalesSearchUC salesSearchUC;

    private CalculateBasicCostUC calculateBasicCostUC;

    private ConfirmSaleUC confirmSaleUC;

    private CheckAvailabilityUC checkAvailabilityUC;

    @Autowired
    public SaleController(SalesSearchUC salesSearchUC, CalculateBasicCostUC calculateBasicCostUC, ConfirmSaleUC confirmSaleUC, CheckAvailabilityUC checkAvailabilityUC) {
        this.salesSearchUC = salesSearchUC;
        this.calculateBasicCostUC = calculateBasicCostUC;
        this.confirmSaleUC = confirmSaleUC;
        this.checkAvailabilityUC = checkAvailabilityUC;
    }

    @GetMapping("/historico")
    @CrossOrigin(origins = "*")
    public List<SaleEntity> salesSearch() {
        return this.salesSearchUC.run();
    }

    @PostMapping("/subtotal")
    @CrossOrigin(origins = "*")
    public Double[] calculateBasicCost(@RequestBody final List<ProductDTO> itens) {
        return this.calculateBasicCostUC.run(itens);
    }

    @PostMapping("/confirmacao")
    @CrossOrigin(origins = "*")
    public boolean confirmSale(@RequestBody final List<ProductDTO> itens) {
        return this.confirmSaleUC.run(itens);
    }

    @GetMapping("/autorizacao")
    @CrossOrigin(origins = "*")
    public boolean checkAvailability(@RequestParam final Long codProd, @RequestParam final Integer qtdade) {
        return this.checkAvailabilityUC.run(codProd, qtdade);
    }

}
