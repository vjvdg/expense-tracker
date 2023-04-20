package com.vjvdg.expensetracker.entity;

import com.vjvdg.expensetracker.enums.ExpenseCategory;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Entity
@Table(name = "expense")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExpenseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "item")
    private String item;

    @Column(name = "category")
    @Enumerated(EnumType.STRING)
    private ExpenseCategory category;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "expense_date")
    private ZonedDateTime expenseDate;

}
