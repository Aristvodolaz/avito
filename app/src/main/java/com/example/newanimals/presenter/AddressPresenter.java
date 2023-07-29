package com.example.newanimals.presenter;

import com.example.newanimals.model.DaDataModel;
import com.example.newanimals.network.response.DaDataResponse;
import com.example.newanimals.view.AddressView;

import rx.Subscriber;

public class AddressPresenter {
    private AddressView view;

    public AddressPresenter(AddressView view) {
        this.view = view;
    }

    private DaDataModel model = new DaDataModel();

    public void getFullNameAddress(String address){
        model.getAddressForDialog(address).subscribe(new Subscriber<DaDataResponse>() {
            @Override public void onCompleted() { }

            @Override
            public void onError(Throwable e) {
                view.errorMessage("Ошибка получения данных");
            }

            @Override
            public void onNext(DaDataResponse response) {
                view.getAddress(response.getSuggestions());
            }
        });
    }
}
