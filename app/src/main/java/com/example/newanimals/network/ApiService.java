package com.example.newanimals.network;

import com.example.newanimals.network.response.DaDataResponse;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface ApiService {
    @GET(Const.ADDRESS_DADATA)
    Observable<DaDataResponse> getAddressForDialog(@Query("query") String query);
}
