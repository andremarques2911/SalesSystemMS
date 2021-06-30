package com.projearq.salesMS.application.services.restrictions;

import com.projearq.salesMS.business.strategy.IRestrictionsStrategy;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
public class RestrictionsFactory {

    private final LocalTime CLOSING_TIME = LocalTime.of(19,0,0);

    public IRestrictionsStrategy restrictions() {
        if (LocalTime.now().isAfter(CLOSING_TIME)) {
            return new LowLevelRestrictions();
        } else {
            return null;
        }
    }

}
