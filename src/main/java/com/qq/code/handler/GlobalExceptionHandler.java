package com.qq.code.handler;

import com.qq.code.common.ApiResponse;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

//    @ExceptionHandler(Exception.class)
//   public ApiResponse handleException(Exception e){
//        logger.error(e.getMessage());
//        return ApiResponse.failed("出现异常了！快找找吧");
//   }
//
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ApiResponse handleValidationException(MethodArgumentNotValidException e){
//        String message = e.getMessage();
//        logger.error(message);
//        return ApiResponse.failed(message);
//    }

    /**
     * 处理 @Valid @RequestBody 校验失败异常
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ApiResponse<?> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        List<String> errors = new ArrayList<>();
        ex.getBindingResult().getFieldErrors()
                .forEach(error -> errors.add(error.getField() + ": " + error.getDefaultMessage()));
        return ApiResponse.failed(String.join("; ", errors));
    }

    /**
     * 处理 @Validated 普通参数校验异常，如 @RequestParam、@PathVariable
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public ApiResponse<?> handleConstraintViolation(ConstraintViolationException ex) {
        List<String> errors = new ArrayList<>();
        ex.getConstraintViolations().forEach(cv ->
                errors.add(cv.getPropertyPath() + ": " + cv.getMessage()));
        return ApiResponse.failed(String.join("; ", errors));
    }

    /**
     * 处理绑定异常（如表单参数或 GET 请求绑定到对象失败）
     */
    @ExceptionHandler(BindException.class)
    public ApiResponse<?> handleBindException(BindException ex) {
        List<String> errors = new ArrayList<>();
        ex.getBindingResult().getFieldErrors()
                .forEach(error -> errors.add(error.getField() + ": " + error.getDefaultMessage()));
        return ApiResponse.failed(String.join("; ", errors));
    }

    /**
     * 处理其他未捕获异常
     */
    @ExceptionHandler(Exception.class)
    public ApiResponse<?> handleOtherExceptions(Exception ex) {
        // 可以打印日志
        ex.printStackTrace();
        return ApiResponse.failed("系统异常: " + ex.getMessage());
    }

}
