package com.qq.code.handler;

import com.qq.code.common.ApiResponse;
import com.qq.code.exception.BizException;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(BindException.class)
    public ApiResponse handleBindException(BindException ex) {
        // 获取校验错误信息
        String errorMsg = ex.getAllErrors().stream()
                .map(e -> e.getDefaultMessage())
                .findFirst()
                .orElse("参数校验错误");
        return ApiResponse.failed(errorMsg);
    }

    @ExceptionHandler(Exception.class)
    public ApiResponse handleOtherException(Exception ex) {
        return ApiResponse.failed(ex.getMessage());
    }

    /**
     * 捕获断言类异常
      * @param ex
     * @return
     */
    @ExceptionHandler(BizException.class)
    public ApiResponse handleBizException(BizException ex) {
        return ApiResponse.failed(ex.getErrorMessage());
    }

}
