package com.system.model;
/**
 * @author 邓益聪
 */
public class Department {
    private Integer departmentid;
    private String departmentname;
    private String introduction;
    private String departmenttel;

    public Department(Integer departmentid, String departmentname, String introduction, String departmenttel) {
        this.departmentid = departmentid;
        this.departmentname = departmentname;
        this.introduction = introduction;
        this.departmenttel = departmenttel;
    }

    public Department() {
    }

    public Integer getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(Integer departmentid) {
        this.departmentid = departmentid;
    }

    public String getDepartmentname() {
        return departmentname;
    }

    public void setDepartmentname(String departmentname) {
        this.departmentname = departmentname;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getDepartmenttel() {
        return departmenttel;
    }

    public void setDepartmenttel(String departmenttel) {
        this.departmenttel = departmenttel;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentid=" + departmentid +
                ", departmentname='" + departmentname + '\'' +
                ", introduction='" + introduction + '\'' +
                ", departmenttel='" + departmenttel + '\'' +
                '}';
    }
}
