package com.system.model;

import java.sql.Date;

/**
 * @author 邓益聪
 */
public class Apply {
    private Integer applyid;
    private String userid;
    private String applyinfo;
    private Date applydate;
    private String examination;

    public Apply(Integer applyid, String userid, String applyinfo, Date applydate, String examination) {
        this.applyid = applyid;
        this.userid = userid;
        this.applyinfo = applyinfo;
        this.applydate = applydate;
        this.examination = examination;
    }

    public Apply() {
    }

    public Integer getApplyid() {
        return applyid;
    }

    public void setApplyid(Integer applyid) {
        this.applyid = applyid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getApplyinfo() {
        return applyinfo;
    }

    public void setApplyinfo(String applyinfo) {
        this.applyinfo = applyinfo;
    }

    public Date getApplydate() {
        return applydate;
    }

    public void setApplydate(Date applydate) {
        this.applydate = applydate;
    }

    public String getExamination() {
        return examination;
    }

    public void setExamination(String examination) {
        this.examination = examination;
    }

    @Override
    public String toString() {
        return "Apply{" +
                "applyid=" + applyid +
                ", userid='" + userid + '\'' +
                ", applyinfo='" + applyinfo + '\'' +
                ", applydate='" + applydate + '\'' +
                ", examination='" + examination + '\'' +
                '}';
    }
}
