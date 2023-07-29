package com.example.newanimals.db;

public class ServiceData {
   public String user;
    public  String type_ads;
    public String date_publish;
    public String nameAds;
    public String categoria;
    public String file_img;
    public String description;
    public String price;
    public String type_price;
    public String address;
    public String nachPrice;

    public ServiceData(String user, String type_ads,  String date_publish, String nameAds, String categoria, String file_img, String description, String price, String type_price, String address, String nachPrice) {
        this.user = user;
        this.type_ads = type_ads;
        this.date_publish = date_publish;
        this.nameAds = nameAds;
        this.categoria = categoria;
        this.file_img = file_img;
        this.description = description;
        this.price = price;
        this.type_price = type_price;
        this.address = address;
        this.nachPrice = nachPrice;
    }
}
