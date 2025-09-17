package com.qq.code.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class UserInfoDTO {

    private Long id;                 // 用户ID

    private String nickname;         // 昵称

    private String avatar;           // 头像

    private String signature;        // 个性签名

    private String gender;           // 性别（"M"/"F" 或 "男"/"女"）

    private Integer photosNumber;    // 照片数量

    private String job;              // 职业

    private String company;          // 公司

    private String location;         // 所在地

    private String hometown;         // 故乡

    private String email;            // 邮箱

    private String personalStatement;// 个人说明

//    private String zodiacSign;       // 星座（如果要展示）

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateAt;  // 更新时间

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getPhotosNumber() {
        return photosNumber;
    }

    public void setPhotosNumber(Integer photosNumber) {
        this.photosNumber = photosNumber;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPersonalStatement() {
        return personalStatement;
    }

    public void setPersonalStatement(String personalStatement) {
        this.personalStatement = personalStatement;
    }

//    public String getZodiacSign() {
//        return zodiacSign;
//    }
//
//    public void setZodiacSign(String zodiacSign) {
//        this.zodiacSign = zodiacSign;
//    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }
}
