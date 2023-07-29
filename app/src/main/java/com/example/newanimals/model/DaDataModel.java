package com.example.newanimals.model;

import com.example.newanimals.network.BaseDataProvider;
import com.example.newanimals.network.response.DaDataResponse;

import rx.Observable;

public class DaDataModel extends BaseDataProvider {

    public Observable<DaDataResponse> getAddressForDialog(String query){
        return serviceDaDataAddress.getAddressForDialog(query).compose(applySchedulers());
    }
}
