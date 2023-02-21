package com.vjvdg.expensetracker.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.vjvdg.expensetracker.enums.ResponseStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseResponse<V> {

    private ResponseStatus status;
    private V data;
    private String error;

}

