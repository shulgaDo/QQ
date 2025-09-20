package com.qq.code.vo;

import jakarta.validation.constraints.Size;

public class SchoolVO {

    private Integer schoolType;

    @Size(min = 4,max = 20,message = "学校长度错误！")
    private String school;

    private Integer startDate;

    private Integer publicShow = 1;

    private Integer allowFind = 1;

    public Integer getSchoolType() {
        return schoolType;
    }

    public void setSchoolType(Integer schoolType) {
        this.schoolType = schoolType;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public Integer getPublicShow() {
        return publicShow;
    }

    public void setPublicShow(Integer publicShow) {
        this.publicShow = publicShow;
    }

    public Integer getAllowFind() {
        return allowFind;
    }

    public Integer getStartDate() {
        return startDate;
    }

    public void setStartDate(Integer startDate) {
        this.startDate = startDate;
    }

    public void setAllowFind(Integer allowFind) {
        this.allowFind = allowFind;
    }
}
