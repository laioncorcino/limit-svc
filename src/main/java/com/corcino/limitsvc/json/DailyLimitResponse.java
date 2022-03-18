package com.corcino.limitsvc.json;

import com.corcino.limitsvc.model.DailyLimit;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class DailyLimitResponse {

    private final Long dailyLimitId;
    private final Long agencyCode;
    private final Long accountCode;
    private final BigDecimal amount;

    public DailyLimitResponse(DailyLimit dailyLimit) {
        this.dailyLimitId = dailyLimit.getDailyLimitId();
        this.agencyCode = dailyLimit.getAgencyCode();
        this.accountCode = dailyLimit.getAccountCode();
        this.amount = dailyLimit.getAmount();
    }
}
