package com.projearq.stockMS.application.usecases;

import com.projearq.stockMS.application.dtos.ProductDTO;
import com.projearq.stockMS.business.entities.ProductEntity;
import com.projearq.stockMS.business.entities.SaleItemEntity;
import com.projearq.stockMS.business.services.ProductService;
import com.projearq.stockMS.business.services.SaleService;
import com.projearq.stockMS.business.services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ConfirmSaleUC {

    private SaleService service;
    private StockService stockService;
    private ProductService productService;
    private CalculateBasicCostUC calculateBasicCostUC;

    @Autowired
    public ConfirmSaleUC(SaleService service, StockService stockService, ProductService productService, CalculateBasicCostUC calculateBasicCostUC) {
        this.service = service;
        this.stockService = stockService;
        this.productService = productService;
        this.calculateBasicCostUC = calculateBasicCostUC;
    }

    public boolean run(List<ProductDTO> items) {
        List<SaleItemEntity> saleItems = new ArrayList<>();
        Double[] subtotais = this.calculateBasicCostUC.run(items);
        for (ProductDTO item : items) {
//            this.stockService.diminuiQuantidadeItemEstoque(item.getCodigo(), item.getQuantidade());
//            ProductDTO product = this.productService.buscaProduto(item.getCode());
            SaleItemEntity saleItem = SaleItemEntity.builder()
                    .ammount(item.getAmmount())
                    .unitPrice(subtotais[0])
                    .tax(subtotais[1])
//                    .produto(produto)
                    .build();
            saleItems.add(saleItem);
        }
        this.service.save(saleItems);
        return true;
    }

}
