package com.qq.code.vo;

import jakarta.validation.constraints.Size;

public class NewAlbumVO {

    @Size(min = 1,max = 10,message = "相册名称在1~10之间")
    private String albumDescribe;

    private Integer albumStatus;

    private Integer personalTitle;

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
}
