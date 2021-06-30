package com.projearq.stockMS.adapters.controllers;

import com.projearq.stockMS.application.dtos.ProductDTO;
import com.projearq.stockMS.application.usecases.CalculateBasicCostUC;
import com.projearq.stockMS.application.usecases.CheckAvailabilityUC;
import com.projearq.stockMS.application.usecases.ConfirmSaleUC;
import com.projearq.stockMS.application.usecases.SalesSearchUC;
import com.projearq.stockMS.business.entities.SaleEntity;
import com.projearq.stockMS.business.repositories.ISaleRepository;
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
