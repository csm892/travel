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
    private String status;//订单支付状态，Y代表支付，N代表未支付
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


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
