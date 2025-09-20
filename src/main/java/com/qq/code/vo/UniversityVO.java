package com.qq.code.vo;

public class UniversityVO {

    private Integer university;

    private Integer startDate;

    private Integer department;

    private Integer degree;

    private Integer publicShow = 1;

    private Integer allowFind = 1;

    public Integer getUniversity() {
        return university;
    }

    public void setUniversity(Integer university) {
        this.university = university;
    }

    public Integer getStartDate() {
        return startDate;
    }

    public void setStartDate(Integer startDate) {
        this.startDate = startDate;
    }

    public Integer getDepartment() {
        return department;
    }

    public void setDepartment(Integer department) {
        this.department = department;
    }

    public Integer getDegree() {
        return degree;
    }

    public void setDegree(Integer degree) {
        this.degree = degree;
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

    public void setAllowFind(Integer allowFind) {
        this.allowFind = allowFind;
    }
}
