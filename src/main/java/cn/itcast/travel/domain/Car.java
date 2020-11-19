package cn.itcast.travel.domain;

/**
 * @author csm
 * @create 2020-11-19 下午 12:13
 */
public class Car {
    private Integer rid;
    private Integer uid;
    private String date;

    @Override
    public String toString() {
        return "Car{" +
                "rid=" + rid +
                ", uid=" + uid +
                ", date='" + date + '\'' +
                '}';
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
