package com.system.model;

import java.sql.Date;
/**
 * @author 邓益聪
 */
public class Republish {
    private Integer rpid;
    private String userid;
    private String rpname;
    private Date rpdate;
    private String rpreason;
    private String reresult;

    public Republish( String userid, String rpname, Date rpdate, String rpreason, String reresult) {
        this.userid = userid;
        this.rpname = rpname;
        this.rpdate = rpdate;
        this.rpreason = rpreason;
        this.reresult = reresult;
    }

    public Republish() {
    }

    public Integer getRpid() {
        return rpid;
    }

    public void setRpid(Integer rpid) {
        this.rpid = rpid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getRpname() {
        return rpname;
    }

    public void setRpname(String rpname) {
        this.rpname = rpname;
    }

    public Date getRpdate() {
        return rpdate;
    }

    public void setRpdate(Date rpdate) {
        this.rpdate = rpdate;
    }

    public String getRpreason() {
        return rpreason;
    }

    public void setRpreason(String rpreason) {
        this.rpreason = rpreason;
    }

    public String getReresult() {
        return reresult;
    }

    public void setReresult(String reresult) {
        this.reresult = reresult;
    }

    @Override
    public String toString() {
        return "Republish{" +
                "rpid=" + rpid +
                ", userid='" + userid + '\'' +
                ", rpname='" + rpname + '\'' +
                ", rpdate=" + rpdate +
                ", rpreason='" + rpreason + '\'' +
                ", reresult='" + reresult + '\'' +
                '}';
    }
}
