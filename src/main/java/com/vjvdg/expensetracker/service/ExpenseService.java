package com.vjvdg.expensetracker.service;

import com.vjvdg.expensetracker.dto.ExpenseDto;
import com.vjvdg.expensetracker.entity.ExpenseEntity;
import com.vjvdg.expensetracker.repository.ExpenseEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExpenseService {

    private final ExpenseEntityRepository expenseEntityRepository;

    @Autowired
    public ExpenseService(ExpenseEntityRepository expenseEntityRepository) {
        this.expenseEntityRepository = expenseEntityRepository;
    }

    public List<ExpenseDto> getAllExpenses() {
        List<ExpenseDto> expenseDtoList = new ArrayList<>();
        List<ExpenseEntity> expenseEntityList = expenseEntityRepository.findAll();
        expenseEntityList.forEach(expenseEntity -> expenseDtoList.add(convertToExpenseDto(expenseEntity)));
        return expenseDtoList;
    }

    private ExpenseDto convertToExpenseDto(ExpenseEntity expenseEntity) {
        return ExpenseDto.builder()
                .id(expenseEntity.getId())
                .item(expenseEntity.getItem())
                .category(expenseEntity.getCategory())
                .amount(expenseEntity.getAmount())
                .expenseDate(expenseEntity.getExpenseDate())
                .build();
    }

}
