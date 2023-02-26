package com.vjvdg.expensetracker.controller;

import com.vjvdg.expensetracker.dto.ExpenseDto;
import com.vjvdg.expensetracker.model.response.BaseResponse;
import com.vjvdg.expensetracker.service.ExpenseService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import java.util.List;

import static com.vjvdg.expensetracker.util.TestObjectFactory.getExpenseDto;
import static com.vjvdg.expensetracker.util.TestObjectFactory.getListOfExpenseDto;
import static org.mockito.Mockito.any;

@ExtendWith(MockitoExtension.class)
class ExpenseControllerTest {

    @Mock
    private ExpenseService mockExpenseService;

    private ExpenseController expenseController;

    @BeforeEach
    void init() {
        expenseController = new ExpenseController(mockExpenseService);
    }

    @Test
    void shouldReturnListOfExpenses() {
        Mockito.when(mockExpenseService.getAllExpenses())
                .thenReturn(getListOfExpenseDto());

        BaseResponse<List<ExpenseDto>> baseResponse = expenseController.getAllExpenses();
        List<ExpenseDto> expenses = baseResponse.getData();

        Assertions.assertNotNull(expenses);
        Assertions.assertEquals(2, expenses.size());
    }

    @Test
    void shouldReturnOkStatusWhenSavingExpense() {
        Mockito.doNothing().when(mockExpenseService).saveExpense(any(ExpenseDto.class));

        BaseResponse<Object> baseResponse = expenseController.saveExpense(getExpenseDto());
        HttpStatus status = baseResponse.getStatus();

        Assertions.assertNotNull(baseResponse);
        Assertions.assertEquals(HttpStatus.OK, status);
    }

    @Test
    void shouldReturnOkStatusWhenEditingExpense() {
        Mockito.doNothing().when(mockExpenseService).editExpense(any(Long.class), any(ExpenseDto.class));

        BaseResponse<Object> baseResponse = expenseController.editExpense(1L, getExpenseDto());
        HttpStatus status = baseResponse.getStatus();

        Assertions.assertNotNull(baseResponse);
        Assertions.assertEquals(HttpStatus.OK, status);
    }

}
