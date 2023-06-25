package com.microservices.wallet.dto;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class TransactionDto {
    private Long userId;
    private String symbol;
    private BigDecimal quantity;

}
