package com.projearq.salesMS.application.usecases;

import com.projearq.salesMS.application.dtos.ProductDTO;
import com.projearq.salesMS.business.entities.SaleItemEntity;
import com.projearq.salesMS.business.services.ProductService;
import com.projearq.salesMS.business.services.SaleService;
import com.projearq.salesMS.business.services.StockService;
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
        try {
            for (ProductDTO item : items) {
                this.stockService.decreaseAmmountItemStock(item.getCode(), item.getAmmount());
                ProductDTO product = this.stockService.searchProduct(item.getCode());
                SaleItemEntity saleItem = SaleItemEntity.builder()
                        .ammount(item.getAmmount())
                        .unitPrice(subtotais[0])
                        .tax(subtotais[1])
                        .productId(product.getId())
                        .build();
                saleItems.add(saleItem);
            }
            this.service.save(saleItems);
        } catch(Exception e) {
            this.stockService.rollbackStock(items);
        }
        return true;
    }

}
