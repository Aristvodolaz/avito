package com.example.newanimals.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.newanimals.ApplicationLoader;

public class SPHelper {
    public static final String FILE_NAME = "shop";
    public static final String NAME = "name";
    public static final String SURNAME = "surname";
    public static final String PHONE = "PHONE";
    public static final String DATE = "DATE";
    public static final String CITY = "CITY";
    public static final String TYPE = "TYPE";
    public static final String NAMETYPE = "NAMETYPE";
    public static final String LOGIN = "LOGIN";


    public static final String LAT = "lat";
    public static final String LON = "lon";

    public static final String URL_PHOTO = "url_photo";

    public static final String TYPE_ADS = "type_ads";
    public static final String VID_ADS = "vid_ads";
    public static final String SALE_TYPE = "sale_type";
    public static final String NAME_ADS = "name_ds";

    public static final String OPISANIE_FOR_WORK_HEAD ="work_descp";
    public static final String SFERA_ZANITOSTY ="sfeara";



    private static SharedPreferences getPrefs() {
        return ApplicationLoader.getInstance().getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
    }

    private static SharedPreferences.Editor getEdit() {
        return getPrefs().edit();
    }

    public static class ServiceHelper{
        public static final String CATEGORY_SERVICE ="servicetype";
        public static final String NAME_SERVICE = " namesrvise";

        public static void setCategoryService(String name) {
            getEdit().putString(CATEGORY_SERVICE, name).commit();
        }
        public static String getCategoryService() {
            return getPrefs().getString(CATEGORY_SERVICE, "");
        }

        public static void setNameService(String name) {
            getEdit().putString(NAME_SERVICE, name).commit();
        }
        public static String getNameService() {
            return getPrefs().getString(NAME_SERVICE, "");
        }
    }
    public static class BizznesHelper {
        public static final String NAME_CATEGORY_FOR_BIZNES ="categoru_name";
        public static final String TYPE_BIZNES ="typebiznes";
        public static final String DESCRIPTION_BIZNES ="secriptionbiz";
        public static final String CHOOSE_TRANSACTION ="shosetransbiz";
        public static final String PRICE_BIZNES ="pricebiz";
        public static final String ADDRESS_BIZNES ="adr_bbix";
        public static final String URL_PHOTO_BIZNES = "biz_ph";
        public static void setNameCategoryForBiznes(String name) {
            getEdit().putString(NAME_CATEGORY_FOR_BIZNES, name).commit();
        }
        public static String getNameCategoryForBiznes() {
            return getPrefs().getString(NAME_CATEGORY_FOR_BIZNES, "");
        }
        public static void setTypeBiznes(String name) {
            getEdit().putString(TYPE_BIZNES, name).commit();
        }
        public static String getTypeBiznes() {
            return getPrefs().getString(TYPE_BIZNES, "");
        }
        public static void setDescriptionBiznes(String name) {
            getEdit().putString(DESCRIPTION_BIZNES, name).commit();
        }
        public static String getDescriptionBiznes() {
            return getPrefs().getString(DESCRIPTION_BIZNES, "");
        }
        public static void setChooseTransaction(String name) {
            getEdit().putString(CHOOSE_TRANSACTION, name).commit();
        }
        public static String getChooseTransaction() {
            return getPrefs().getString(CHOOSE_TRANSACTION, "");
        }
        public static void setPriceBiznes(String name) {
            getEdit().putString(PRICE_BIZNES, name).commit();
        }
        public static String getPriceBiznes() {
            return getPrefs().getString(PRICE_BIZNES, "");
        }
        public static void setUrlPhotoBiznes(String name) {
            getEdit().putString(URL_PHOTO_BIZNES, name).commit();
        }
        public static String getUrlPhotoBiznes() {
            return getPrefs().getString(URL_PHOTO_BIZNES, "");
        }
        public static void setAddressBiznes(String name) {
            getEdit().putString(PRICE_BIZNES, name).commit();
        }
        public static String getAddressBiznes() {
            return getPrefs().getString(ADDRESS_BIZNES, "");
        }
    }

    public static void setSferaZanitosty(String name) {
        getEdit().putString(SFERA_ZANITOSTY, name).commit();
    }
    public static String getSferaZanitosty() {
        return getPrefs().getString(SFERA_ZANITOSTY, "");
    }

    public static void setOpisanieForWorkHead(String name) {
        getEdit().putString(OPISANIE_FOR_WORK_HEAD, name).commit();
    }
    public static String getOpisanieForWorkHead() {
        return getPrefs().getString(OPISANIE_FOR_WORK_HEAD, "");
    }
    public static void setNameAds(String name) {
        getEdit().putString(NAME_ADS, name).commit();
    }
    public static String getNameAds() {
        return getPrefs().getString(NAME_ADS, "");
    }

    public static void setName(String name) {
        getEdit().putString(NAME, name).commit();
    }
    public static String getName() {
        return getPrefs().getString(NAME, "");
    }

    public static void setTypeAds(String name){
        getEdit().putString(TYPE_ADS, name).commit();
    }
    public static String getTypeAds(){
        return getPrefs().getString(TYPE_ADS, "");
    }
    public static void setSaleType(String name){
        getEdit().putString(SALE_TYPE, name).commit();
    }
    public static String getSaleType(){
       return getPrefs().getString(SALE_TYPE, "");
    }

    public static void setVidAds(String name){
        getEdit().putString(VID_ADS, name).commit();
    }
    public static String getVidAds(){
        return getPrefs().getString(VID_ADS, "");
    }

    public static String getSurname() {
        return getPrefs().getString(SURNAME, "");
    }
    public static void setSurname(String name) {getEdit().putString(SURNAME, name).commit();}

    public static void setPhone(String phone) {
        getEdit().putString(PHONE, phone).commit();
    }
    public static String getPhone() {
        return getPrefs().getString(PHONE, "");
    }

    public static String getDate() {
        return getPrefs().getString(DATE, "");
    }
    public static void setDate(String date) {
        getEdit().putString(DATE, date).commit();
    }

    public static void setCity(String city) {
        getEdit().putString(CITY, city).commit();
    }
    public static String getCity() {
        return getPrefs().getString(CITY, "");
    }

    public static void setType(String type) {
        getEdit().putString(TYPE, type).commit();
    }
    public static String getType() {
        return getPrefs().getString(TYPE, "");
    }

    public static void setUrlPhotoDownload(String type) {
        getEdit().putString(URL_PHOTO, type).commit();
    }
    public static String getUrlPhotoDownload() {
        return getPrefs().getString(URL_PHOTO, "");
    }

    public static void setLat(float lat) {
        getEdit().putFloat(LAT, lat).commit();
    }

    public static Float getLat() {
        return getPrefs().getFloat(LAT, 0);
    }

    public static void setLon(float lon) {
        getEdit().putFloat(LON, lon).commit();
    }

    public static Float getLon() {
        return getPrefs().getFloat(LON, 0);
    }

    public static void setNametype(String lat) {
        getEdit().putString(NAMETYPE, lat).commit();
    }
    public static String getNametype() {
        return getPrefs().getString(NAMETYPE, "");
    }

    public static void setLogin(String lat) {
        getEdit().putString(LOGIN, lat).commit();
    }
    public static String getLogin() {
        return getPrefs().getString(LOGIN, "");
    }
}
