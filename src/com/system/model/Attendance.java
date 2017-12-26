package com.system.model;

import java.sql.Date;
/**
 * @author 邓益聪
 */
public class Attendance {
    private Integer id;
    private String userid;
    private Date date;
    private String attendance;

    public Attendance(Integer id, String userid, Date date, String attendance) {
        this.id = id;
        this.userid = userid;
        this.date = date;
        this.attendance = attendance;
    }

    public Attendance() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAttendance() {
        return attendance;
    }

    public void setAttendance(String attendance) {
        this.attendance = attendance;
    }

    @Override
    public String toString() {
        return "Attendance{" +
                "id=" + id +
                ", userid='" + userid + '\'' +
                ", date=" + date +
                ", attendance='" + attendance + '\'' +
                '}';
    }
}
