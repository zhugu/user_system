package com.system.model;
/**
 * @author 邓益聪
 */
public class AuthorityItem {
    private Integer itemid;
    private Integer groupid;
    private String itemname;

    public Integer getItemid() {
        return itemid;
    }

    public void setItemid(Integer itemid) {
        this.itemid = itemid;
    }

    public Integer getGroupid() {
        return groupid;
    }

    public void setGroupid(Integer groupid) {
        this.groupid = groupid;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    @Override
    public String toString() {
        return "AuthorityItem{" +
                "itemid=" + itemid +
                ", groupid=" + groupid +
                ", itemname='" + itemname + '\'' +
                '}';
    }
}
