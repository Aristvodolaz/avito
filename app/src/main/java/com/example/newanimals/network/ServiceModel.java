package com.example.newanimals.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
public class ServiceModel {

    private static ServiceModel instance;

    private Gson gson;
    private ServiceModel(){}

    public static ServiceModel getInstance() {
        if(instance == null) {
            instance = new ServiceModel();
            instance.setGson(new GsonBuilder().create());
        }
        return instance;
    }
    public ApiService getServiceAddress(){ return getDaDataService(Const.DADATA_API_ADDRESS, ApiService.class);}

    public <T> T getDaDataService(String url, final Class<T> service) {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(60, TimeUnit.SECONDS).connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS).addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request original = chain.request();
                        Request request = original.newBuilder()
                                .header("Content-Type", "application/json")
                                .addHeader("Authorization", Const.DADATA_TOKEN)
                                .method(original.method(), original.body())
                                .build();

                        return chain.proceed(request);
                    }
                }).build();
        return new Retrofit.Builder()
                .baseUrl(url)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .build().create(service);
    }

    public void setGson(Gson gson) {
        this.gson = gson;
    }
}
