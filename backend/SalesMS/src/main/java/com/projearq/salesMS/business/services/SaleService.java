package com.projearq.salesMS.business.services;

import com.projearq.salesMS.application.dtos.ProductDTO;
import com.projearq.salesMS.application.dtos.StockDTO;
import com.projearq.salesMS.application.services.restrictions.RestrictionsFactory;
import com.projearq.salesMS.business.entities.SaleEntity;
import com.projearq.salesMS.business.entities.SaleItemEntity;
import com.projearq.salesMS.business.repositories.ISaleRepository;
import com.projearq.salesMS.business.strategy.IRestrictionsStrategy;
import com.projearq.salesMS.business.strategy.ITaxCalculationStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class SaleService {

    private ISaleRepository repository;
    private ITaxCalculationStrategy taxCalculationStrategy;
    private RestrictionsFactory restrictionsFactory;
    private ProductService productService;
    private StockService stockService;
    private SaleItemService saleItemService;

    @Autowired
    public SaleService(ISaleRepository repository, ITaxCalculationStrategy taxCalculationStrategy, RestrictionsFactory restrictionsFactory, ProductService productService, StockService stockService, SaleItemService saleItemService) {
        this.repository = repository;
        this.taxCalculationStrategy = taxCalculationStrategy;
        this.restrictionsFactory = restrictionsFactory;
        this.productService = productService;
        this.stockService = stockService;
        this.saleItemService = saleItemService;
    }

    public List<SaleEntity> search() {
        return this.repository.findAll();
    }

    public void validaRestricoesVenda(int ammountItems, IRestrictionsStrategy restrictions, double totalSale) {
//        if (restrictions != null && restrictions.restrictsAmmountOfSaleItems(ammountItems))
//            throw new ExcecaoDeNegocio("Restrição na quantidade total de itens da venda!");
//        if (restrictions != null && restrictions.restrictsTotalSaleValue(totalSale))
//            throw new ExcecaoDeNegocio("Restrição no total da venda!");
    }

    public double calculateSubtotal(List<ProductDTO> items, IRestrictionsStrategy restrictions, double subtotal) {
        for (ProductDTO item : items) {
//            if (restrictions != null && restrictions.restrictsAmmountItem(item.getAmmount()))
//                throw new ExcecaoDeNegocio("Restrição na quantidade para esse item!");
//            Produto produto = this.servicoDeProduto.buscaProduto(item.getCodigo());
//            subtotal += produto.getPrecoUnitario() * item.getQuantidade();
        }
        return subtotal;
    }

    public void save(List<SaleItemEntity> saleItems) {
        SaleEntity sale = SaleEntity.builder()
                .date(new Date())
                .build();
        this.repository.save(sale);
        saleItems.stream().forEach(item -> item.setSale(sale));
        this.saleItemService.saveAll(saleItems);
    }

    public boolean checkAvailability(Long codProd, Integer ammount) {
        StockDTO stock = this.stockService.searchStockItem(codProd);
        return stock.getAvailableAmmount() >= ammount;
    }

}
