package cn.itcast.travel.domain;

/**
 * @author csm
 * @create 2020-11-18 上午 11:08
 */
public class Discuss {
    private  Integer uid;
    private  Integer rid;
    private String date;
    private  String content;

    @Override
    public String toString() {
        return "Discuss{" +
                "uid=" + uid +
                ", rid=" + rid +
                ", date='" + date + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

