package com.example.jspjstl2;

public class Stuff {
    private String id;
    private String name;
    private String prize;
    private boolean status;
    private String url;
    public Stuff(String id, String name, String prize, boolean status,String url) {
        this.id = id;
        this.name = name;
        this.prize = prize;
        this.status = status;
        this.url = url;
    }
    public Stuff(String id, String name, String prize,String url) {
        this.id = id;
        this.name = name;
        this.prize = prize;
        this.url = url;
    }
    public Stuff(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrize() {
        return prize;
    }

    public void setPrize(String prize) {
        this.prize = prize;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
