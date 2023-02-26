package com.vjvdg.expensetracker.service;

import com.vjvdg.expensetracker.dto.ExpenseDto;
import com.vjvdg.expensetracker.entity.ExpenseEntity;
import com.vjvdg.expensetracker.exception.GenericException;
import com.vjvdg.expensetracker.repository.ExpenseEntityRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static com.vjvdg.expensetracker.util.TestObjectFactory.getExpenseDto;
import static com.vjvdg.expensetracker.util.TestObjectFactory.getExpenseEntity;
import static com.vjvdg.expensetracker.util.TestObjectFactory.getListOfExpenseEntity;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
class ExpenseServiceTest {

    @Mock
    private ExpenseEntityRepository mockExpenseEntityRepo;

    private ExpenseService expenseService;

    @BeforeEach
    void init() {
        expenseService = new ExpenseService(mockExpenseEntityRepo);
    }

    @Test
    void shouldReturnListOfExpenses() {
        Mockito.when(mockExpenseEntityRepo.findAll())
                .thenReturn(getListOfExpenseEntity());

        List<ExpenseDto> expenseDtoList = expenseService.getAllExpenses();

        Assertions.assertNotNull(expenseDtoList);
        Assertions.assertEquals(2, expenseDtoList.size());
    }

    @Test
    void shouldSaveExpenseEntity() {
        Mockito.when(mockExpenseEntityRepo.save(any(ExpenseEntity.class)))
                        .thenReturn(getExpenseEntity());

        expenseService.saveExpense(getExpenseDto());

        Mockito.verify(mockExpenseEntityRepo, times(1)).save(any(ExpenseEntity.class));
    }

    @Test
    void shouldEditExpenseEntity() {
        Mockito.when(mockExpenseEntityRepo.findById(any(Long.class)))
                .thenReturn(Optional.of(getExpenseEntity()));
        Mockito.when(mockExpenseEntityRepo.save(any(ExpenseEntity.class)))
                .thenReturn(getExpenseEntity());

        expenseService.editExpense(1L, getExpenseDto());

        Mockito.verify(mockExpenseEntityRepo, times(1)).save(any(ExpenseEntity.class));
    }

    @Test
    void shouldThrowExceptionWhenEditingExpense() {
        Mockito.when(mockExpenseEntityRepo.findById(any(Long.class)))
                .thenReturn(Optional.empty());
        ExpenseDto expenseDto = getExpenseDto();

        Assertions.assertThrows(GenericException.class, () -> expenseService.editExpense(1L, expenseDto));

    }

}
