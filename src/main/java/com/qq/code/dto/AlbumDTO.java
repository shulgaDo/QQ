package com.qq.code.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

public class AlbumDTO {

    private String albumDescribe;

    private Integer albumStatus;

    private Integer personalTitle;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @CreationTimestamp
    private LocalDateTime createTime;

    private int isSuccess;

    public String getAlbumDescribe() {
        return albumDescribe;
    }

    public void setAlbumDescribe(String albumDescribe) {
        this.albumDescribe = albumDescribe;
    }

    public Integer getAlbumStatus() {
        return albumStatus;
    }

    public void setAlbumStatus(Integer albumStatus) {
        this.albumStatus = albumStatus;
    }

    public Integer getPersonalTitle() {
        return personalTitle;
    }

    public void setPersonalTitle(Integer personalTitle) {
        this.personalTitle = personalTitle;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public int getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(int isSuccess) {
        this.isSuccess = isSuccess;
    }
}
