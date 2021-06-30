package com.projearq.salesMS.application.services.restrictions;

import com.projearq.salesMS.business.strategy.IRestrictionsStrategy;
import org.springframework.stereotype.Component;

@Component
public class LowLevelRestrictions implements IRestrictionsStrategy {

    private final int MAXIMUM_AMMOUNT_OF_SALE_ITEMS = 10;
    private final int MAXIMUM_AMMOUNT_ITEM = 10;
    private final int MAXIMUM_TOTAL_SALE_VALUE = 10000;

    @Override
    public boolean restrictsAmmountSaleItems(int ammountSaleItens) {
        return ammountSaleItens > this.MAXIMUM_AMMOUNT_OF_SALE_ITEMS;
    }

    @Override
    public boolean restrictsAmmountItem(int itemAmmount) {
        return itemAmmount > this.MAXIMUM_AMMOUNT_ITEM;
    }

    @Override
    public boolean restrictsTotalSaleValue(double totalSaleValue) {
        return totalSaleValue > this.MAXIMUM_TOTAL_SALE_VALUE;
    }

}
