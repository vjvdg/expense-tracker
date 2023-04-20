package com.vjvdg.expensetracker.util;

import com.vjvdg.expensetracker.dto.ExpenseDto;
import com.vjvdg.expensetracker.entity.ExpenseEntity;
import com.vjvdg.expensetracker.enums.ExpenseCategory;

import java.math.BigDecimal;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

public class TestObjectFactory {

    public static List<ExpenseDto> getListOfExpenseDto() {
        return List.of(
                ExpenseDto.builder()
                        .id(1L)
                        .item("item1")
                        .category(ExpenseCategory.DINING)
                        .amount(BigDecimal.ONE)
                        .expenseDate(ZonedDateTime.now(ZoneId.systemDefault()))
                        .build(),
                ExpenseDto.builder()
                        .id(2L)
                        .item("item2")
                        .category(ExpenseCategory.TRANSPORT)
                        .amount(BigDecimal.TEN)
                        .expenseDate(ZonedDateTime.now(ZoneId.systemDefault()))
                        .build()
        );
    }

    public static ExpenseDto getExpenseDto() {
        return ExpenseDto.builder()
                .id(1L)
                .item("item1")
                .category(ExpenseCategory.DINING)
                .amount(BigDecimal.ONE)
                .expenseDate(ZonedDateTime.now(ZoneId.systemDefault()))
                .build();
    }

    public static List<ExpenseEntity> getListOfExpenseEntity() {
        return List.of(
                ExpenseEntity.builder()
                        .id(1L)
                        .item("item1")
                        .category(ExpenseCategory.DINING)
                        .amount(BigDecimal.ONE)
                        .expenseDate(ZonedDateTime.now(ZoneId.systemDefault()))
                        .build(),
                ExpenseEntity.builder()
                        .id(2L)
                        .item("item2")
                        .category(ExpenseCategory.TRANSPORT)
                        .amount(BigDecimal.TEN)
                        .expenseDate(ZonedDateTime.now(ZoneId.systemDefault()))
                        .build()
        );
    }

    public static ExpenseEntity getExpenseEntity() {
        return ExpenseEntity.builder()
                .id(1L)
                .item("item1")
                .category(ExpenseCategory.DINING)
                .amount(BigDecimal.ONE)
                .expenseDate(ZonedDateTime.now(ZoneId.systemDefault()))
                .build();
    }

}
