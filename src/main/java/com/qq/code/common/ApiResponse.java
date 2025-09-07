package com.qq.code.common;

import com.qq.code.common.api.ErrorCode;
import com.qq.code.common.api.StatusCode;
import com.qq.code.entity.User;
import lombok.Getter;
import lombok.Setter;


public class ApiResponse<T> {

   private Integer code;

   private String message;

   private T result;

   public ApiResponse(){};

   public ApiResponse(Integer code, String message){
       this.code = code;
       this.message = message;
   }

   public ApiResponse(Integer code, String message, T result){
       this.code = code;
       this.message = message;
       this.result = result;
   }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    /**
     * 请求成功，返回相应结果
     * @param result
     * @return
     * @param <T>
     */
   public static <T> ApiResponse success(T result){
       ApiResponse res = new ApiResponse(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getMessage());
       res.setResult(result);
       return res;
   }

    /**
     * 请求失败
     * @return
     */
   public static ApiResponse failed(){
      return new ApiResponse(StatusCode.FAILED.getCode(), StatusCode.FAILED.getMessage());
   }

    /**
     * 请求失败，返回错误信息
      * @param errorMessage
     * @return
     * @param <T>
     */
   public static <T> ApiResponse failed(T errorMessage){
      return new ApiResponse(StatusCode.FAILED.getCode(), StatusCode.FAILED.getMessage(),errorMessage);
   }

    /**
     * 出现错误，返回错误信息
     * @param errorCode
     * @param errorMessage
     * @return
     * @param <T>
     */
   public static <T> ApiResponse failed(ErrorCode errorCode,T errorMessage){
      return new ApiResponse(errorCode.getCode(), errorCode.getMessage(),errorMessage);
   }




}
