package com.projearq.salesMS.business.strategy;

public interface IRestrictionsStrategy {

    boolean restrictsAmmountSaleItems(int ammoutItemsSale);

    boolean restrictsAmmountItem(int ammoutItem);

    boolean restrictsTotalSaleValue(double totalSaleValue);

}
