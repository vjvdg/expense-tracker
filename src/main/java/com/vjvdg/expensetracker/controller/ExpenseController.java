package com.vjvdg.expensetracker.controller;

import com.vjvdg.expensetracker.dto.ExpenseDto;
import com.vjvdg.expensetracker.model.response.BaseResponse;
import com.vjvdg.expensetracker.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/expense")
public class ExpenseController {

    private final ExpenseService expenseService;

    @Autowired
    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping(value = "/all")
    public BaseResponse<List<ExpenseDto>> getAllExpenses() {
        List<ExpenseDto> expenseDtoList = expenseService.getAllExpenses();
        return BaseResponse.<List<ExpenseDto>>builder()
                .status(HttpStatus.OK)
                .code(HttpStatus.OK.value())
                .data(expenseDtoList)
                .build();
    }

    @PostMapping(value = "/save")
    public BaseResponse<Object> saveExpense(@RequestBody ExpenseDto expenseDto) {
        expenseService.saveExpense(expenseDto);
        return BaseResponse.builder()
                .status(HttpStatus.OK)
                .code(HttpStatus.OK.value())
                .data("Expense successfully saved")
                .build();
    }

    @PostMapping(value = "/edit")
    public BaseResponse<Object> editExpense(@RequestParam Long id, @RequestBody ExpenseDto expenseDto) {
        expenseService.editExpense(id, expenseDto);
        return BaseResponse.builder()
                .status(HttpStatus.OK)
                .code(HttpStatus.OK.value())
                .data("Expense successfully edited")
                .build();
    }

    @PostMapping(value = "/delete")
    public BaseResponse<Object> deleteExpense(@RequestParam Long id) {
        expenseService.deleteExpense(id);
        return BaseResponse.builder()
                .status(HttpStatus.OK)
                .code(HttpStatus.OK.value())
                .data("Expense successfully deleted")
                .build();
    }

}
