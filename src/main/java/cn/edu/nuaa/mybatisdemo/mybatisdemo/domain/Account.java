package cn.edu.nuaa.mybatisdemo.mybatisdemo.domain;

public class Account {
    private int id;
    private int uid;
    private double money;
    private User user;//一对一映射

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return super.toString()+"{Account{" +
                "id=" + id +
                ", uid=" + uid +
                ", monery=" + money +
                ", user=" + user +
                "}}";
    }
}
