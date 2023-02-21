package com.vjvdg.expensetracker.controller;

import com.vjvdg.expensetracker.dto.ExpenseDto;
import com.vjvdg.expensetracker.enums.ResponseStatus;
import com.vjvdg.expensetracker.model.response.BaseResponse;
import com.vjvdg.expensetracker.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
        try {
            List<ExpenseDto> expenseDtoList = expenseService.getAllExpenses();
            return BaseResponse.<List<ExpenseDto>>builder()
                    .status(ResponseStatus.SUCCESS)
                    .data(expenseDtoList)
                    .build();
        } catch (Exception e) {
            return BaseResponse.<List<ExpenseDto>>builder()
                    .status(ResponseStatus.FAILURE)
                    .error(e.toString())
                    .build();
        }
    }

}
