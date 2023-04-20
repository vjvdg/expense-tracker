package com.vjvdg.expensetracker.repository;

import com.vjvdg.expensetracker.entity.ExpenseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.ZonedDateTime;
import java.util.List;

@Repository
public interface ExpenseEntityRepository extends JpaRepository<ExpenseEntity, Long> {

    List<ExpenseEntity> findAllByExpenseDateBetweenOrderByExpenseDateDesc(ZonedDateTime startDate, ZonedDateTime endDate);

}
