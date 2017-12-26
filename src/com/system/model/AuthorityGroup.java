package com.system.model;
/**
 * @author 邓益聪
 */
public class AuthorityGroup {
    private Integer groupid;
    private String groupname;

    public Integer getGroupid() {
        return groupid;
    }

    public void setGroupid(Integer groupid) {
        this.groupid = groupid;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    @Override
    public String toString() {
        return "AuthorityGroup{" +
                "groupid=" + groupid +
                ", groupname='" + groupname + '\'' +
                '}';
    }
}
