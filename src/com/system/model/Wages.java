package com.system.model;

import java.sql.Date;
/**
 * @author 邓益聪
 */
public class Wages {
    private Integer wagesid;
    private String userid;
    private Double basicwages;
    private Double attendancereward;
    private Double yearwages;
    private Double publish;
    private Double insurance;
    private Double tax;
    private Double wages;
    private Double truewages;
    private Date date;

    public Wages(Integer wagesid, String userid, Double basicwages, Double attendancereward,  Double yearwages, Double publish, Double insurance, Double tax, Double wages, Double truewages, Date date) {
        this.wagesid = wagesid;
        this.userid = userid;
        this.basicwages = basicwages;
        this.attendancereward = attendancereward;
        this.yearwages = yearwages;
        this.publish = publish;
        this.insurance = insurance;
        this.tax = tax;
        this.wages = wages;
        this.truewages = truewages;
        this.date = date;
    }

    public Wages() {
    }

    public Integer getWagesid() {
        return wagesid;
    }

    public void setWagesid(Integer wagesid) {
        this.wagesid = wagesid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public Double getBasicwages() {
        return basicwages;
    }

    public void setBasicwages(Double basicwages) {
        this.basicwages = basicwages;
    }

    public Double getAttendancereward() {
        return attendancereward;
    }

    public void setAttendancereward(Double attendancereward) {
        this.attendancereward = attendancereward;
    }


    public Double getYearwages() {
        return yearwages;
    }

    public void setYearwages(Double yearwages) {
        this.yearwages = yearwages;
    }

    public Double getPublish() {
        return publish;
    }

    public void setPublish(Double publish) {
        this.publish = publish;
    }

    public Double getInsurance() {
        return insurance;
    }

    public void setInsurance(Double insurance) {
        this.insurance = insurance;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public Double getWages() {
        return wages;
    }

    public void setWages(Double wages) {
        this.wages = wages;
    }

    public Double getTruewages() {
        return truewages;
    }

    public void setTruewages(Double truewages) {
        this.truewages = truewages;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Wages{" +
                "wagesid=" + wagesid +
                ", userid='" + userid + '\'' +
                ", basicwages=" + basicwages +
                ", attendancereward=" + attendancereward +
                ", yearwages=" + yearwages +
                ", publish=" + publish +
                ", insurance=" + insurance +
                ", tax=" + tax +
                ", wages=" + wages +
                ", truewages=" + truewages +
                ", date=" + date +
                '}';
    }
}
