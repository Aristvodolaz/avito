package com.example.newanimals.utils;

import com.google.firebase.firestore.CollectionReference;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.schedulers.Schedulers;


public class WriteFirebaseRXUtil {
    public static <T> Completable saveDataToFirebase(final CollectionReference ref, T data){
        return Completable.create(emitter -> {
            ref.add(data)
                    .addOnSuccessListener(documentReference -> {
                        emitter.onComplete();
                    })
                    .addOnFailureListener(emitter::onError);
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

}
