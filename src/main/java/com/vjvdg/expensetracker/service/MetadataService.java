package com.vjvdg.expensetracker.service;

import com.vjvdg.expensetracker.dto.Metadata;
import com.vjvdg.expensetracker.enums.ExpenseCategory;
import com.vjvdg.expensetracker.repository.ExpenseEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class MetadataService {

    private final ExpenseEntityRepository expenseEntityRepository;

    public Metadata getMetadata() {
        List<String> categories = Stream.of(ExpenseCategory.values())
                .map(ExpenseCategory::name)
                .toList();

        return Metadata.builder()
                .categories(categories)
                .years(expenseEntityRepository.getDistinctYears())
                .build();
    }

}
