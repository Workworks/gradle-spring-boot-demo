package org.kfaino.core.exception.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatusCode status,
            WebRequest request){

        // 获取所有的错误信息
        List<String> errorDetails = ex.getBindingResult()
                                      .getFieldErrors()
                                      .stream()
                                      .map(fieldError -> fieldError.getField() + ": " + fieldError.getDefaultMessage())
                                      .collect(Collectors.toList());

        // 创建一个错误响应体对象
        ApiError apiError = new ApiError(
            LocalDateTime.now(),
            HttpStatus.BAD_REQUEST,
            "Validation Failed",
            errorDetails
        );

        // 返回定制的错误响应体
        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }
}