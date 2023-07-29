package com.example.newanimals.db;

public class WorkData {
    public  String user;
    public String type_ads;
    public String vid_ads;
    public String date_publish;
    public String nameAds;
    public String sfera;
    public String file_img;
    public String pol;
    public String date_birth;
    public String grazhdanstvo;
    public String type_zanytosty;
    public String status_poiska;
    public String exit_work;

    public WorkData(String user, String type_ads, String vid_ads, String date_publish, String nameAds, String sfera, String file_img, String pol, String date_birth, String grazhdanstvo, String type_zanytosty, String status_poiska, String exit_work) {
        this.user = user;
        this.type_ads = type_ads;
        this.vid_ads = vid_ads;
        this.date_publish = date_publish;
        this.nameAds = nameAds;
        this.sfera = sfera;
        this.file_img = file_img;
        this.pol = pol;
        this.date_birth = date_birth;
        this.grazhdanstvo = grazhdanstvo;
        this.type_zanytosty = type_zanytosty;
        this.status_poiska = status_poiska;
        this.exit_work = exit_work;
    }
}
