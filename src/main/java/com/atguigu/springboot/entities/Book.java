package com.atguigu.springboot.entities;

public class Book {
    private Integer bid;
    private String bName;
    private String publish;
    private Integer store;
    private String author ;
    private Integer money;
    private Integer num;

    public Book() {
    }

    public Book(Integer bid, String bName, String publish, Integer store, String author, Integer money, Integer num) {
        this.bid = bid;
        this.bName = bName;
        this.publish = publish;
        this.store = store;
        this.author = author;
        this.money = money;
        this.num = num;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName;
    }

    public String getPublish() {
        return publish;
    }

    public void setPublish(String publish) {
        this.publish = publish;
    }

    public Integer getStore() {
        return store;
    }

    public void setStore(Integer store) {
        this.store = store;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bid=" + bid +
                ", bName='" + bName + '\'' +
                ", publish='" + publish + '\'' +
                ", store=" + store +
                ", author='" + author + '\'' +
                ", money=" + money +
                ", num=" + num +
                '}';
    }
}
