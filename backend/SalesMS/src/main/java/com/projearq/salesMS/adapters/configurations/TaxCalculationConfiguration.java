package com.projearq.salesMS.adapters.configurations;

import com.projearq.salesMS.application.services.taxcalculation.ArgentinaTaxCalculation;
import com.projearq.salesMS.application.services.taxcalculation.BrazilTaxCalculation;
import com.projearq.salesMS.business.strategy.ITaxCalculationStrategy;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TaxCalculationConfiguration {

    @Bean
    @ConditionalOnProperty(name = "TAX.RULE", havingValue = "brazil", matchIfMissing = true)
    public ITaxCalculationStrategy brazilOption() {
        return new BrazilTaxCalculation();
    }

    @Bean
    @ConditionalOnProperty(name = "TAX.RULE", havingValue = "argentina")
    public ITaxCalculationStrategy ArgentinaOption() {
        return new ArgentinaTaxCalculation();
    }

}
