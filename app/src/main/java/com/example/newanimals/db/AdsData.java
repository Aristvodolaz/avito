package com.example.newanimals.db;

public class AdsData {
    String name;
    String date;
    String address;
    String price;

    String img;

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getAddress() {
        return address;
    }

    public String getPrice() {
        return price;
    }

    public String getImg() {
        return img;
    }

    public AdsData(String name, String date, String address, String price, String img) {
        this.name = name;
        this.date = date;
        this.address = address;
        this.price = price;
        this.img = img;
    }
}
