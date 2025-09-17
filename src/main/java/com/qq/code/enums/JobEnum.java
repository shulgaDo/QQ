package com.qq.code.enums;

import com.qq.code.exception.BizException;

public enum JobEnum {
    STUDENT(1,"学生"),
    OTHER(2,"其他职业");

    private final int code;

    private final String job;

    JobEnum(int code, String job) {
        this.code = code;
        this.job = job;
    }

    public int getCode() {
        return code;
    }

    public String getJob() {
        return job;
    }

    public static String fromCodeToJob(int code){
        for (JobEnum job: JobEnum.values()
             ) {
            if (job.getCode() == code){
                return job.getJob();
            }

        }
        throw new BizException("老子不知道");
    }
}
