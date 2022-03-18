package com.corcino.limitsvc.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Table
@Entity
@Data
public class DailyLimit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dailyLimitId;
    private Long agencyCode;
    private Long accountCode;
    private BigDecimal amount;

}
