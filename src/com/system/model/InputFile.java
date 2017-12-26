package com.system.model;

import java.sql.Date;
/**
 * @author 邓益聪
 */
public class InputFile {
    private Integer fileid;
    private String userid;
    private Date inputtime;
    private String fileurl;

    public InputFile(Integer fileid, String userid, Date inputtime, String fileurl) {
        this.fileid = fileid;
        this.userid = userid;
        this.inputtime = inputtime;
        this.fileurl = fileurl;
    }

    public InputFile() {
    }

    public Integer getFileid() {
        return fileid;
    }

    public void setFileid(Integer fileid) {
        this.fileid = fileid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public Date getInputtime() {
        return inputtime;
    }

    public void setInputtime(Date inputtime) {
        this.inputtime = inputtime;
    }

    public String getFileurl() {
        return fileurl;
    }

    public void setFileurl(String fileurl) {
        this.fileurl = fileurl;
    }

    @Override
    public String toString() {
        return "InputFile{" +
                "fileid=" + fileid +
                ", userid='" + userid + '\'' +
                ", inputtime=" + inputtime +
                ", fileurl='" + fileurl + '\'' +
                '}';
    }
}
