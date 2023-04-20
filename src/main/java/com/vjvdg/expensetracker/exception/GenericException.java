package com.vjvdg.expensetracker.exception;

public class GenericException extends RuntimeException {

    public GenericException(ExpenseTrackerError expenseTrackerError) {
        super(expenseTrackerError.getDescription());
    }

}
