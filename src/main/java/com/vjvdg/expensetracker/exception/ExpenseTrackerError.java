package com.vjvdg.expensetracker.exception;

import lombok.Getter;

@Getter
public enum ExpenseTrackerError {

    EXPENSE_NOT_FOUND("Expense not found");

    private final String description;

    ExpenseTrackerError(String description) {
        this.description = description;
    }

}
