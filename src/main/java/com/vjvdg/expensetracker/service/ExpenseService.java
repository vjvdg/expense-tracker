package com.vjvdg.expensetracker.service;

import com.vjvdg.expensetracker.dto.ExpenseDto;
import com.vjvdg.expensetracker.entity.ExpenseEntity;
import com.vjvdg.expensetracker.exception.ExpenseTrackerError;
import com.vjvdg.expensetracker.exception.GenericException;
import com.vjvdg.expensetracker.repository.ExpenseEntityRepository;
import com.vjvdg.expensetracker.util.DateUtils;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExpenseService {

    private final ExpenseEntityRepository expenseEntityRepository;

    @Autowired
    public ExpenseService(ExpenseEntityRepository expenseEntityRepository) {
        this.expenseEntityRepository = expenseEntityRepository;
    }

    public List<ExpenseDto> getExpensesByYearAndMonth(Integer year, Integer month) {
        List<ExpenseDto> expenseDtoList = new ArrayList<>();
        List<ExpenseEntity> expenseEntityList = expenseEntityRepository.findAllByExpenseDateBetweenOrderByExpenseDateDesc(
                DateUtils.getMonthStartDateTime(year, month),
                DateUtils.getMonthEndDateTime(year, month)
        );
        expenseEntityList.forEach(expenseEntity -> expenseDtoList.add(convertToExpenseDto(expenseEntity)));
        return expenseDtoList;
    }

    @Transactional
    @SneakyThrows
    public void saveExpense(ExpenseDto expenseDto) {
        Thread.sleep(1000);
        expenseEntityRepository.save(buildExpenseEntity(expenseDto));
    }

    @Transactional
    @SneakyThrows
    public void editExpense(Long id, ExpenseDto expenseDto) {
        Thread.sleep(1000);
        ExpenseEntity expenseToEdit = expenseEntityRepository.findById(id)
                .orElseThrow(() -> new GenericException(ExpenseTrackerError.EXPENSE_NOT_FOUND));
        expenseToEdit.setItem(expenseDto.getItem());
        expenseToEdit.setCategory(expenseDto.getCategory());
        expenseToEdit.setAmount(expenseDto.getAmount());
        expenseToEdit.setExpenseDate(expenseDto.getExpenseDate());
        expenseEntityRepository.save(expenseToEdit);
    }

    @Transactional
    @SneakyThrows
    public void deleteExpense(Long id) {
        Thread.sleep(1000);
        ExpenseEntity expenseToDelete = expenseEntityRepository.findById(id)
                .orElseThrow(() -> new GenericException(ExpenseTrackerError.EXPENSE_NOT_FOUND));
        expenseEntityRepository.delete(expenseToDelete);
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

    private ExpenseEntity buildExpenseEntity(ExpenseDto expenseDto) {
        return ExpenseEntity.builder()
                .item(expenseDto.getItem())
                .category(expenseDto.getCategory())
                .amount(expenseDto.getAmount())
                .expenseDate(ZonedDateTime.ofInstant(Instant.now(), ZoneId.of("Asia/Singapore")))
                .build();
    }

}
