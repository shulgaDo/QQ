package com.qq.code.vo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class LoginVO {

    @NotBlank(message = "账号不能为空!")
    private String account;

    @NotBlank(message = "密码不能为空")
    @Size(min = 8,max = 20,message = "密码长度为8~20位！")
    private String password;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
