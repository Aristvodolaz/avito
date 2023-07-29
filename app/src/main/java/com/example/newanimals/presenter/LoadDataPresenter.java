package com.example.newanimals.presenter;

import com.example.newanimals.db.AdsData;
import com.example.newanimals.utils.ReadFirebaseRXUtil;
import com.example.newanimals.utils.SPHelper;
import com.example.newanimals.view.LoadDataView;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

public class LoadDataPresenter {
    private LoadDataView view;

    public LoadDataPresenter(LoadDataView view) {
        this.view = view;
    }

    public void getDataFromDBForUser(){
        FirebaseFirestore firestore = FirebaseFirestore.getInstance();
        CollectionReference reference = firestore.collection("AdsData");
        ReadFirebaseRXUtil.observeValueEvent(reference)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<QuerySnapshot>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull QuerySnapshot queryDocumentSnapshots) {
                        List<AdsData> itemList = new ArrayList<>();
                        if (queryDocumentSnapshots != null && !queryDocumentSnapshots.isEmpty()) {
                      for(int i = 0 ; i< queryDocumentSnapshots.getDocuments().size(); i++){
                                if(queryDocumentSnapshots.getDocuments().get(i).getString("user").equals(SPHelper.getLogin())){
                                    String nameAds = queryDocumentSnapshots.getDocuments().get(i).getString("nameAds");
                                    String price = queryDocumentSnapshots.getDocuments().get(i).getString("price");
                                    String date = queryDocumentSnapshots.getDocuments().get(i).getString("date_publish");
                                    String img = queryDocumentSnapshots.getDocuments().get(i).getString("file_img");
                                    String address = queryDocumentSnapshots.getDocuments().get(i).getString("address");
                                    AdsData data = new AdsData(nameAds, date, address,price, img);
                                    itemList.add(data);
                                }
                            }
                        }
                        view.getData(itemList);

                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        view.getMessage(e.getLocalizedMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
    public void getDataFromDB(){
        FirebaseFirestore firestore = FirebaseFirestore.getInstance();
        CollectionReference reference = firestore.collection("AdsData");
        ReadFirebaseRXUtil.observeValueEvent(reference)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<QuerySnapshot>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull QuerySnapshot queryDocumentSnapshots) {
                        List<AdsData> itemList = new ArrayList<>();
                        if (queryDocumentSnapshots != null && !queryDocumentSnapshots.isEmpty()) {
                            for(int i = 0 ; i< queryDocumentSnapshots.getDocuments().size(); i++){
                                    String nameAds = queryDocumentSnapshots.getDocuments().get(i).getString("nameAds");
                                    String price = queryDocumentSnapshots.getDocuments().get(i).getString("price");
                                    String date = queryDocumentSnapshots.getDocuments().get(i).getString("date_publish");
                                    String img = queryDocumentSnapshots.getDocuments().get(i).getString("file_img");
                                    String address = queryDocumentSnapshots.getDocuments().get(i).getString("address");
                                    AdsData data = new AdsData(nameAds, date, address,price, img);
                                    itemList.add(data);
                            }
                        }
                        view.getData(itemList);

                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        view.getMessage(e.getLocalizedMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
