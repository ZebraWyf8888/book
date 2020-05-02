package com.atguigu.springboot.entities;

public class Manager {
    private Integer mid;
    private String mName;
    private String mUsername;
    private String mPassword;
    private Integer is_Deleted;
    private Integer store;
    private String email;
    private Integer gender;
    private String phone;

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmUsername() {
        return mUsername;
    }

    public void setmUsername(String mUsername) {
        this.mUsername = mUsername;
    }

    public String getmPassword() {
        return mPassword;
    }

    public void setmPassword(String mPassword) {
        this.mPassword = mPassword;
    }

    public Integer getIs_Deleted() {
        return is_Deleted;
    }

    public void setIs_Deleted(Integer is_Deleted) {
        this.is_Deleted = is_Deleted;
    }

    public Integer getStore() {
        return store;
    }

    public void setStore(Integer store) {
        this.store = store;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Manager() {
    }

    public Manager(Integer mid, String mName, String mUsername, String mPassword, Integer is_Deleted, Integer store, String email, Integer gender, String phone) {
        this.mid = mid;
        this.mName = mName;
        this.mUsername = mUsername;
        this.mPassword = mPassword;
        this.is_Deleted = is_Deleted;
        this.store = store;
        this.email = email;
        this.gender = gender;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "mid=" + mid +
                ", mName='" + mName + '\'' +
                ", mUsername='" + mUsername + '\'' +
                ", mPassword='" + mPassword + '\'' +
                ", is_Deleted=" + is_Deleted +
                ", store=" + store +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", phone='" + phone + '\'' +
                '}';
    }
}
