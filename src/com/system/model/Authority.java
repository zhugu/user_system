package com.system.model;
/**
 * @author 邓益聪
 */
public class Authority {
    private Integer id;
    private String userid;
    private Integer itemid;

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

    public Integer getItemid() {
        return itemid;
    }

    public void setItemid(Integer itemid) {
        this.itemid = itemid;
    }

    @Override
    public String toString() {
        return "Authority{" +
                "userid='" + userid + '\'' +
                ", itemid=" + itemid +
                '}';
    }
}
