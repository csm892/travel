package cn.itcast.travel.domain;

import java.util.Date;

/**
 * @author csm
 * @create 2020-11-18 上午 11:08
 */
public class Discuss {
    private  Integer uid;
    private  Integer rid;
    private Date date;
    private  String content;
    private  String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

