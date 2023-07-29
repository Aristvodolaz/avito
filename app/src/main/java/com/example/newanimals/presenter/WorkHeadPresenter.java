package com.example.newanimals.presenter;

import android.net.Uri;

import com.example.newanimals.db.WorkData;
import com.example.newanimals.db.WorkHeadData;
import com.example.newanimals.utils.UploadStrogePhotoRXUtil;
import com.example.newanimals.utils.WriteFirebaseRXUtil;
import com.example.newanimals.view.WorkHeadView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class WorkHeadPresenter {
    private WorkHeadView view;

    public WorkHeadPresenter(WorkHeadView view) {
        this.view = view;
    }
    public void uploadPhoto(Uri img, String file){
        UploadStrogePhotoRXUtil.uploadePhoto(img, file).subscribe(
                ()-> {view.onUpploadSuccess("Фотография загружена");},
                error ->{
                    view.onMessage(error.getLocalizedMessage());
                }
        );
    }
    public void postDataInDBWorkHead(WorkHeadData data){
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
                        view.successAddAds("Объявление успешно опубликовано!");
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        view.onMessage(e.getLocalizedMessage());
                    }
                });
    }
}
