package cn.boom.domain;

public class Favorite {
    private int rid;
    private int uid;
    private String date;

    public Favorite() {
    }

    public Favorite(int rid, int uid, String date) {
        this.rid = rid;
        this.uid = uid;
        this.date = date;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Favorite{" +
                "rid=" + rid +
                ", uid=" + uid +
                ", date='" + date + '\'' +
                '}';
    }
}
