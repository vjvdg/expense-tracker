package com.vjvdg.expensetracker.dto;

import com.vjvdg.expensetracker.enums.ExpenseCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExpenseDto {

    private Long id;
    private String item;
    private ExpenseCategory category;
    private BigDecimal amount;
    private ZonedDateTime expenseDate;

}
