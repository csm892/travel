package cn.itcast.travel.domain;

import java.io.Serializable;

/**
 * @author csm
 * @create 2020-11-17 下午 4:26
 */
public class Order implements Serializable {
   private int oid;
    private int rid;
    private String date;
    private int uid;

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }
}
