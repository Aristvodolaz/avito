package com.example.newanimals.presenter;

import com.example.newanimals.db.BiznesData;
import com.example.newanimals.db.CarData;
import com.example.newanimals.db.HouseData;
import com.example.newanimals.db.ServiceData;
import com.example.newanimals.db.WorkData;
import com.example.newanimals.utils.WriteFirebaseRXUtil;
import com.example.newanimals.view.WriteDataInFirebaseView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class WriteDataInFirebasePresenter {
    private WriteDataInFirebaseView view;

    public WriteDataInFirebasePresenter(WriteDataInFirebaseView view) {
        this.view = view;
    }

    public void postDataInDBCar(CarData data){
        FirebaseFirestore database = FirebaseFirestore.getInstance();
        CollectionReference ref = database.collection("AdsData");

        WriteFirebaseRXUtil.saveDataToFirebase(ref,data)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                    }

                    @Override
                    public void onComplete() {
                        view.sendMessage("Объявление успешно опубликовано!");
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        view.sendMessage(e.getLocalizedMessage());
                    }
                });
    }


    public void postDataInDBHouse(HouseData data){
        FirebaseFirestore database = FirebaseFirestore.getInstance();
        CollectionReference ref = database.collection("AdsData");

        WriteFirebaseRXUtil.saveDataToFirebase(ref,data)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                    }

                    @Override
                    public void onComplete() {
                        view.sendMessage("Объявление успешно опубликовано!");
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        view.sendMessage(e.getLocalizedMessage());
                    }
                });
    }

    public void postDataInDBBiznes(BiznesData data){
        FirebaseFirestore database = FirebaseFirestore.getInstance();
        CollectionReference ref = database.collection("AdsData");

        WriteFirebaseRXUtil.saveDataToFirebase(ref,data)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                    }

                    @Override
                    public void onComplete() {
                        view.sendMessage("Объявление успешно опубликовано!");
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        view.sendMessage(e.getLocalizedMessage());
                    }
                });
    }

}
