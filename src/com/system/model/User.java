package com.system.model;

import java.sql.Date;
import java.util.Arrays;
/**
 * @author 邓益聪
 */
public class User {
    private String userid;
    private String name;
    private byte[] picture;
    private String sex;
    private String address;
    private String place;
    private String nation;
    private Integer departmentid;
    private String job;
    private String tel;
    private Date entrytime;
    private String identityID;

    public User(String userid, String name, byte[] picture, String sex, String address, String place, String nation, Integer departmentid, String job, String tel, Date entrytime, String identityID) {
        this.userid = userid;
        this.name = name;
        this.picture = picture;
        this.sex = sex;
        this.address = address;
        this.place = place;
        this.nation = nation;
        this.departmentid = departmentid;
        this.job = job;
        this.tel = tel;
        this.entrytime = entrytime;
        this.identityID = identityID;
    }

    public User() {
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public Integer getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(Integer departmentid) {
        this.departmentid = departmentid;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Date getEntrytime() {
        return entrytime;
    }

    public void setEntrytime(Date entrytime) {
        this.entrytime = entrytime;
    }

    public String getIdentityID() {
        return identityID;
    }

    public void setIdentityID(String identityID) {
        this.identityID = identityID;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid='" + userid + '\'' +
                ", name='" + name + '\'' +
                ", picture=" + Arrays.toString(picture) +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                ", place='" + place + '\'' +
                ", nation='" + nation + '\'' +
                ", departmentid=" + departmentid +
                ", job='" + job + '\'' +
                ", tel='" + tel + '\'' +
                ", entrytime=" + entrytime +
                ", identityID='" + identityID + '\'' +
                '}';
    }
}
