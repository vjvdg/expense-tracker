package com.vjvdg.expensetracker.controller;

import com.vjvdg.expensetracker.dto.Metadata;
import com.vjvdg.expensetracker.model.response.BaseResponse;
import com.vjvdg.expensetracker.service.MetadataService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MetadataController {

    private final MetadataService metadataService;

    @GetMapping(value = "/metadata")
    public BaseResponse<Metadata> getMetadata() {
        return BaseResponse.<Metadata>builder()
                .status(HttpStatus.OK)
                .code(HttpStatus.OK.value())
                .data(metadataService.getMetadata())
                .build();
    }

}
