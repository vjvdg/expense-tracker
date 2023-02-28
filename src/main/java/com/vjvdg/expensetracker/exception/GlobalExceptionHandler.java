package com.vjvdg.expensetracker.exception;

import com.vjvdg.expensetracker.model.response.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Objects;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public BaseResponse<Object> handleException(Exception ex) {
        log.error("handleException: {}", getExceptionCauseAndMessage(ex));
        return generateBaseResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public BaseResponse<Object> handleIllegalArgumentException(IllegalArgumentException ex) {
        log.error("handleIllegalArgumentException: {}", getExceptionCauseAndMessage(ex));
        return generateBaseResponse(HttpStatus.BAD_REQUEST, ex);
    }

    @ExceptionHandler(GenericException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public BaseResponse<Object> handleGenericException(GenericException ex) {
        log.error("handleGenericException: {}", getExceptionCauseAndMessage(ex));
        return generateBaseResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex);
    }


    private BaseResponse<Object> generateBaseResponse(HttpStatus status, Exception ex) {
        return BaseResponse.builder()
                .status(status)
                .code(status.value())
                .error(getExceptionCauseAndMessage(ex))
                .build();
    }

    private String getExceptionCauseAndMessage(Exception ex) {
        if (Objects.isNull(ex.getCause())) return ex.getMessage();
        return String.format("%s - %s", ex.getCause(), ex.getMessage());
    }

}
