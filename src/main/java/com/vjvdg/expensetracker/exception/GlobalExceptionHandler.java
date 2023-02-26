package com.vjvdg.expensetracker.exception;

import com.vjvdg.expensetracker.model.response.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.NestedExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public BaseResponse<Object> handleGenericException(Exception ex) {
        log.error("Exception: {}", ex.getMessage());
        return generateBaseResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex);
    }

    @ExceptionHandler(HttpClientErrorException.BadRequest.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public BaseResponse<Object> handleBadRequestException(HttpClientErrorException.BadRequest ex) {
        log.error("Exception: {}", ex.getMessage());
        return generateBaseResponse(HttpStatus.BAD_REQUEST, ex);
    }

    @ExceptionHandler(GenericException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public BaseResponse<Object> handleGenericException(GenericException ex) {
        log.error("Exception: {}", ex.getMessage());
        return generateBaseResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex);
    }


    private BaseResponse<Object> generateBaseResponse(HttpStatus status, Exception ex) {
        return BaseResponse.builder()
                .status(status)
                .code(status.value())
                .error(NestedExceptionUtils.getMostSpecificCause(ex).getMessage())
                .build();
    }

}
