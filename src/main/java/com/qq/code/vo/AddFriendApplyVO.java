package com.qq.code.vo;

public class AddFriendApplyVO {

    private String account;

    private String avatar;

    private String nickname;

    private String message;

    private String remark;

    private int groupId;

    private int statusPermission;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getStatusPermission() {
        return statusPermission;
    }

    public void setStatusPermission(int statusPermission) {
        this.statusPermission = statusPermission;
    }
}
