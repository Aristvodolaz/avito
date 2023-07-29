package com.example.newanimals.db;

public class BiznesData {
    public String user;
    public String type_ads;
    public  String vid_ads;
    public  String date_publish;
    public  String name_ads;
    public  String file_img;
    public  String type_biznes;
    public String description;
    public String transaction;
    public String price;
    public  String address;

    public BiznesData(String user, String type_ads, String vid_ads, String date_publish, String name_ads, String file_img, String type_biznes, String description, String transaction, String price, String address) {
        this.user = user;
        this.type_ads = type_ads;
        this.vid_ads = vid_ads;
        this.date_publish = date_publish;
        this.name_ads = name_ads;
        this.file_img = file_img;
        this.type_biznes = type_biznes;
        this.description = description;
        this.transaction = transaction;
        this.price = price;
        this.address = address;
    }
}
