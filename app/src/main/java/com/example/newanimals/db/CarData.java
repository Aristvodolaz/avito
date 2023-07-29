package com.example.newanimals.db;

public class CarData {
    String user;
    String type_ads;
    String vid_ads;
    String data_publish;
    String file_img;
    String name_ads;
    String address;
    String mark;
    String code_vin;
    String years;
    String type_dvigatel;
    String corobka;
    String sostoyanie;
    String probeg;
    String pts;
    String price;

    public CarData(String user, String type_ads, String vid_ads, String data_publish, String file_img, String name_ads, String address, String mark, String code_vin, String years, String type_dvigatel, String corobka, String sostoyanie, String probeg, String pts, String price) {
        this.user = user;
        this.type_ads = type_ads;
        this.vid_ads = vid_ads;
        this.data_publish = data_publish;
        this.file_img = file_img;
        this.name_ads = name_ads;
        this.address = address;
        this.mark = mark;
        this.code_vin = code_vin;
        this.years = years;
        this.type_dvigatel = type_dvigatel;
        this.corobka = corobka;
        this.sostoyanie = sostoyanie;
        this.probeg = probeg;
        this.pts = pts;
        this.price = price;
    }
}
