package com.example.bai2jspjstl;

import java.io.Serializable;

public class People implements Serializable {
    private String name;
    private String date;
    private String address;
    private String URL;

    public People(String name, String date, String address, String URL) {
        this.name = name;
        this.date = date;
        this.address = address;
        this.URL = URL;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }
}
