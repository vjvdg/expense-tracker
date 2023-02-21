package com.vjvdg.expensetracker.repository;

import com.vjvdg.expensetracker.entity.ExpenseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseEntityRepository extends JpaRepository<ExpenseEntity, Long> {
}
